/*
In this problem, you will be creating a program that helps a cashier
 keep track of customer balance and exchange money between US dollars and SWD dollars.

Your program should give the cashier the options to specify the exchange rate between currencies,
initialize the customer balance (in US dollars), withdraw some SWD dollars amount, close the account.
 */
import java.text.DecimalFormat;
import javax.swing.*;

public class ExchangeCompDriverGUI{

    public static void main(String[] args) {

        DecimalFormat moneyFormat = new DecimalFormat("#.##");

        String firstNumber = JOptionPane.showInputDialog("Welcome! How much would you like to add to your new account in USD?");
        float number1 = Float.parseFloat(firstNumber);


        /**
         * this puts the under in a loop if in invalid amount is used
         * loop exits once valid number is used
         */
        boolean validAmount = true;
        if(number1 < 0.01){
            while(validAmount){
                firstNumber = JOptionPane.showInputDialog("Sorry, that was an invalid amount, please try again");
                number1 = Float.parseFloat(firstNumber);
                if(number1 > 0.01){
                    validAmount = false;
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Account created with " + moneyFormat.format(number1) +
                " USD and " + moneyFormat.format(ExchangeComp.getCurrentExchangeRate() * number1) + " SWD");

        ExchangeGUI currentScrn = new ExchangeGUI(number1);
        currentScrn.setSize(800, 300);
        currentScrn.setVisible(true);
        currentScrn.setLocationRelativeTo(null); // centers JFrame
        currentScrn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



}
