package Bank;

import java.util.ArrayList;
import java.util.Random;

public class BankDemo {
    public static void main(String[] args) {
        Client c1 = new Client();
        c1.showInfo();
        ArrayList<Client> clients = new ArrayList<>();
        Bank bank = new Bank("OBB", "Street №1", 0);
        bank.addBankDeposit("Short Deposit", 3, 3);
        bank.addBankDeposit("Long Deposit", 12, 5);
        bank.addBankCredit("Home Credit", 6);
        bank.addBankCredit("Consumer Credit", 10);

        for (int i = 0; i < 10; i++) {
            clients.add(new Client());
        }

        Random rand = new Random();
        double money;
        for (Client c : clients) {
            money = c.getMoney();
            c.openNewDeposit(bank, ((rand.nextInt(20) + 80) * money / 100));
        }

        bank.showCapital();

        for (Client c : clients) {
            c.askForNewCredit(bank, (rand.nextInt(49001) + 1000), rand.nextInt(60));
        }
        bank.showDeposits();
        bank.showCapital();

    }
}
