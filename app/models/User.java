package models;

import com.avaje.ebean.Ebean;
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

    public User(Long id, String firstName, String lastName, Date birthDate, Long age, String address, String email, String phone, String description) {
        this.userId = id;
        this.userFirstName = firstName;
        this.userLastName = lastName;
        this.userBirthDate = birthDate;
        this.userAge = age;
        this.userAddress = address;
        this.userEmail = email;
        this.userPhone = phone;
        this.userDescription = description;
    }

    public static User logUser(User user) {
        User userLogged = Ebean.find(User.class).where().eq("userUserName", user.userUserName).findUnique();
        if(userLogged != null && userLogged.userPassword.equals(user.userPassword)) return userLogged;
        return null;
    }
}
