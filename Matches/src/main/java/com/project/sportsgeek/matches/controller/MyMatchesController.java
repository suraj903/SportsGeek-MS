package com.project.sportsgeek.matches.controller;

import com.project.sportsgeek.matches.model.MyMatches;
import com.project.sportsgeek.matches.service.MyMatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping(path = "/my-matches", produces = MediaType.APPLICATION_JSON_VALUE)
public class MyMatchesController {

    @Autowired
    MyMatchesService myMatchesService;

    @PreAuthorize("hasAnyRole('Admin','User')")
    @GetMapping(value = "/users/{userId}/upcoming", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MyMatches> getUpcomingContestByUserId(@PathVariable @Valid @Pattern(regexp = "[0-9]*") int userId) throws Exception {
        List<MyMatches> matchesList = myMatchesService.findUpcomingMatchesByUserId(userId);
        return matchesList;
    }

    @PreAuthorize("hasAnyRole('Admin','User')")
    @GetMapping(value = "/users/{userId}/live", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MyMatches> getLiveContestByUserId(@PathVariable @Valid @Pattern(regexp = "[0-9]*") int userId) throws Exception {
        List<MyMatches> matchesList = myMatchesService.findLiveMatchesByUserId(userId);
        return matchesList;
    }

    @PreAuthorize("hasAnyRole('Admin','User')")
    @GetMapping(value = "/users/{userId}/result", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MyMatches> getResultContestByUserId(@PathVariable @Valid @Pattern(regexp = "[0-9]*") int userId) throws Exception {
        List<MyMatches> matchesList = myMatchesService.findResultMatchesByUserId(userId);
        return matchesList;
    }
}
