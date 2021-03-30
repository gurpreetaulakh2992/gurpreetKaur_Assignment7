package com.gurpreetKaur_C0780760_A7;

import javax.swing.*;
import java.io.IOException;

public class Account {
    static int accountNumber;
    String password;
    float balance;
//empty constructor
    public Account() {
    }

    public Account(int accountNumber, String password) {
        this.accountNumber = accountNumber;
        this.password = password;
    }
//getter and setter
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
    // verify user credentials
    public static boolean checkCredentials() throws IOException {
        String user_password="12345";
        boolean isValid = false;
        String user_input= JOptionPane.showInputDialog(null,"Enter the account number: ");
        if(user_input.length() < 6) {
            System.out.println("Kindly enter a valid account number.");
        }
        else {
            String user_inputPassword = JOptionPane.showInputDialog(null, "Enter password: ");
            if (user_inputPassword.equals(user_password)){
                isValid = true;
            }else{
                JOptionPane.showMessageDialog(null, "Please enter correct password ");
            }
        }
        accountNumber=Integer.parseInt(user_input);
        return isValid;
    }
}
