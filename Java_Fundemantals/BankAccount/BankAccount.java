import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;

public class BankAccount {
    private String accountNumber;
    private double checkingBalance;
    private double savingBalance;
    public static int numberOfAccounts = 0;
    public static double amountOfMoney = 0;

    private String randomTen(){
        String num = "";
        for(int i=0; i<10; i++){
            int b = (int)(Math.random()*(9-0)+0);
            num = num + b;
        }
        return num;
    }
    public BankAccount(){
        this.accountNumber = randomTen();
        BankAccount.numberOfAccounts++;
    }
    public void getCheckingBalance(){
        System.out.println(this.checkingBalance);
    }
    public void getSavingBalance(){
        System.out.println(this.savingBalance);
    }
    public void setSavingBalance(double amount){
        this.savingBalance += amount;
        this.amountOfMoney += amount;
    }
    public void setCheckingBalance(double amount){
        this.checkingBalance += amount;
        this.amountOfMoney += amount;
    }
    public void withdrawChecking(double amo){
        if(this.checkingBalance-amo >= 0){
            this.checkingBalance -= amo;
            this.amountOfMoney -=amo;
        }
    }
    public void withdrawSaving(double amo){
        if(this.savingBalance-amo >= 0){
            this.savingBalance -= amo;
            this.amountOfMoney -=amo;
        }
    }
    public void displayAmount(){
        System.out.println(this.amountOfMoney);
    }
}