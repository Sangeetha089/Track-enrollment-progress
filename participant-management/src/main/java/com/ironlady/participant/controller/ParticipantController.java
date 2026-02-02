package com.ironlady.participant.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ironlady.participant.model.Participant;
import com.ironlady.participant.service.ParticipantService;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {

    private final ParticipantService service;

    public ParticipantController(ParticipantService service) {
        this.service = service;
    }

    @PostMapping
    public Participant create(@RequestBody Participant participant) {
        return service.create(participant);
    }

    @GetMapping
    public List<Participant> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Participant getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PutMapping("/{id}")
    public Participant update(@PathVariable Long id, @RequestBody Participant participant) {
        return service.update(id, participant);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}