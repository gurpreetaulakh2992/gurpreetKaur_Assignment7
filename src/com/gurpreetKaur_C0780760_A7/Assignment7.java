package com.gurpreetKaur_C0780760_A7;
/**
 * @author:Gurpreet Kaur
 * enter account number
 * password=12345
 */

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Assignment7 {
    static int accountNo;
    public static void main(String[] args) throws IOException {
        Account acc = new Account();
        boolean isValid = acc.checkCredentials();
        accountNo = acc.getAccountNumber();
        if (isValid) {
            menu();
        }
    }
// function to display menus
    public static void menu() throws IOException {
        int option = 0;
        option = Integer.parseInt(JOptionPane.showInputDialog("1. Deposit Money\n2.Withdraw money\n3.Check Balance\n4.Quit\nSelect option"));
        switch (option) {
            case 1:
                depositMoney();
            case 2:
                withdraw();
            case 3:
                checkBalance();
            case 4:
                System.exit(0);
            default:
                System.out.println("Select a valid option!!");
                break;
        }
    }
//function -Deposit money
    public static void depositMoney() throws IOException {
        String filename = accountNo + ".txt";
        float depositmoney = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the amount you want to deposit"));
        File filename1 = new File(filename);
        Scanner inputFile = new Scanner(filename1);
        while (inputFile.hasNext()) {
            String str = inputFile.nextLine();
            //Spilt file using tab and fetch gender index
            String balance = str;
            System.out.println(balance);
            float newBalance = Float.parseFloat(balance) + depositmoney;
            FileWriter depositFileWriter = new FileWriter(filename);
            PrintWriter prt = new PrintWriter(depositFileWriter);
            prt.println(String.valueOf(newBalance));
            prt.close();
        }
    }
//Function Withdraw
    public static void withdraw() throws IOException {
        String fname = accountNo + ".txt";
        float withDrawMoney = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the amount you want to withdraw"));
        File fname1 = new File(fname);
        Scanner inputFile1 = new Scanner(fname1);
        while (inputFile1.hasNext()) {
            String str = inputFile1.nextLine();
            //Spilt file using tab and fetch gender index
            String balance = str;
            float newBalance = Float.parseFloat(balance) - withDrawMoney;

            FileWriter withDrawFileWriter = new FileWriter(fname1);
            PrintWriter prt = new PrintWriter(withDrawFileWriter);
            prt.println(String.valueOf(newBalance));
            prt.close();
        }
    }
//    Check balance and display
    public static void checkBalance() throws FileNotFoundException {
        String fname = accountNo + ".txt";
        File fname1 = new File(fname);
        Scanner inputFile1 = new Scanner(fname1);
        while (inputFile1.hasNext()) {
            String str = inputFile1.nextLine();
            String balance = "Your balance is: " + str;
            JOptionPane.showMessageDialog(null, balance);
        }
    }
}

