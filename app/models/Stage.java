package models;

import org.joda.time.LocalDate;

import java.util.List;

/**
 * Created by ahasall on 27/05/15.
 */
public abstract class Stage {
    String stageName;
    LocalDate stageStartDate;
    LocalDate stageEndDate;
    Integer ptsPerWin;
    Integer ptsPerLoss;
    boolean drawActive;
    Integer ptsPerDraw;

    List<Group> stageGroups;

}
