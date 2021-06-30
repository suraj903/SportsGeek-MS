package com.project.sportsgeek.matches.controller;

import com.project.sportsgeek.matches.model.Tournament;
import com.project.sportsgeek.matches.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping(path = "/tournaments", produces = MediaType.APPLICATION_JSON_VALUE)
public class TournamentController {

    @Autowired
    TournamentService tournamentService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tournament> getAllTournament() {
        List<Tournament> tournamentList = tournamentService.findAllTournament();
        return tournamentList;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Tournament addTournament(@RequestBody(required = true) @Valid Tournament Tournament) throws Exception {
        Tournament tournament = tournamentService.addTournament(Tournament);
        return tournament;
    }

    @PutMapping(value = "/{tournamentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Tournament updateTournament(@PathVariable @Valid @Pattern(regexp = "[0-9]*") int tournamentId, @RequestBody(required = true) @Valid Tournament tournament) throws Exception {
        Tournament t = tournamentService.updateTournament(tournamentId, tournament);
        return t;
    }

    @DeleteMapping(value = "/{tournamentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteTournamentById(@PathVariable @Valid @Pattern(regexp = "[0-9]*") int tournamentId) throws Exception {
        String result = tournamentService.deleteTournament(tournamentId);
        return result;
    }
}
