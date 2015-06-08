package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long teamId;

    public String teamName;

    @ManyToMany(cascade = CascadeType.ALL)
    public List<User> teamUsers;

    @ManyToMany(mappedBy = "contestTeams", cascade = CascadeType.ALL)
    public List<Contest> teamContests;

    @ManyToMany(mappedBy = "matchTeams", cascade = CascadeType.ALL)
    public List<Match> teamMatches;
}
