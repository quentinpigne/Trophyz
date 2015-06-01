package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public abstract class Stage extends Model {

    @Id
    public Long id;

    public String stageName;
    public Date stageStartDate;
    public Date stageEndDate;
    public Long ptsPerWin;
    public Long ptsPerLoss;
    public boolean drawActive;
    public Long ptsPerDraw;

    @ManyToOne(cascade = CascadeType.PERSIST)
    public Contest contest;

    @OneToMany(cascade = CascadeType.ALL)
    public List<Group> stageGroups;
}
