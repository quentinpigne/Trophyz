package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class Contest extends Model {

    @Id
    public Long id;

    public String contestName;
    public Date contestStartDate;
    public Date contestEndDate;
    public Long nbContestants;
    public boolean byTeam;

    @ManyToOne(cascade = CascadeType.PERSIST)
    public User organizer;

    @ManyToMany(mappedBy = "", cascade = CascadeType.ALL)
    public List<User> contestants;

    @OneToMany(mappedBy = "", cascade = CascadeType.ALL)
    public List<Team> teams;

    @ManyToMany(mappedBy = "", cascade = CascadeType.PERSIST)
    public List<RankingCriteria> contestCriterias;

    @OneToMany(mappedBy = "", cascade = CascadeType.ALL)
    public List<Stage> contestStages;
}
