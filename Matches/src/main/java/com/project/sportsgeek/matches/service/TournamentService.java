package com.project.sportsgeek.matches.service;


import com.project.sportsgeek.matches.model.Tournament;
import com.project.sportsgeek.matches.tournamentrepo.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {

    @Autowired
    @Qualifier("tournamentRepo")
    TournamentRepository tournamentRepository;

    @Value("${matchidYaml}")
    String v;

    public List<Tournament> findAllTournament() {
        List<Tournament> tournamentList = tournamentRepository.findAllTournament();
        return tournamentList;
    }

    public Tournament findTournamentById(int tournamentId) throws Exception {
        Tournament tournament = tournamentRepository.findTournamentById(tournamentId);
        if (tournament != null) {
            return tournament;
        }
        throw new Exception(String.format(v, tournamentId));
    }

    public Tournament addTournament(Tournament tournament) throws Exception {
        int id = tournamentRepository.addTournament(tournament);
        if (id > 0) {
            tournament.setTournamentId(id);
            return tournament;
        }
        throw new Exception("Unable to add Tournament.");
    }

    public Tournament updateTournament(int tournamentId, Tournament tournament) throws Exception {
        if (tournamentRepository.updateTournament(tournamentId, tournament)) {
            return tournament;
        }
        throw new Exception(String.format(v, tournamentId));
    }

    public String deleteTournament(int tournamentId) throws Exception {
        if (tournamentRepository.deleteTournament(tournamentId)) {
            return "Tournament deleted successfully";
        }
        throw new Exception(String.format(v, tournamentId));
    }
}
