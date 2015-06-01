package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class Match extends Model {

    @Id
    public Long id;

    public Date matchDate;
    public Date matchTime;
    public Long matchDuration;
    public String matchScore;

    @ManyToOne(cascade = CascadeType.ALL)
    public Group group;

    @ManyToOne(cascade = CascadeType.ALL)
    public Place matchPlace;

    @ManyToMany(mappedBy = "", cascade = CascadeType.ALL)
    public List<User> matchUsers; // liste des participants aux match ( 1 vs 1)

    @ManyToMany(mappedBy = "", cascade = CascadeType.ALL)
    public List<Team> matchTeams; // liste des équipes qui s'affrontent
}
