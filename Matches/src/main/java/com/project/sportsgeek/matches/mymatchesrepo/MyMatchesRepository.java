package com.project.sportsgeek.matches.mymatchesrepo;

import com.project.sportsgeek.matches.model.MyMatches;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "myMatchesRepo")
public interface MyMatchesRepository {

    List<MyMatches> findUpcomingContestByUserId(int userId) throws Exception;

    List<MyMatches> findLiveContestByUserId(int userId) throws Exception;

    List<MyMatches> findResultContestByUserId(int userId) throws Exception;

}
