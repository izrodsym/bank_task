package Bank;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Bank {
    private final String name;
    private final String address;
    private final ArrayList<Credit> creditProducts = new ArrayList<>();
    private final ArrayList<Deposit> depositProducts = new ArrayList<>();
    private final TreeMap<Client, ArrayList<BankProduct>> clients = new TreeMap<>((c1, c2) -> Integer.compare(c1.getId(), c2.getId()));
    private double capital;

    public Bank(String name, String address, double capital) {
        this.name = name;
        this.address = address;
        this.capital = capital;
    }

    /**
     * Adding a type of credit service to the bank
     * @param name name of the service
     * @param annualInterestRate annual interest rate
     */
    public void addBankCredit(String name, double annualInterestRate) {
        creditProducts.add(new Credit(name, annualInterestRate));
    }

    /**
     * Adding a type of deposit service to the bank
     * @param name name of the service
     * @param duration duration of the service
     * @param annualInterestRate annual interest rate
     */
    public void addBankDeposit(String name, int duration, double annualInterestRate) {
        depositProducts.add(new Deposit(name, duration, annualInterestRate));
    }

    /**
     *
     * @param client - client of the bank
     * @param money - money he wants to put in the bank
     * @return - true or false
     */
    public boolean acceptDeposit(Client client, double money) {
        Random rand = new Random();
        if (depositProducts.size() == 0) {        //Check if there is a deposits offers in the bank
            System.out.println("No deposit products available at this time.");
            return false;
        }
        Deposit deposit = depositProducts.get(rand.nextInt(depositProducts.size()));    //Choose random deposit
        ArrayList<BankProduct> products;
        if (!clients.containsKey(client)) {
            products = new ArrayList<>();
        } else {
            products = clients.get(client);
        }
        capital += money;
        products.add(new Deposit(deposit.getName(), deposit.getDuration(), deposit.getAnnualInterestRate(), money));
        clients.put(client, products);
        return true;
    }

    // Charges monthly interest on all bank deposits
    public void interestPayments() {
        for (Map.Entry<Client, ArrayList<BankProduct>> client : clients.entrySet()) {
            for (BankProduct bp : client.getValue()) {
                if (bp instanceof Deposit) {
                    capital -= ((Deposit) bp).monthlyPayment();
                }
            }
        }
    }

    /**
     * Method that grants credit to a given client
     * @param client client of the bank
     * @param money money want to receive
     * @param duration duration of credit in months, min 1 and max 60
     * @return true or false
     */
    public boolean grantingCredit(Client client, double money, int duration) {
        Random rand = new Random();
        if (creditProducts.size() == 0) {        //Check if there is a deposits offers in the bank
            System.out.println("No credit products available at this time.");
            return false;
        }
        if (money > capital * 9 / 10) {            //Check if there is enough money in bank to grand credit
            System.out.println("Bank do not have enough money for the credit.");
            return false;
        }
        Credit credit = creditProducts.get(rand.nextInt(creditProducts.size()));    //Choose random deposit

        if ((money + money * credit.getAnnualInterestRate() * duration / 1200) / duration > client.getSalary() * 0.5) {    // if monthly payment is more than half of salary credit is rejected
            System.out.println("Credit rejected! Client: " + client + " cannot pay monthly interests.");
            return false;
        }

        ArrayList<BankProduct> products;
        if (!clients.containsKey(client)) {
            products = new ArrayList<>();
        } else {
            products = clients.get(client);
        }
        capital -= money;
        products.add(new Credit(credit.getName(), duration, credit.getAnnualInterestRate(), money));
        clients.put(client, products);
        return true;
    }

    /**
     * Pays the monthly installment to the credit(s)
     * @param client client of the bank
     * @param money the money with which to pay the installment
     * @return the balance of the money after paying the installment(s).
     */
    public double payCreditInstallment(Client client, double money) {
        boolean flag = false;
        if (!clients.containsKey(client)) {     //check if person is a client of the bank
            System.out.println("No such client of the bank.");
            return money;
        }
        ArrayList<BankProduct> bankProducts = clients.get(client);      //take all the client's banking products
        for (BankProduct bp : bankProducts) {
            if (bp instanceof Credit) {
                if (money > ((Credit) bp).getMonthlyPayment()) {
                    money -= ((Credit) bp).monthlyPayment();
                } else {
                    System.out.println("Name: " + client + " do not have enough money to pay credit.");
                    return money;
                }
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Client do not have any credits.");
        }
        return money;
    }

    public void showDeposits() {
        for (Map.Entry<Client, ArrayList<BankProduct>> client : clients.entrySet()) {
            System.out.println("Client: " + client.getKey());
            for (BankProduct bp : client.getValue()) {
                System.out.printf("     Bank product: %s, duration: %d, annual rate: %.2f, money: %.2f\n", bp.getName(), bp.getDuration(), bp.getAnnualInterestRate(), bp.getAvailability());
            }
        }
    }

    public void showCapital() {
        System.out.printf("Bank capital: %.2f, bank reserve: %.2f\n", capital, (capital*0.9));
    }

    @Override
    public String toString() {
        return "Name: " + name + ", address: " + address;
    }
}
