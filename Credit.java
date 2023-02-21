package Bank;

public class Credit extends BankProduct {
    private double monthlyPayment;

    public Credit(String name, double annualInterestRate) {
        super(name, annualInterestRate);
    }

    public Credit(String name, int duration, double annualInterestRate, double money) {
        super(name, duration, annualInterestRate, -money);
        monthlyPayment = (money + money * annualInterestRate * duration / 1200) / duration;
    }

    public double monthlyPayment() {
        return super.monthlyPayment(monthlyPayment);
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }
}
