package controllers;

import com.avaje.ebean.Ebean;
import models.User;
import play.data.Form;
import play.mvc.*;
import views.html.login;

import static play.data.Form.form;

public class Authentication extends Controller {

    public static Result signup() {
        User newUser = form(User.class).bindFromRequest().get();
        Ebean.save(newUser);
        flash("ok", String.format("Utilisateur %s enregistré", newUser.userUserName));
        return redirect(routes.Application.index());
    }


    public static Result login() {
        User user = User.logUser(Form.form(User.class).bindFromRequest().get());
        if(user != null) return ok("User connecté : " + user.userFirstName + " " + user.userLastName);
        flash("error", "Utilisateur inconnu");
        return redirect(routes.Application.index());
    }

    public static Result logout() {
        return TODO;
    }

    public static Result authenticate() {
        User user = User.logUser(form(User.class).bindFromRequest().get());
        if(user != null) return ok("User connecté : " + user.userFirstName + " " + user.userLastName);
        return notFound("User inconnu");
    }
}
