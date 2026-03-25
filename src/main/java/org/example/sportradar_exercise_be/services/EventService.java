package org.example.sportradar_exercise_be.services;

import jakarta.transaction.Transactional;
import org.example.sportradar_exercise_be.entities.Event;
import org.example.sportradar_exercise_be.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/// Service for managing event repository
@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEventsWithDetails() {
        return eventRepository.findAllEventsWithDetails();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("ERROR. Id for event is invalid. ID: " + id)
        );
    }

    @Transactional
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
