package com.driver;

public class BankAccount {

    private String name;
    public double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
     this.name=name;
     this.balance=balance;
     this.minBalance=minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
         if(sum>digits*9){
            throw new RuntimeException("Account Number can not be generated");
         }

         String ans="";
         int count=0;
          while(sum>0){
            if(sum>=9){
                sum-=9;
                ans+="9";
            }else{
                ans+=sum;
                sum=0;

            }
            count++;
          } 
          while(count<digits){
            ans+="0";
            count++;
          }        
      return ans;

    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance+=amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
             if((this.balance-amount)<this.minBalance){
                throw new RuntimeException("Insufficient Balance");
             }
             this.balance-=amount;
            // System.out.println("Amount withdraw Succefully");
   
    }

}