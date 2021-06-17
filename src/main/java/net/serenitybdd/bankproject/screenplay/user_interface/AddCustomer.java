package net.serenitybdd.bankproject.screenplay.user_interface;


import net.serenitybdd.screenplay.targets.Target;

public class AddCustomer {
    public static final Target FIRST_NAME_INPUT = Target.the("First Name field").locatedBy("//input[@ng-model='fName']");
    public static final Target LAST_NAME_INPUT = Target.the("Last Name field").locatedBy("//input[@ng-model='lName']");
    public static final Target POST_CODE_INPUT = Target.the("Postcode field").locatedBy("//input[@ng-model='postCd']");
    public static final Target SUBMIT_BTN = Target.the("'Submit button").locatedBy("//button[text()='Add Customer']");
}
