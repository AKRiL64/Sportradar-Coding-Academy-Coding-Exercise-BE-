package org.example.sportradar_exercise_be.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

@Entity
@Table(name = "card")
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private Long timeOfTheMatch;
    @ManyToOne
    @JoinColumn(name = "_idCardType")
    private CardType cardType;
    @ManyToOne
    @JoinColumn(name = "_idParticipation")
    private Participation participation;
}
