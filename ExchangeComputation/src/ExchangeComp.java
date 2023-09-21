import javax.swing.*;
import java.text.DecimalFormat;

/**
 * very much the same as in B01, but prints have been replaced with GUI outputs
 */
public class ExchangeComp extends JFrame{
    DecimalFormat moneyFormat = new DecimalFormat("#.##");

    //Customer balances
    private static float CustBalUSD = 125.00f;
    private static float CustBalSWD;

    //exchange rate
    private static final float currentExchangeRate = 0.5f;

    ExchangeComp(float inputCashUSD){
        CustBalUSD = inputCashUSD;
        CustBalSWD = inputCashUSD * currentExchangeRate;

    }

    public static float getUSDBalance(){
        return CustBalUSD;
    }

    public static float getSWDBalance(){ // only used for testing
        return CustBalSWD;
    }

    public static float getCurrentExchangeRate(){
        return currentExchangeRate;
    }


    public void depositUSD(float USDinput){
        if(USDinput < 0.00){
            JOptionPane.showMessageDialog(null,"sorry that's an invalid input.", "Error.", JOptionPane.ERROR_MESSAGE);
        }
        else{
            CustBalUSD += USDinput;
            CustBalSWD += (USDinput * currentExchangeRate);
        }

    }

    public void depositSWD(float SWDinput){
        if(SWDinput < 0.00){
            JOptionPane.showMessageDialog(null,"sorry that's an invalid input.", "Error.", JOptionPane.ERROR_MESSAGE);
        }
        else{
            CustBalUSD += SWDinput/currentExchangeRate;
            CustBalSWD += SWDinput;
        }

    }

    public static JLabel SWDBills = new JLabel();
    public static JLabel SWDCoins = new JLabel();

    /**
     * takes given amount and outputs how much of each note/coin is needed
     * this is accomplished by using division to get needed amount then modulous to get the remainder
     */
    public void SWDConverter( float SWDinput) {
        if(SWDinput > CustBalSWD){
            JOptionPane.showMessageDialog(null,"sorry that's more money than is in your account", "Error.", JOptionPane.ERROR_MESSAGE);
        }
        else {
            CustBalSWD -= SWDinput;
            CustBalUSD -= (SWDinput)/currentExchangeRate;
            // this converts the amount (in SWD) to SWD notes
            float SWDleft = SWDinput;

            int SWD25s = (int) (SWDleft / 25);
            SWDleft = SWDleft % 25; //divide to get the amount of bills then modules to get the remainder and repeat

            int SWD10s = (int) (SWDleft / 10);
            SWDleft = SWDleft % 10;

            int SWD5s = (int) (SWDleft / 5);
            SWDleft = SWDleft % 5;

            int SWD1s = (int) (SWDleft); // nothing is left so you can get the 1's


            SWDBills.setText("SWD Change for " + SWDinput + ": /25's: " + SWD25s + " \n/10's: " + SWD10s + " \n/5's: " + SWD5s + " \n/1's: " + SWD1s);


            SWDleft = SWDleft - ((int) SWDleft);

            if (SWDleft >= 0.01) {

                SWDleft = Math.round(SWDleft * 100);
                int change = (int) (SWDleft);

                int SWD20c = change / 20;
                change = change % 20;

                int SWD8c = change / 8;
                change = change % 8;

                int SWD5c = change / 5;
                change = change % 5;

                int SWD1c = change;
                SWDCoins.setText("SWD Coins: 20c: " + SWD20c + " \n/8c: " + SWD8c + " \n/5c: " + SWD5c + " \n/1c: " + SWD1c);
            }
        }
    }

    /**
     * takes given amount and outputs how much of each note/coin is needed
     * this is accomplished by using division to get needed amount then modules to get the remainder
     */

    public static JLabel USDBills = new JLabel();
    public static JLabel USDCoins = new JLabel();
    public void USDConverter(float inputUSD) {
        if(inputUSD > CustBalSWD){
            JOptionPane.showMessageDialog(null,"sorry that's more money than is in your account", "Error.", JOptionPane.ERROR_MESSAGE);
        }
        else {
            CustBalSWD -= inputUSD*currentExchangeRate;
            CustBalUSD -= (inputUSD);

            // this converts the amount (in USD) to USD notes
            float USDleft = inputUSD;

            int USD20 = (int) (USDleft / 20);
            USDleft = USDleft % 20; //divide to get the amount of bills then modules to get the remainder and repeat

            int USD10 = (int) (USDleft / 10);
            USDleft = USDleft % 10;

            int USD5 = (int) (USDleft / 5);
            USDleft = USDleft % 5;

            int USD1 = (int) (USDleft); // nothing is left so you can get the 1's

            USDBills.setText("USD Change for " + inputUSD + ": /20's: " + USD20 + " \n/10's: " + USD10 + " \n/5's: " + USD5 + " \n/1's: " + USD1);

            USDleft = USDleft - ((int) USDleft);


            if (USDleft >= 0.01) {
                USDleft = Math.round(USDleft * 100);
                int change = (int) (USDleft);

                int quarter = (change / 25);
                change = change % 25;

                int dime = (change / 10);
                change = change % 10;

                int nickel = (change / 5);
                change = change % 5;

                int penny = (change);

                USDCoins.setText("USD Coins: quarters: " + quarter + " \n/dimes: " + dime + " \n/nickels: " + nickel + " \n/pennies: " + penny);
            }

        }
    }

}



