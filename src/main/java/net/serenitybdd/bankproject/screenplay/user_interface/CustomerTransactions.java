package net.serenitybdd.bankproject.screenplay.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class CustomerTransactions {
     public static final Target BACK_BUTTON = Target.the("Back button").locatedBy("//button[text()='Back']");
     public static final Target RESET_BUTTON = Target.the("Reset button").locatedBy("//button[text()='Reset']");
     public static final Target START_DATEPICKER = Target.the("Start datepicker").locatedBy("#start");
     public static final Target End_DATEPICKER = Target.the("End datepicker").locatedBy("#end");
     public static final Target TRANSACTION_TABLE = Target.the("Transaction table").locatedBy("//table");
}
