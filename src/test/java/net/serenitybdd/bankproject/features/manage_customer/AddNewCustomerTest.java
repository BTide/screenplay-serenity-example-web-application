package net.serenitybdd.bankproject.features.manage_customer;

import net.serenitybdd.bankproject.screenplay.questions.Customer.Alert;
import net.serenitybdd.bankproject.screenplay.questions.Manager.AddCustomer.Message;
import net.serenitybdd.bankproject.screenplay.tasks.Start;
import net.serenitybdd.bankproject.screenplay.tasks.manager.AddNewCustomer;
import net.serenitybdd.bankproject.screenplay.user_interface.AddCustomer;
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
import static org.hamcrest.core.Is.is;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("Screenplay pattern"),
})
public class AddNewCustomerTest {

    private Actor manager = Actor.named("Manager");
    String errorMessage = "Please fill in this field.";

    String successMessage = "Customer added successfully with customer id :";


    @Managed
    private WebDriver hisBrowser;

    String firstName = "W33";
    String lastName = "Haa";
    String postCode = "123";

    @Before
    public void managerCanBrowseTheWebAndLogin() {

        manager.can(BrowseTheWeb.with(hisBrowser));

        givenThat(manager).attemptsTo(Start.LoginAsManager());
    }



    @Test
    public void AddACustomer() {


        when(manager).attemptsTo(
                AddNewCustomer.from_ManagerPage(),
                AddNewCustomer.called(firstName,lastName,postCode)
        );

        then(manager).should(
                seeThat(Alert.text(), is(successMessage+ "6"))
        );

        //teardown
        BrowseTheWeb.as(manager).getAlert().accept();
    }

    @Test
    public void AddACustomerWithoutFirstName() {
        firstName = "";

        when(manager).attemptsTo(
                AddNewCustomer.from_ManagerPage(),
                AddNewCustomer.called(firstName,lastName,postCode)
        );

        then(manager).should(
                seeThat(Message.text(AddCustomer.FIRST_NAME_INPUT), is(errorMessage))
        );

    }

    @Test
    public void AddACustomerWithoutLastName() {
        lastName = "";

        when(manager).attemptsTo(
                AddNewCustomer.from_ManagerPage(),
                AddNewCustomer.called(firstName,lastName,postCode)
        );

        then(manager).should(
                seeThat(Message.text(AddCustomer.LAST_NAME_INPUT), is(errorMessage))
        );
    }

    @Test
    public void AddACustomerWithoutPostCode() {
        postCode = "";

        when(manager).attemptsTo(
                AddNewCustomer.from_ManagerPage(),
                AddNewCustomer.called(firstName,lastName,postCode)
        );

        then(manager).should(
                seeThat(Message.text(AddCustomer.POST_CODE_INPUT), is(errorMessage))
        );
    }
}
