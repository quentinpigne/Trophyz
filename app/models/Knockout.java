package models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Knockout extends Stage {
    public Knockout(String stageName, Date stageStartDate, Date stageEndDate, Long ptsPerWin, Long ptsPerLoss, boolean drawActive, Long ptsPerDraw) {
        super(stageName, stageStartDate, stageEndDate, ptsPerWin, ptsPerLoss, drawActive, ptsPerDraw);
    }
}
