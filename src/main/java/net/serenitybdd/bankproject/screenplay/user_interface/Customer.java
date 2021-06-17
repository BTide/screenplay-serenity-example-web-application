package net.serenitybdd.bankproject.screenplay.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class Customer {
    public static final Target HOME_BUTTON = Target.the("Home button").locatedBy(".home");
    public static final Target LOGOUT_BUTTON = Target.the("Logout button").locatedBy(".logout");
}
