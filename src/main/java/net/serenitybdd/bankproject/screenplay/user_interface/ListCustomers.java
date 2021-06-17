package net.serenitybdd.bankproject.screenplay.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class ListCustomers {
    public static final Target SEARCH_CUSTOMER_INPUT = Target.the("Search Customer Input").locatedBy("//input[@ng-model='searchCustomer']");
    public static final Target CUSTOMER_TABLE = Target.the("Customer table").locatedBy("//table");
}
