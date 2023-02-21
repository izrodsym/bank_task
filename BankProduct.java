package Bank;

public abstract class BankProduct {
    private final String name;
    private final double annualInterestRate;
    private int duration;
    private double availability;
    public BankProduct(String name, double annualInterestRate){
        this.name = name;
        this.annualInterestRate = annualInterestRate;
    }
    public BankProduct(String name, int duration, double annualInterestRate){
        this.name = name;
        setDuration(duration);
        this.annualInterestRate = annualInterestRate;
    }
    public BankProduct(String name, int duration, double annualInterestRate, double money){
        this.name = name;
        setDuration(duration);
        this.annualInterestRate = annualInterestRate;
        availability = money;
    }

    private void setDuration(int duration) {
        if (duration < 1){  // minimum 1 month and maximum 60
            this.duration = 1;
        } else this.duration = Math.min(duration, 60);
    }
    public double monthlyPayment(double monthlySum){
        availability += monthlySum;
        return monthlySum;
    }

    public String getName() {
        return name;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getDuration() {
        return duration;
    }

    public double getAvailability() {
        return availability;
    }
}
