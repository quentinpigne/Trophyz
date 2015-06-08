package models;

import javax.persistence.*;
import java.util.Date;

public class Knockout extends Stage {

    @Id
    public Long id;

    public Knockout(String stageName, Date stageStartDate, Date stageEndDate, Long ptsPerWin, Long ptsPerLoss, boolean drawActive, Long ptsPerDraw) {
        super(stageName, stageStartDate, stageEndDate, ptsPerWin, ptsPerLoss, drawActive, ptsPerDraw);
    }
}
