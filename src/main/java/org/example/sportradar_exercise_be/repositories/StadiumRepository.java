package org.example.sportradar_exercise_be.repositories;

import org.example.sportradar_exercise_be.entities.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long> {}
