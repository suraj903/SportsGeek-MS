package com.project.sportsgeek.matches.service;

import com.project.sportsgeek.matches.model.MyMatches;
import com.project.sportsgeek.matches.mymatchesrepo.MyMatchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyMatchesService {

    @Autowired
    @Qualifier("myMatchesRepo")
    MyMatchesRepository myMatchesRepository;

    public List<MyMatches> findUpcomingMatchesByUserId(int userId) throws Exception {
        List<MyMatches> matchesList = myMatchesRepository.findUpcomingContestByUserId(userId);
        return matchesList;
    }

    public List<MyMatches> findLiveMatchesByUserId(int userId) throws Exception {
        List<MyMatches> matchesList = myMatchesRepository.findLiveContestByUserId(userId);
        return matchesList;
    }

    public List<MyMatches> findResultMatchesByUserId(int userId) throws Exception {
        List<MyMatches> matchesList = myMatchesRepository.findResultContestByUserId(userId);
        return matchesList;
    }
}
