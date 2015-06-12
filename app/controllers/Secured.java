package controllers;

import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import play.mvc.Http.Context;
/**
 * Created by ahasall on 12/06/15.
 */
public class Secured extends Security.Authenticator {
    @Override
    public String getUsername(Context ctx) {
        return ctx.session().get("email");
    }

    @Override
    public Result onUnauthorized(Context ctx) {
        return redirect(routes.Application.login());
    }
}
