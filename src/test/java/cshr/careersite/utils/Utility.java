package cshr.careersite.utils;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class Utility {

    public String getSerenityPropertiesValues(String propertyName){
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        return variables.getProperty(propertyName);
    }
}
