package net.serenitybdd.bankproject.screenplay.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class Home {
    public static final Target CUSTOMER_LOGIN_BUTTON = Target.the("Customer Login button").locatedBy("//button[text()='Customer Login']");
    public static final Target BANK_MANAGER_LOGIN_BUTTON = Target.the("Bank Manager Login button").locatedBy("//button[text()='Bank Manager Login']");
}
