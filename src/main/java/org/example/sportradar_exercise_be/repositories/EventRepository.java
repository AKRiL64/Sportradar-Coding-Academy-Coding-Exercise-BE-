package org.example.sportradar_exercise_be.repositories;

import org.example.sportradar_exercise_be.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("SELECT distinct e FROM Event e " +
            "LEFT JOIN FETCH e.stadium " +
            "LEFT JOIN FETCH e.eventStatus " +
            "LEFT JOIN FETCH e.participations p " +
            "LEFT JOIN FETCH p.team " +
            "LEFT JOIN FETCH p.participationRole")
    Iterable<Event> findAllEvents();
}
