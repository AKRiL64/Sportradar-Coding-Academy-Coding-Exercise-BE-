package org.example.sportradar_exercise_be.repositories;

import org.example.sportradar_exercise_be.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    /// Get all necessary information the event is bound with
    @Query("SELECT distinct e FROM Event e " +
            "LEFT JOIN FETCH e.stadium " +
            "LEFT JOIN FETCH e.eventStatus " +
            "LEFT JOIN FETCH e.participations p " +
            "LEFT JOIN FETCH p.team " +
            "LEFT JOIN FETCH p.participationRole")
    List<Event> findAllEventsWithDetails();
}
