package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Place extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long placeId;

    public String placeName;
    public String placeLocation;

    @OneToMany(mappedBy = "matchPlace", cascade = CascadeType.ALL)
    public List<Match> placeMatches;
}
