package models;

import javax.persistence.*;
import java.util.List;

public class Group {

    @Id
    public Long id;

    public String groupName;

    @ManyToOne(cascade = CascadeType.ALL)
    public Stage stage;

    @ManyToMany(mappedBy = "", cascade = CascadeType.ALL)
    public List<User> groupUsers;

    @ManyToMany(mappedBy = "", cascade = CascadeType.ALL)
    public List<Match> groupMatches;

    @OneToMany(mappedBy = "", cascade = CascadeType.ALL)
    public List<Scores> scores;
}
