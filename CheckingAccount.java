/**
* The CheckingAccount class is a child class of BankAccount
* so it returns owner and balance, and it also prints checking information
* @author  Zainab Spall
* @version Java 11 / VSCode
* @since   2024-04-24
*/

public class CheckingAccount extends BankAccount{
    //constructor
    public CheckingAccount(String owner, double balance){
        super(owner, balance);
    }

    //override toString
    @Override
    public String toString(){
        return String.format("%-10s\t%s", "Checking", super.toString());
    }
}