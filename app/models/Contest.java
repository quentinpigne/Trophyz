package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Contest extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long contestId;

    public String contestName;
    public Date contestStartDate;
    public Date contestEndDate;
    public Long contestNbContestants;
    public boolean contestByTeam;
    
    public List<RankingCriteria> contestCriterias;

    @ManyToOne(cascade = CascadeType.ALL)
    public User contestOrganizer;

    @ManyToMany(cascade = CascadeType.ALL)
    public List<User> contestContestants;

    @ManyToMany(cascade = CascadeType.ALL)
    public List<Team> contestTeams;

    @OneToMany(mappedBy = "stageContest", cascade = CascadeType.ALL)
    public List<Stage> contestStages;

    // Constructeur avec les paramètres obligatoires
    public Contest(String contestName, Date contestStartDate, Date contestEndDate, Long nbContestants, boolean byTeam, User organizer) {
        this.contestName = contestName;
        this.contestStartDate = contestStartDate;
        this.contestEndDate = contestEndDate;
        this.contestNbContestants = nbContestants;
        this.contestByTeam = byTeam;
        this.contestOrganizer = organizer;
        this.contestContestants = new ArrayList<>();
        this.contestStages = new ArrayList<>();
    }

    public void addContestant(User user) {
        contestContestants.add(user);
    }

    public void addStage(Stage stage) {
        this.contestStages.add(stage);
        stage.stageContest = this;
    }
}
