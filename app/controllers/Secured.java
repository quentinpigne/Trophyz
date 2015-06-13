package controllers;

import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import play.mvc.Http.Context;

import static play.mvc.Controller.flash;

/**
 * Created by ahasall on 12/06/15.
 */
public class Secured extends Security.Authenticator {
    @Override
    public String getUsername(Context ctx) {
        return ctx.session().get("username");
    }

    @Override
    public Result onUnauthorized(Context ctx) {
        flash("error", "Veillez vous identifiez");

        return redirect(routes.Application.index());
    }
}
