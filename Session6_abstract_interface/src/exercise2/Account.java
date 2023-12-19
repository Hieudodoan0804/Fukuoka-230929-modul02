package exercise2;

public class Account {
    protected String accountNo;
    protected String customerName;
    protected double balance;

    public Account() {
    }

    public Account(String accountNo, String customerName, double balance) {
        this.accountNo = accountNo;
        this.customerName = customerName;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
