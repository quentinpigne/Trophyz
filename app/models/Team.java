package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.List;

public class Team extends Model {

    @Id
    public Long id;

    public String teamName;

    @ManyToMany(mappedBy = "", cascade = CascadeType.PERSIST)
    public List<User> members;

    @ManyToMany(mappedBy = "", cascade = CascadeType.ALL)
    public List<Contest> contests;

    @ManyToMany(mappedBy = "", cascade = CascadeType.ALL)
    public List<Match> matches;
}
