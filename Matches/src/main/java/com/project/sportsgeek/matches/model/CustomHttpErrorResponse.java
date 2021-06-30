package com.project.sportsgeek.matches.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.Date;

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
public class CustomHttpErrorResponse {
    private Date timestamp;
    private Integer status;
    private String message;
    private String path;

    public CustomHttpErrorResponse(Date timestamp, Integer status, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
    }
}
