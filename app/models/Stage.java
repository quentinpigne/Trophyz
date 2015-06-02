package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public abstract class Stage extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long stageId;

    public String stageName;
    public Date stageStartDate;
    public Date stageEndDate;
    public Long stagePtsPerWin;
    public Long stagePtsPerLoss;
    public boolean stageDrawActive;
    public Long stagePtsPerDraw;

    @ManyToOne(cascade = CascadeType.ALL)
    public Contest stageContest;

    @OneToMany(mappedBy = "groupStage", cascade = CascadeType.ALL)
    public List<Group> stageGroups;
}
