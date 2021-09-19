package net.serenitybdd.bankproject.features.customer_authentication;


import net.serenitybdd.bankproject.features.WebHook;
import net.serenitybdd.bankproject.screenplay.tasks.Start;
import net.serenitybdd.bankproject.screenplay.tasks.customer.Logout;
import net.serenitybdd.bankproject.screenplay.user_interface.CustomerLogin;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("Screenplay pattern"),
})
public class CustomerLogoutStory extends WebHook {

    @Before
    public void customerCanBrowseTheWebAndLogin() {
        customer.can(BrowseTheWeb.with(hisBrowser));
        givenThat(customer).wasAbleTo(Start.loginAsCustomer("Harry Potter"));
    }


    @Test
    public void should_be_able_to_log_out() {
        when(customer).attemptsTo(Logout.called());

        then(customer).should(
                seeThat(
                        WebElementQuestion.the(CustomerLogin.YOUR_NAME_SELECT),
                        WebElementStateMatchers.isVisible()
                )
        );
    }

}
