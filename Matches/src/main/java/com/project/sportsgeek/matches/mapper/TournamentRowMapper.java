package com.project.sportsgeek.matches.mapper;

import com.project.sportsgeek.matches.model.Tournament;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TournamentRowMapper implements RowMapper<Tournament> {
    @Override
    public Tournament mapRow(ResultSet rs, int rowNum) throws SQLException {
        Tournament tournament = new Tournament();
        tournament.setTournamentId(rs.getInt("TournamentId"));
        tournament.setName(rs.getString("Name"));
        return tournament;
    }
}
