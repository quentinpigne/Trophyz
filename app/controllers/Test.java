package controllers;
import models.*;
import play.*;
import play.mvc.*;
import play.twirl.api.Html;
import views.html.contest;
import views.html.index;
import views.html.main;
import views.html.test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ahasall on 02/06/15.
 */
@Security.Authenticated(Secured.class)
public class Test extends Controller {
    public static Result index() {
        Html html = test.render(Application.loggedUser);
        return ok(main.render("Test des classes",html));
    }

}
