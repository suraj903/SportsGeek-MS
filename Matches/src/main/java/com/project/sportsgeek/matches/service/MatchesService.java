package com.project.sportsgeek.matches.service;

import com.project.sportsgeek.matches.matchesrepo.MatchesRepository;
import com.project.sportsgeek.matches.model.CustomHttpErrorResponse;
import com.project.sportsgeek.matches.model.Matches;
import com.project.sportsgeek.matches.model.MatchesWithVenue;
import com.project.sportsgeek.matches.model.Tournament;
import com.project.sportsgeek.matches.tournamentrepo.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MatchesService {
    @Autowired
    @Qualifier("matchesRepo")
    MatchesRepository matchesRepository;

    @Autowired
    @Qualifier("tournamentRepo")
    TournamentRepository tournamentRepository;

    @Value("${matchidYaml}")
    String v;

    @Value("${deletedResponse}")
    String deletedMsg;

    @Value("${sucessful}")
    Integer success;

    @Value("${created}")
    Integer created;

    @Value("${insertedResponse}")
    String insertedResponse;

    public List<MatchesWithVenue> findAllMatches() throws Exception {
        Tournament tournament = tournamentRepository.findTournamentByActive();
        if (tournament != null) {
            List<MatchesWithVenue> matchesList = matchesRepository.findAllMatches(tournament.getTournamentId());
            return matchesList;
        }
//        throw new ResultException(new Result<>(404, "Unable to find any matches."));
        throw new Exception("Unable to find any matches.");
    }

    public MatchesWithVenue findMatchesById(int matchId) throws Exception {
        MatchesWithVenue matchesWithVenue = matchesRepository.findMatchesById(matchId);
        if (matchesWithVenue != null) {
//            return new Result<>(200, matchesWithVenue);
            return matchesWithVenue;
        }
//        throw new ResultException(new Result<>(404, String.format(v,matchId)));
        throw new Exception(String.format(v, matchId));
//        return new Result<>(404, "match with matchid not found");
    }

    public Object addMatches(Matches matches) throws Exception {
        int matchId = matchesRepository.addMatch(matches);
        if (matchId > 0) {
            matches.setMatchId(matchId);
//            return new Result<>(201, matches);
//            return matches;
            CustomHttpErrorResponse cr = new CustomHttpErrorResponse(new Date(),created,String.format(insertedResponse, matchId));
            return cr;
        }
//        throw new ResultException(new Result<>(404, "Unable to add Match"));
        throw new Exception("unable to add match");
    }

    public Matches updateMatch(int matchId, Matches matches) throws Exception {
        if (matchesRepository.updateMatch(matchId, matches)) {
//            return new Result<>(200, matches);
            return matches;
        }
        throw new Exception(String.format(v, matchId));
    }

    public Object deleteMatch(int matchId) throws Exception {
        if (matchesRepository.deleteMatches(matchId)) {
//            return new Result<>(200,"Match Deleted Successfully");
            CustomHttpErrorResponse cr = new CustomHttpErrorResponse(new Date(),success,String.format(deletedMsg, matchId));
            return cr;
        }
        throw new Exception(String.format(v, matchId));
    }
}
