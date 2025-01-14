package utilities;

import org.aeonbits.owner.Config;

@Config.Sources({"file:enviromentConfig/${server}.properties"})
public interface EnvironmentConfig extends Config {
    @Key("App.Url")
    String appURL();

    @Key("App.User")
    String appUser();

    @Key("App.Pass")
    String appPass ();

    String age();
}
