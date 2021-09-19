package net.serenitybdd.bankproject.features.customer_authentication;

import net.serenitybdd.bankproject.features.WebHook;
import net.serenitybdd.bankproject.screenplay.questions.Customer.Information.Customer;
import net.serenitybdd.bankproject.screenplay.tasks.Start;
import net.serenitybdd.bankproject.screenplay.tasks.customer.SelectAccountNumber;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.ConsequenceMatchers.displays;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("Screenplay pattern"),
})
public class CustomerLoginStory extends WebHook {

    @Before
    public void customerCanBrowseTheWeb() {
        customer.can(BrowseTheWeb.with(hisBrowser));
    }

    @Test
    public void should_be_able_to_see_the_customer_information() {
        when(customer).attemptsTo(Start.loginAsCustomer("Harry Potter"));

        then(customer).should(
                seeThat(Customer.information(),
                        displays("customerName",equalTo("Harry Potter")),
                        displays("accountNumber",equalTo("1004")),
                        displays("balance",equalTo("0")),
                        displays("currency", containsString("Dollar"))
                )
        );

     }

    @Test
    public void should_be_able_to_choose_other_account() {
        when(customer).attemptsTo(
                Start.loginAsCustomer("Harry Potter"),
                SelectAccountNumber.called("1005")
        );

        then(customer).should(
                seeThat(Customer.information(),
                        displays("customerName",equalTo("Harry Potter")),
                        displays("accountNumber",equalTo("1005")),
                        displays("balance",equalTo("0")),
                        displays("currency", containsString("Pound"))
                )
        );
    }
}
