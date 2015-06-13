package models;

import com.avaje.ebean.Ebean;
import play.db.ebean.Model;
import play.data.validation.Constraints;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class User extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long userId;
    @Constraints.Required
    public String userEmail;
    @Constraints.Required
    public String userPassword;
    public String userFirstName;
    public String userLastName;
    public Date userBirthDate;
    public Long userAge;
    public String userAddress;

    public String userUserName;

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

    public User(String email, String password) {
        this.userEmail = email;
        this.userPassword = password;
    }

    public User(Long userId, String userEmail, String userPassword, String userFirstName, String userLastName,
                Date userBirthDate, Long userAge, String userAddress, String userUserName, String userPhone, String userDescription) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userBirthDate = userBirthDate;
        this.userAge = userAge;
        this.userAddress = userAddress;
        this.userUserName = userUserName;
        this.userPhone = userPhone;
        this.userDescription = userDescription;
    }

    public static User logUser(User user) {
        User userLogged = Ebean.find(User.class).where().eq("userUserName", user.userUserName).findUnique();
        if(userLogged != null && userLogged.userPassword.equals(user.userPassword)) return userLogged;
        return null;
    }
    public static User authenticate(String username, String password){
        return finder.where().eq("userUserName", username).eq("userPassword",password).findUnique();
    }
    public static Finder<Long, User> finder
            = new Finder<Long, User>(Long.class, User.class);
}
