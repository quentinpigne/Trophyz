package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class User extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long userId;

    public String userUserName;
    public String userPassword;
    public String userFirstName;
    public String userLastName;
    public Date userBirthDate;
    public Long userAge;
    public String userAddress;
    public String userEmail;
    public String userPhone;
    public String userDescription;

    @ManyToMany(mappedBy = "contestContestants", cascade = CascadeType.ALL)
    public List<Contest> userContestsAsContestant;

    @OneToMany(mappedBy = "contestOrganizer", cascade = CascadeType.ALL)
    public List<Contest> userContestsAsOrganizer;

    @OneToMany(mappedBy = "scoreUser", cascade = CascadeType.ALL)
    public List<Score> userScores;

    @ManyToMany(mappedBy = "teamUsers", cascade = CascadeType.ALL)
    public List<Team> userTeams;

    @ManyToMany(mappedBy = "groupUsers", cascade = CascadeType.ALL)
    public List<Group> userGroups;

    @ManyToMany(mappedBy = "matchUsers", cascade = CascadeType.ALL)
    public List<Match> userMatches;
}
