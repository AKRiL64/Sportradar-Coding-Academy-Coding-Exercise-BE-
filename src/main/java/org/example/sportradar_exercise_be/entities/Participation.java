package org.example.sportradar_exercise_be.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/// Entity for handling many-to-many connection between teams participating and events
@Entity
@Table(name = "participation")
@Getter
@Setter
public class Participation {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "_idTeam")
    private Team team;
    @ManyToOne
    @JoinColumn(name = "_idEvent")
    private Event event;
    @ManyToOne
    @JoinColumn(name = "_idParticipationRole")
    private ParticipationRole participationRole;
}
