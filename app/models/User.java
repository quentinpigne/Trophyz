package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class User extends Model {

    @Id
    public Long id;

    public String firstName;
    public String lastName;
    public Date birthDate;
    public Long age;
    public String address;
    public String email;
    public String phone;
    public String description;


    @ManyToMany(mappedBy = "", cascade = CascadeType.PERSIST)
    public List<Contest> contestsContestant;

    @OneToMany(mappedBy = "", cascade = CascadeType.PERSIST)
    public List<Contest> contestsOrganizer;

    @OneToMany(mappedBy = "", cascade = CascadeType.ALL)
    public List<Scores> userScores;

    @ManyToMany(mappedBy = "", cascade = CascadeType.ALL)
    public List<Team> teams;

    @ManyToMany(mappedBy = "", cascade = CascadeType.ALL)
    public List<Group> groups;

    @ManyToMany(mappedBy = "", cascade = CascadeType.ALL)
    public List<Match> matches;

    public User(Long id, String firstName, String lastName, Date birthDate, Long age, String address, String email, String phone, String description) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.age = age;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.description = description;
    }
}
