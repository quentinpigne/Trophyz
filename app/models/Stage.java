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

    public Stage(String stageName, Date stageStartDate, Date stageEndDate, Long ptsPerWin, Long ptsPerLoss, boolean drawActive, Long ptsPerDraw) {
        this.stageName = stageName;
        this.stageStartDate = stageStartDate;
        this.stageEndDate = stageEndDate;
        this.ptsPerWin = ptsPerWin;
        this.ptsPerLoss = ptsPerLoss;
        this.drawActive = drawActive;
        this.ptsPerDraw = ptsPerDraw;
    }
}


