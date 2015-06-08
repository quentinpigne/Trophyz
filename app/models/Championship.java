package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Championship extends Stage {

    @Id
    public Long id;

    public List<User> championshipContestants;

    public Championship(String stageName, Date stageStartDate, Date stageEndDate, Long ptsPerWin, Long ptsPerLoss, boolean drawActive, Long ptsPerDraw, Group group) {
        super(stageName, stageStartDate, stageEndDate, ptsPerWin, ptsPerLoss, drawActive, ptsPerDraw);
        this.championshipContestants = new ArrayList<>() ;
        championshipContestants.addAll(group.groupUsers);
    }

    public void addChampionshipConstestant(User user){
        championshipContestants.add(user);
    }
}