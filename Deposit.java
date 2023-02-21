package Bank;

public class Deposit extends BankProduct {

    private double monthlyYield;

    public Deposit(String name, int duration, double annualInterestRate){
        super(name, duration, annualInterestRate);
    }
    public Deposit(String name, int duration, double annualInterestRate, double money){
        super(name, duration, annualInterestRate, money);
        monthlyYield = money * annualInterestRate / 1200;
    }

    public double monthlyPayment() {
        return super.monthlyPayment(monthlyYield);
    }

    public double getMonthlyYield() {
        return monthlyYield;
    }
}
