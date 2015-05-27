package models;

import org.joda.time.LocalDate;

import java.util.List;

/**
 * Created by ahasall on 27/05/15.
 */
public class User {
    String firstName;
    String lastName;
    LocalDate birthday;
    Integer age;
    String adress;
    String email;
    String phone;
    String description;
    Integer nbContest;

    List<Contest> contests;
    List<Team> teams;
    Scores userScores;


}
