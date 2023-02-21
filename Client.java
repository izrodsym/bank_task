package Bank;
import java.util.Random;

public class Client {
    String[] names = {"Peter", "George", "Stanislav", "Ahmed", "Ivan", "Angel", "Kalin", "Vladimir", "Vesselina", "Anastasia", "Elka", "Penka", "Stanka"};
    private final String name;
    private final String address;
    private double cache;
    private final double salary;
    private static int idNum = 0;
    private final int id;

    public Client() {
        Random rand = new Random();
        name = names[rand.nextInt(names.length)];
        address = "No such street №" + rand.nextInt(400);
        salary = rand.nextInt(100) * 100 + 1000;
        cache = rand.nextInt(50000) + 2000;
        idNum++;
        id = idNum;
    }

    public void openNewDeposit(Bank bank, double money) {
        if (money > this.cache) {
            money = this.cache;
        }
        if (bank.acceptDeposit(this, money)){
            this.cache -= money;
        }
    }

    /**
     *  Application to the bank for granting credit
     * @param bank Bank
     * @param money size of the credit
     * @param duration duration of the credit
     */
    public void askForNewCredit(Bank bank, double money, int duration) {
        if (bank.grantingCredit(this, money, duration)){
            cache += money;
        }
    }

    public void depositingMoneyOnCredit(Bank bank) {
        cache = bank.payCreditInstallment(this, cache);
    }

    public void showInfo() {
        System.out.printf("Name: %s, address: %s, available money: %.2f, salary: %.2f\n", name, address, cache, salary);
    }

    @Override
    public String toString() {
        return name;
    }

    public double getMoney() {
        return cache;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }
}
