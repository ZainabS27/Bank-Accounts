/**
* The BankAccount class is the parent class of both checkings and savings accounts
* it generates a random bank acoount number and returns the number, owner, and balance of an account, while it
* also implements the functions of a bank account such as deposits and withdrawals
* @author  Zainab Spall
* @version Java 11 / VSCode
* @since   2024-04-24
*/
import java.util.Random;
public class BankAccount{
    private String number;
    private String owner;
    protected double balance;
    private static Random random = new Random(1024);

    public BankAccount(String owner, double balance){
        this.owner = owner;
        this.balance = balance;
        number = "";
        for(int i = 0; i < 10; i++){
           number += random.nextInt(10) + "";
        }
    }

    public String getNumber(){
       return number;
    }
    public String getOwner(){
        return owner;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        balance += amount;
    }
    public boolean withdraw(double amount){
        if(balance < amount){
            return false;
        } else{
            balance -= amount;
            return true;
        }
    }

    @Override
    public String toString(){
        return String.format("%-10s\t%-20s\t%-10.2f", number, owner, balance);
    }

}