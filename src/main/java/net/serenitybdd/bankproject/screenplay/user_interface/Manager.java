package net.serenitybdd.bankproject.screenplay.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class Manager {
    public static final Target ADD_CUSTOMER_BUTTON = Target.the("Add Customer button").locatedBy("//*[@ng-class='btnClass1']");
    public static final Target OPEN_ACCOUNT_BUTTON = Target.the("Open Account button").locatedBy("//*[@ng-class='btnClass2']");
    public static final Target CUSTOMER_BUTTON = Target.the("Customer button").locatedBy("//*[@ng-class='btnClass3']");
}
