package controllers;

import play.mvc.*;
import views.html.dashbord.home;
import views.html.dashbord.info;

/**
 * Created by ahasall on 12/06/15.
 */
@Security.Authenticated(Secured.class)
public class Dashbord extends Controller{
    public static Result home() {
        return ok(home.render(Application.loggedUser));
    }

    public static Result info() {
        return ok(info.render(Application.loggedUser));

    }

    public static Result tournois() {
        return ok(home.render(Application.loggedUser));

    }

    public static Result nouveau() {
        return ok(home.render(Application.loggedUser));

    }
}
