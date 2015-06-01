package models;

import play.db.ebean.Model;

import javax.persistence.*;

public class Scores extends Model {

    @Id
    public Long id;

    public Long nbWins;
    public Long nbDraws;
    public Long nbLosses;
    public Long points;
    public Long goalFor;
    public Long goalAgainst;

    @ManyToOne(cascade = CascadeType.PERSIST)
    public Group group;

    @ManyToOne(cascade = CascadeType.PERSIST)
    public User user;
}
