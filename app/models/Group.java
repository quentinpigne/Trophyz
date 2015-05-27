package models;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ahasall on 27/05/15.
 */
public class Group {
    String groupName;
    List<User> groupUsers;
    List<Match> groupMatches;

    HashMap<User,Scores> scores; // au sein d'un groupe le score dépend de l'utilisateur
}
