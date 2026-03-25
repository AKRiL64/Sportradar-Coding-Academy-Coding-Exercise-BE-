package org.example.sportradar_exercise_be.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "event")
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int season;
    private int timeUTC;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "_idEventStatus")
    private EventStatus eventStatus;
    @ManyToOne
    @JoinColumn(name = "_idStadium", nullable = true)
    private Stadium stadium;
    @OneToMany(mappedBy = "event")
    private List<Participation> participations;
}
