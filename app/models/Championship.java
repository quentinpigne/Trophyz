package models;

import javax.persistence.*;

@Entity
public class Championship extends Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long championshipId;
}
