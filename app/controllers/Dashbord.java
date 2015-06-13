package controllers;

import com.avaje.ebean.Ebean;
import models.User;
import play.data.Form;
import play.mvc.*;
import views.html.dashbord.home;
import views.html.dashbord.info;

import java.util.Map;

/**
 * Created by ahasall on 12/06/15.
 */
@Security.Authenticated(Secured.class)
public class Dashbord extends Controller{
    public static Result home() {
        return ok(home.render(Application.loggedUser));
    }

    public static Result info() {
        Form<User> userFilledForm = Form.form(User.class);
        userFilledForm.fill(Application.loggedUser);
        return ok(info.render(Application.loggedUser,userFilledForm));

    }

    public static Result tournois() {
        return ok(home.render(Application.loggedUser));

    }

    public static Result nouveau() {
        return ok(home.render(Application.loggedUser));

    }

    public static Result modifyInfo(){
        Form<User> userFilledForm = Form.form(User.class);
        Map<String, String> data = Form.form(User.class).bindFromRequest().data();
        Application.loggedUser.userFirstName = data.get("userFirstName");
        Application.loggedUser.userLastName = data.get("userLastName");
        Application.loggedUser.userEmail = data.get("userEmail");

        Ebean.save(Application.loggedUser);
        return ok(info.render(Application.loggedUser,userFilledForm));
    }

    public static Result modifyDescription(){
        Form<User> userForm = Form.form(User.class);
        Map<String, String> data = Form.form(User.class).bindFromRequest().data();
        Application.loggedUser.userDescription = data.get("userDescription");

        Ebean.save(Application.loggedUser);
        return ok(info.render(Application.loggedUser,userForm));
    }


    public static Result modifyPhoto(){
        Form<User> userForm = Form.form(User.class);
        Map<String, String> data = Form.form(User.class).bindFromRequest().data();
        Application.loggedUser.userDescription = data.get("userDescription");

        Ebean.save(Application.loggedUser);
        return ok(info.render(Application.loggedUser,userForm));
    }
}
