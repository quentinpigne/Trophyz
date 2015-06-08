package controllers;
import models.*;
import play.*;
import play.mvc.*;
import play.twirl.api.Html;
import views.html.contest;
import views.html.index;
import views.html.main;
import views.html.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ahasall on 02/06/15.
 */
public class Test extends Controller {
    public static Result index() {

        List<User> contestants = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            User user = new User((long) i,"Prenom-"+i,"Nom-"+i,new Date(System.currentTimeMillis()), (long) 24,
                    "@-"+i,"mail-"+i,"0695606864","beau gausse");
            contestants.add(user);
        }
        Date date = new Date(System.currentTimeMillis());
        Contest tournoi = new Contest("Championnat",date,date,(long)8,false,contestants.get(0));
        for (int i = 0; i < 8; i++) {
            tournoi.addContestant(contestants.get(i));

        }
        Championship championnat = new Championship("Championnant",date,date,(long) 3,(long) 0,true, (long) 1, new Group(tournoi.contestContestants));
        tournoi.addStage(championnat);

        Html html = contest.render(tournoi);
        return ok(main.render("Test des classes",html));
    }

}
