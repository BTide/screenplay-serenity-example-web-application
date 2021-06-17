package net.serenitybdd.bankproject.screenplay.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class CustomerAccount extends  Customer {

    public static final Target CUSTOMER_NAME_TXT = Target.the("Customer Name text").locatedBy(".fontBig");
    public static final Target ACCOUNT_SELECT = Target.the("Account select").locatedBy("#accountSelect");
    public static final Target ACCOUNT_NUMBER_TXT = Target.the("Account Number text").locatedBy("//*[@ng-hide='noAccount']/strong[1]");
    public static final Target BALANCE_TXT = Target.the("Balance text").locatedBy("//*[@ng-hide='noAccount']/strong[2]");
    public static final Target CURRENCY_TXT = Target.the("Currency text").locatedBy("//*[@ng-hide='noAccount']/strong[3]");
    public static final Target TRANSACTION_BTN = Target.the("Transaction button").locatedBy("//*[@ng-class='btnClass1']");
    public static final Target DEPOSIT_BTN = Target.the("Deposit button").locatedBy("//*[@ng-class='btnClass2']");
    public static final Target WITHDRAW_BTN = Target.the("Withdraw button").locatedBy("//*[@ng-class='btnClass3']");

}