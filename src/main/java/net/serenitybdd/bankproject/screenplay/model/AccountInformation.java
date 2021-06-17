package net.serenitybdd.bankproject.screenplay.model;

public class AccountInformation {
    private final String customerName;
    private final String accountNumber;
    private final String balance;
    private final String currency;

    public AccountInformation(String customerName, String accountNumber, String balance, String currency) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.currency = currency;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return String.format("{customerName='%s', accountNumber='%s', balance='%s', currency='%s'}", customerName, accountNumber, balance, currency);
    }
}
