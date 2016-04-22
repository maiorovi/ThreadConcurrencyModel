package chapter2.sync;

public class Demo {

    public static void main(String[] args) {
        Account account = new Account(1000);
        Company company = new Company(account);
        Bank bank = new Bank(account);

        Thread companyThread = new Thread(company);

        Thread bankThread = new Thread(bank);

        System.out.printf("Account : Initial Balance: %f\n",account.getBalance());

        companyThread.start();
        bankThread.start();

        try {
            companyThread.join();
            bankThread.join();
            System.out.printf("Account : Final Balance: %f\n",account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
