package models;

import javax.persistence.*;

@Entity
public class Knockout extends Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long knockoutId;
}
