package net.serenitybdd.bankproject.screenplay.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class OpenAccount {
    public static final Target CUSTOMER_SELECT = Target.the("Customer select").locatedBy(".userSelect");
    public static final Target CURRENCY_SELECT = Target.the("Currency select").locatedBy(".currency");
    public static final Target PROCESS_BUTTON = Target.the("Process button").locatedBy("//button[text()='Process']");
}
