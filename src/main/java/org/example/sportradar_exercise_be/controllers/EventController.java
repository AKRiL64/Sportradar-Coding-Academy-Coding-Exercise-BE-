package org.example.sportradar_exercise_be.controllers;

import org.example.sportradar_exercise_be.entities.Event;
import org.example.sportradar_exercise_be.entities.Participation;
import org.example.sportradar_exercise_be.repositories.*;
import org.example.sportradar_exercise_be.services.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/// A controller for handling HTTP requests related to events
/// It covers:
/// Getting all events to show a calendar with /events
/// Getting a single event with /events/{id}
/// Creating a new event with /events/new
/// Saving event by navigating it into the /events
@Controller
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    private final StadiumRepository stadiumRepository;
    private final EventStatusRepository eventStatusRepository;
    private final TeamRepository teamRepository;
    private final ParticipationRepository participationRepository;
    private final ParticipationRoleRepository roleRepository;

    private final String eventsCalendar = "events_calendar";
    private final String addEvent = "add_event";
    private final String eventDetails = "event_details";



    // Update your constructor to include it!
    public EventController(EventService eventService, StadiumRepository stadiumRepository,
                           EventStatusRepository eventStatusRepository, TeamRepository teamRepository,
                           ParticipationRepository participationRepository,
                           ParticipationRoleRepository roleRepository) {
        this.eventService = eventService;
        this.stadiumRepository = stadiumRepository;
        this.eventStatusRepository = eventStatusRepository;
        this.teamRepository = teamRepository;
        this.participationRepository = participationRepository;
        this.roleRepository = roleRepository;
    }

    /// Main page with all events
    @GetMapping
    public String viewAllEvents(Model model) {
        List<Event> events = eventService.getAllEventsWithDetails();
        model.addAttribute("events", events);
        return eventsCalendar;
    }

    /// Page for viewing a single event
    @GetMapping("/{id}")
    public String viewEventDetails(Model model, @PathVariable Long id) {
        Event event = eventService.getEventById(id);
        model.addAttribute("event", event);
        return eventDetails;
    }

    /// Page for creating new event
    @GetMapping("/new")
    public String createEvent(Model model) {
        model.addAttribute("event", new Event());

        model.addAttribute("stadiums", stadiumRepository.findAll());
        model.addAttribute("eventStatuses", eventStatusRepository.findAll());
        model.addAttribute("teams", teamRepository.findAll());
        model.addAttribute("participationRoles", participationRepository.findAll());
        return addEvent;
    }

    /// Get for new event
    @PostMapping
    public String addEvent(@ModelAttribute("event") Event event,
                           @RequestParam("homeTeamId") Long homeTeamId,
                           @RequestParam("awayTeamId") Long awayTeamId) {

        Event savedEvent = eventService.saveEvent(event);

        Participation homePart = new Participation();
        homePart.setEvent(savedEvent);
        homePart.setTeam(teamRepository.findById(homeTeamId).orElse(null));
        homePart.setParticipationRole(roleRepository.findById(1L).orElse(null));
        participationRepository.save(homePart);

        Participation awayPart = new Participation();
        awayPart.setEvent(savedEvent);
        awayPart.setTeam(teamRepository.findById(awayTeamId).orElse(null));
        awayPart.setParticipationRole(roleRepository.findById(2L).orElse(null));
        participationRepository.save(awayPart);

        return "redirect:/events";
    }
}
