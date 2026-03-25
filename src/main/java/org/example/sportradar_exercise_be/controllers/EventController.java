package org.example.sportradar_exercise_be.controllers;

import org.example.sportradar_exercise_be.entities.Event;
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

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public String viewAllEvents(Model model) {
        List<Event> events = eventService.getAllEventsWithDetails();
        model.addAttribute("events", events);
        return "events";
    }

    @GetMapping("/{id}")
    public String viewEventDetails(Model model, @PathVariable Long id) {
        Event event = eventService.getEventById(id);
        model.addAttribute("event", event);
        return "event-details";
    }

    @GetMapping("/new")
    public String createEvent(Model model) {
        model.addAttribute("event", new Event());
        return "create-event";
    }

    @PostMapping
    public String addEvent(@ModelAttribute("event") Event event) {
        eventService.saveEvent(event);
        return "redirect:/events";
    }
}
