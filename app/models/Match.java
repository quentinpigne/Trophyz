package models;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import java.util.List;

/**
 * Created by ahasall on 27/05/15.
 */
public class Match {
    LocalDate matchDate;
    LocalTime matchTime;
    Integer matchDuration;
    String matchScore;
    Place matchPlace;
    List<User> matchUsers; // liste des participants aux match ( 1 vs 1)
    List<Team> matchTeams; // liste des équipes qui s'affrontent
}
