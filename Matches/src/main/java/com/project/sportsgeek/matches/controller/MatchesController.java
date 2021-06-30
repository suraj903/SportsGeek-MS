package com.project.sportsgeek.matches.controller;

import com.project.sportsgeek.matches.model.Matches;
import com.project.sportsgeek.matches.model.MatchesWithVenue;
import com.project.sportsgeek.matches.service.MatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping(path = "/matches", produces = MediaType.APPLICATION_JSON_VALUE)
public class MatchesController {

    @Autowired
    MatchesService matchesService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MatchesWithVenue> getAllMatches() throws Exception {
        List<MatchesWithVenue> matchesList = matchesService.findAllMatches();
        return matchesList;
    }

    @GetMapping(value = "/{matchId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MatchesWithVenue getMatchesById(@PathVariable @Valid @Pattern(regexp = "[0-9]*") int matchId) throws Exception {
        MatchesWithVenue matchesList = matchesService.findMatchesById(matchId);
        return matchesList;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Object addMatches(@RequestBody(required = true) @Valid Matches matches) throws Exception {
        System.out.println(matches);
        Object matchesResult = matchesService.addMatches(matches);
        return matchesResult;
    }

    @PutMapping(value = "/{matchId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Matches updateMatches(@PathVariable @Valid @Pattern(regexp = "[0-9]*") int matchId, @RequestBody(required = true) @Valid Matches matches) throws Exception {
        Matches matchResult = matchesService.updateMatch(matchId, matches);
        return matchResult;
    }

    @DeleteMapping(value = "/{matchId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object deleteMatchById(@PathVariable @Valid @Pattern(regexp = "[0-9]*") int matchId) throws Exception {
        Object result = matchesService.deleteMatch(matchId);
        return result;
    }
}
