package org.example.sportradar_exercise_be.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/// After the end of the event, holds information about goals of a specific team
@Entity
@Table(name = "result")
@Getter
@Setter
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int goals;
    @ManyToOne
    @JoinColumn(name = "_idParticipation")
    private Participation participation;
}
