public class BankAccountTest {
    public static void main(String[] args){
        BankAccount n = new BankAccount();
        // System.out.println(n.x);
        n.setSavingBalance(1000);
        n.setCheckingBalance(2000);
        n.withdrawChecking(500);
        n.withdrawSaving(500);
        n.displayAmount();
        n.getCheckingBalance();
        n.getSavingBalance();

    }
}