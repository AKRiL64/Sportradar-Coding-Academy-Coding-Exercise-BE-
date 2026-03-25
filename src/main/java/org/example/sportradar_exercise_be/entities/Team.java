package org.example.sportradar_exercise_be.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "team")
@Getter
@Setter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String officialName;
    private String slug;
    @ManyToOne
    @JoinColumn(name = "_idCountry")
    private Country country;
    @ManyToOne
    @JoinColumn(name = "_idSport")
    private Sport sport;
}
