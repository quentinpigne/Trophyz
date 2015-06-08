package models;

import play.db.ebean.Model;

import javax.persistence.*;

@Entity
public class Score extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long scoreId;

    public Long scoreNbWins;
    public Long scoreNbDraws;
    public Long scoreNbLosses;
    public Long scorePoints;
    public Long scoreGoalFor;
    public Long scoreGoalAgainst;

    @ManyToOne(cascade = CascadeType.ALL)
    public Group scoreGroup;

    @ManyToOne(cascade = CascadeType.ALL)
    public User scoreUser;
}
