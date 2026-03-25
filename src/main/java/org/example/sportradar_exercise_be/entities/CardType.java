package org.example.sportradar_exercise_be.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/// Card types: First Yellow, Second Yellow, Red
@Entity
@Table(name = "card_type")
@Getter
@Setter
public class CardType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
