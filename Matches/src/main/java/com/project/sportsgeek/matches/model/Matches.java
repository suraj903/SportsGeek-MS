package com.project.sportsgeek.matches.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Matches With Venue Model")
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Matches implements Serializable {

    private int matchId;
    private String name;
    private Timestamp startDatetime;
    private int venueId;
    private int team1;
    private int team2;
    private int winnerTeamId;
    private boolean resultStatus;
    private int minimumPoints;
    private int tournamentId;

}
