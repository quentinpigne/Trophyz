package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Group extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long groupId;

    public String groupName;

    @ManyToOne(cascade = CascadeType.ALL)
    public Stage groupStage;

    @ManyToMany(cascade = CascadeType.ALL)
    public List<User> groupUsers;

    @OneToMany(mappedBy = "matchGroup", cascade = CascadeType.ALL)
    public List<Match> groupMatches;

    @OneToMany(mappedBy = "scoreGroup", cascade = CascadeType.ALL)
    public List<Score> groupScores;

    public Group(List<User> contestants) {
        this.groupUsers = contestants;
    }
}
