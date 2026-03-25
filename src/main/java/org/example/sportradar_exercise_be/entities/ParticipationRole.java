package org.example.sportradar_exercise_be.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/// Participation roles: Home, Away
@Entity
@Table(name = "participation_role")
@Getter
@Setter
public class ParticipationRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
