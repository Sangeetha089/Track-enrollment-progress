package com.ironlady.participant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ironlady.participant.model.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}