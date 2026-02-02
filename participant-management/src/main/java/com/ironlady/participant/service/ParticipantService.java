package com.ironlady.participant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ironlady.participant.model.Participant;
import com.ironlady.participant.repository.ParticipantRepository;

@Service
public class ParticipantService {

    private final ParticipantRepository repository;

    public ParticipantService(ParticipantRepository repository) {
        this.repository = repository;
    }

    public Participant create(Participant participant) {
        return repository.save(participant);
    }

    public List<Participant> getAll() {
        return repository.findAll();
    }

    public Participant getOne(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Participant not found"));
    }

    public Participant update(Long id, Participant updated) {
        Participant existing = getOne(id);
        existing.setFullName(updated.getFullName());
        existing.setEmail(updated.getEmail());
        existing.setPhone(updated.getPhone());
        existing.setProgramName(updated.getProgramName());
        existing.setStatus(updated.getStatus());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}