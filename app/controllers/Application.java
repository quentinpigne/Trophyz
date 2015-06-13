package controllers;

import com.avaje.ebean.Ebean;
import models.User;
import play.data.Form;
import play.mvc.*;

import views.html.*;
import views.html.dashbord.home;

import static play.data.Form.form;

public class Application extends Controller {

    public static Result search(String userName) {
         User foundUser =  User.finder.where().eq("userUserName", userName).findUnique();
        if (foundUser != null){
            return ok(String.format("Utilisateur %s trouvé",foundUser.userEmail));
        }
        return notFound();

    }

    public static class Login{
        public String username;
        public String password;
    }
    public static  User loggedUser = null;
    public static Result index() {
        Form<User> userForm = Form.form(User.class);
        Form<Application.Login> loginForm = Form.form(Application.Login.class);
        if(Application.loggedUser != null){
            return redirect(routes.Test.index());
        }
        return ok(index.render(userForm,loginForm,Application.loggedUser));
    }

    public static Result login() {
        return ok(login.render(form(Login.class)));
    }

    public static Result logout() {
        session().clear();
        loggedUser = null;
        return redirect(routes.Application.index());
    }
    public static Result authenticate() {
        Form<Login> loginForm = form(Login.class).bindFromRequest();
        String username = loginForm.get().username;
        String password = loginForm.get().password;
        loggedUser = User.authenticate(username, password);
        if (loggedUser == null){
            session().clear();
            return badRequest("invalid password");
        }
        session().clear();
        session("username", username);
        return ok(home.render(loggedUser));

    }

    public static Result signup() {
        Form<User> userForm = Form.form(User.class);
        Form<User> boundForm = userForm.bindFromRequest();
        User newUser = boundForm.get();
        Ebean.save(newUser);
        flash("ok", String.format("Utilisateur %s enregistré", newUser.userUserName));
        return redirect(routes.Application.index());
    }

}
