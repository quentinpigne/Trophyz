package models;

import java.util.List;

/**
 * Created by ahasall on 27/05/15.
 */
public class Contest {
    String contestName;
    String contestStartDate;
    String contestEndDate;
    Integer nbContestants;
    boolean byTeam;

    User organizer;
    List<User> contestUsers;
    List<Team> contestTeams;
    List<RankingCriteria> contestCriterias;
    List<Stage> contestStages;

}
