package net.serenitybdd.bankproject.screenplay.questions.Customer.Information;

import net.serenitybdd.bankproject.screenplay.model.AccountInformation;
import net.serenitybdd.bankproject.screenplay.user_interface.CustomerAccount;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static net.serenitybdd.screenplay.questions.ValueOf.the;

public class Customer implements Question<AccountInformation> {
    @Override
    public AccountInformation answeredBy(Actor actor) {
        String customerName = the(Text.of(CustomerAccount.CUSTOMER_NAME_TXT).viewedBy(actor));
        String accountNumber = the(Text.of(CustomerAccount.ACCOUNT_NUMBER_TXT).viewedBy(actor));
        String balance = the(Text.of(CustomerAccount.BALANCE_TXT).viewedBy(actor));
        String currency = the(Text.of(CustomerAccount.CURRENCY_TXT).viewedBy(actor));


        return new AccountInformation(customerName, accountNumber, balance, currency);
    }

    public  static Question<String> balance(){
        return Text.of(CustomerAccount.BALANCE_TXT)
                .describedAs("Account balance")
                .asAString();
    }

    public static Customer information() {
        return new Customer();
    }
}
