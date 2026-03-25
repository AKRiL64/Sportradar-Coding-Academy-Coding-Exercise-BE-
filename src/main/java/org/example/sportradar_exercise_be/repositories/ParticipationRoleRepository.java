package org.example.sportradar_exercise_be.repositories;

import org.example.sportradar_exercise_be.entities.ParticipationRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipationRoleRepository extends JpaRepository<ParticipationRole, Long> {}
