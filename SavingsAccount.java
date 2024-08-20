/**
* The SavingsAccount class is a child class of BankAccount
* it returns owner, balance, yearly interest rate, and applies interest
* @author  Zainab Spall
* @version Java 11 / VSCode
* @since   2024-04-24
*/

public class SavingsAccount extends BankAccount{
    private double yearlyInterestRate;

    public SavingsAccount(String owner, double balance, double yInterestRate){
        super(owner, balance);
        this.yearlyInterestRate = yInterestRate;
    }
    public void setYearlyInterest(double yIR){
        this.yearlyInterestRate = yIR;
    }
    public double getYearlyInterest(){
        return yearlyInterestRate;
    }
    public double getMonthlyInterest(){
        return balance * (yearlyInterestRate / 12 / 100); 
    }
    public double applyInterest(){
        double month = getMonthlyInterest();
        balance += month;
        return month;
    }

    @Override
    public String toString(){
        return String.format("%-10s\t%s\t%-10.2f", "Savings", super.toString(), yearlyInterestRate);
    }
}