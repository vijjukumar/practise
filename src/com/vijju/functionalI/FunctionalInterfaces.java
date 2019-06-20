package com.vijju.functionalI;

/**
 * Created by e088740 on 2/24/2019.
 */
@FunctionalInterface
public interface FunctionalInterfaces {

    public int accountSummary(String accNumber);

  //  public void accountSummary();

    public static void getAccountSummary(){
        System.out.println("account");
    }

     default  void getAccName(){
        System.out.print("account name");
    }
}
