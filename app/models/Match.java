package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Match extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long matchId;

    public Date matchDate;
    public Date matchTime;
    public Long matchDuration;
    public String matchScore;

    @ManyToOne(cascade = CascadeType.ALL)
    public Group matchGroup;

    @ManyToOne(cascade = CascadeType.ALL)
    public Place matchPlace;

    @ManyToMany(cascade = CascadeType.ALL)
    public List<User> matchUsers;

    @ManyToMany(cascade = CascadeType.ALL)
    public List<Team> matchTeams;
}
