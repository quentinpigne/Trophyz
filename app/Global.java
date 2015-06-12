import play.GlobalSettings;
import play.api.mvc.EssentialFilter;
import play.filters.csrf.CSRFFilter;
/**
 * Created by ahasall on 11/06/15.
 */
public class Global extends GlobalSettings {

    @Override
    public <T extends EssentialFilter> Class<T>[] filters() {
        Class[] filters = {CSRFFilter.class};
        return filters;

    }
}
