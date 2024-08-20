/**
* The TestAccounts program implements the bank account classes to display, find, sort, and apply interest
* to bank account numbers and their owners
* @author  Zainab Spall
* @version Java 11 / VSCode
* @since   2024-04-24
*/

import java.util.Scanner;
public class TestAccounts {
    //main method
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        CheckingAccount[] checkAccounts = new CheckingAccount[5];
        checkAccounts[0] = new CheckingAccount("William Burst", 10000);
        checkAccounts[1] = new CheckingAccount("Nathan Steward", 24900);
        checkAccounts[2] = new CheckingAccount("George Duck", 29990);
        checkAccounts[3] = new CheckingAccount("Sam Lawrence", 3750.75);
        checkAccounts[4] = new CheckingAccount("Doug Pearl", 10.75);

        SavingsAccount[] saveAccounts = new SavingsAccount[5];
        saveAccounts[0] = new SavingsAccount("Isabel Truman", 89250, 10.5);
        saveAccounts[1] = new SavingsAccount("Andrew Sullivan", 12734, 12.1);
        saveAccounts[2] = new SavingsAccount("Emma Stevens", 31250, 8.89);
        saveAccounts[3] = new SavingsAccount("Lara Stevens", 75000, 9.25);
        saveAccounts[4] = new SavingsAccount("Amelia Pearl", 123456, 2.3);

        int choice;
        do{
            System.out.println("1. Display Accounts");
            System.out.println("2. Find Account");
            System.out.println("3. Sort Accounts");
            System.out.println("4. Apply Interest (to all savings accounts)");
            System.out.println("5. Exit");

            while(!s.hasNextInt()){
                s.next();
            }
            choice = s.nextInt();
            if(choice < 1 || choice > 5){
                System.out.println("Invalid choice, try again");
            } else{
                switch(choice){
                    case 1: 
                        //call both versions of print
                        printAccounts(checkAccounts);
                        printAccounts(saveAccounts);
                        break;
                    case 2:
                        //prompt for account number and make sure it is length == 10, call find using input from the user
                        String accountNumber = "";
                        System.out.println("Enter an account number to find");
                        while(true){
                            accountNumber = s.next();
                            if(accountNumber.length() == 10){
                                findAccounts(checkAccounts, saveAccounts, accountNumber);
                                break;
                            } else{
                                System.out.println("Error: account number must be 10 digits long.");
                            }
                        }
                        break;
                    case 3: 
                        //call both versions of sort
                        sortAccounts(checkAccounts);
                        sortAccounts(saveAccounts);
                        break;
                    case 4: 
                        //call apply interest
                        applyInterest(saveAccounts);
                        break;
                    case 5:
                        System.out.println("Goodbye");
                        break;
                    default: System.out.println("Invalid Choice, try again");
                }
            }
        } while(choice != 5);
    }

    /**
    * This method is used to print Checking Accounts
    * and its respective information
    * @param list This is the first parameter 
    * @return void This returns nothing
    */
    public static void printAccounts(CheckingAccount[] list){
        System.out.printf("%-10s\t%-10s\t%-20s\t%-10s\t%s\n", "Type", "Number", "Owner", "Balance", "Interest Rate");
        for(int i = 0; i < list.length; i++){
            System.out.println(list[i]);
        }
    }

    /**
    * This method is used to print Savings Accounts
    * and its respective information
    * @param list This is the first parameter 
    * @return void This returns nothing
    */
    public static void printAccounts(SavingsAccount[] list){
        for(SavingsAccount saveTemp: list){
            System.out.println(saveTemp);
        }
    }

    /**
    * This method is used to find a bank account
    * by checking if an account number matches an account stored in the program
    * @param list1 This is the first parameter 
    * @param list2 This is the second parameter
    * @param acctNum This is the third parameter
    * @return void This returns nothing
    */
    public static void findAccounts(CheckingAccount[] list1, SavingsAccount[] list2, String acctNum){
        int index = -1;
        for(int i = 0; i < list1.length; i++){
            if(list1[i].getNumber().equals(acctNum)){
                index = i;
                System.out.println("Account found!");
                System.out.println(list1[i]);
            }
            if(list2[i].getNumber().equals(acctNum)){
                index = i;
                System.out.println("Account found!");
                System.out.println(list2[i]);
            }
        }
        if(index == -1){
            System.out.println("Account not found!");
        }
    }

    /**
    * This method is used to sort Checking Accounts
    * by the balances that they hold in ascending order
    * @param list This is the first parameter 
    * @return void This returns nothing
    */
    public static void sortAccounts(CheckingAccount[] list){
        //insertion sort ascending order by balance
        for(int i = 1; i < list.length; i++){
            CheckingAccount insertElement = list[i];
            int j = i - 1;
            for( ; j >= 0 && list[j].getBalance() > insertElement.getBalance(); j--){
                list[j + 1] = list[j];
            }
            list[j + 1] = insertElement;
        }
    }

    /**
    * This method is used to sort Savings Accounts
    * by their interest rates in descending order
    * @param list This is the first parameter 
    * @return void This returns nothing
    */
    public static void sortAccounts(SavingsAccount[] list){
        //selection sort descending order by interest rate
        for(int i = 0; i < list.length - 1; i++){
            int maxIndex = i;
            int max = i;
            for(int j = i + 1; j < list.length; j++){
                if(list[j].getYearlyInterest() > list[maxIndex].getYearlyInterest()){
                    maxIndex = j;
                }
            }
            if(maxIndex != i){
                SavingsAccount temp = list[maxIndex];
                list[maxIndex] = list[i];
                list[i] = temp;
            }
        }
    } 

    /**
    * This method is used to apply interest to each
    * of the Savings Accounts
    * @param list This is the first parameter 
    * @return void This returns nothing
    */
    public static void applyInterest(SavingsAccount[] list){
        for(int i = 0; i < list.length; i++){
            list[i].applyInterest();
        }
    }
}