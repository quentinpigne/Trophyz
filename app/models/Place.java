package models;

import javax.persistence.*;
import java.util.List;

public class Place {

    @Id
    public Long id;

    public String placeName;
    public String placeLocation;

    @OneToMany(mappedBy = "", cascade = CascadeType.ALL)
    public List<Match> matches;
}
