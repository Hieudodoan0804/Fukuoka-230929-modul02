package exercise2;

public class SaveingAccount extends Account{
    private double rate;
    private int period;

    public SaveingAccount() {
    }

    public SaveingAccount(String accountNo, String customerName, double balance, double rate, int period) {
        super(accountNo, customerName, balance);
        this.period = period;
        this.rate=calculatorRate(period);
    }

    public double getRate() {
        return rate;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
        this.rate=calculatorRate(period);
    }

    public void checkInterest(){
        double money = this.balance*this.rate/100/12*this.period;
        System.out.println("Số tiền sau kì hạn " + this.period + " tháng là " +money);
    }
    public double calculatorRate(int period){
        switch (period){
            case 1:
                return 5;
            case 3:
                return 5.5;
            case 6:
                return 6;
            case 12:
                return 7;
            case 24:
                return 7.5;
            case 36:
                return 8;
            default:
                return 1.8;
        }
    }

    @Override
    public String toString() {
        return "SaveingAccount{" +
                "rate=" + rate +
                ", period=" + period +
                ", accountNo='" + accountNo + '\'' +
                ", customerName='" + customerName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
