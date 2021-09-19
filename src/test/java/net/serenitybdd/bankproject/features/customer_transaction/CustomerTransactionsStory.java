package net.serenitybdd.bankproject.features.customer_transaction;

import net.serenitybdd.bankproject.features.WebHook;
import net.serenitybdd.bankproject.screenplay.questions.Customer.Information.Customer;
import net.serenitybdd.bankproject.screenplay.questions.Customer.Transactions.Message;
import net.serenitybdd.bankproject.screenplay.tasks.Start;
import net.serenitybdd.bankproject.screenplay.tasks.customer.Deposit;
import net.serenitybdd.bankproject.screenplay.tasks.customer.Withdraw;
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
public class CustomerTransactionsStory extends WebHook {
        String depositAmount = "500";

        String messageExceedBalanceLimit = "Transaction Failed. You can not withdraw amount more than the balance.";
        String messageDepositSuccessfully = "Deposit Successful";
        String messageWithdrawSuccessfully = "Transaction successful";


        @Before
        public void customerCanBrowseTheWebAndLogin() {
                customer.can(BrowseTheWeb.with(hisBrowser));
                givenThat(customer).wasAbleTo(Start.loginAsCustomer("Harry Potter"));
        }

        @Test
        public void should_be_able_to_deposit_money()
        {
                when(customer).attemptsTo(
                        Deposit.from_CustomerAccount(),
                        Deposit.called(depositAmount)
                );

                then(customer).should(
                        seeThat(Message.text(), is(messageDepositSuccessfully)),
                        seeThat(Customer.balance(), is(depositAmount))
                );
        }

        @Test
        public void should_validate_when_withdraw_exceed_amount_of_money() {
                String withdrawAmount = "501";
                when(customer).attemptsTo(
                        Deposit.from_CustomerAccount(),
                        Deposit.called(depositAmount),
                        Withdraw.from_CustomerAccount(),
                        Withdraw.called(withdrawAmount)
                );

                then(customer).should(
                        seeThat(Message.text(), is(messageExceedBalanceLimit))
                );
        }

        @Test
        public void should_be_able_to_withdraw_money() {
                String withdrawAmount = "499";
                String latestBalance = "1";
                when(customer).attemptsTo(
                        Deposit.from_CustomerAccount(),
                        Deposit.called(depositAmount),
                        Withdraw.from_CustomerAccount(),
                        Withdraw.called(withdrawAmount)
                );

                then(customer).should(
                        seeThat(Message.text(), is(messageWithdrawSuccessfully)),
                        seeThat(Customer.balance(), is(latestBalance))
                );
        }
}
