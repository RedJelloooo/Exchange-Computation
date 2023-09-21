import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;
import javax.swing.*;

public class ExchangeGUI extends JFrame {
    DecimalFormat moneyFormat = new DecimalFormat("#.##");

    private final JButton withdrawSWD;
    private final JButton depoUSD;
    private final JButton withdrawUSD;
    private final JButton depositSWD;
    private final GridLayout layout;
    private final Container container;

    /**
     * This class creates a GUI Grid with buttons and keeps track of current balance and output of bills
     */

    public ExchangeGUI(float amount)
    {
        super("Welcome to ExchangeGUI");
        ExchangeComp Customer = new ExchangeComp(amount);

        layout = new GridLayout(5, 5);
        container = getContentPane();
        setLayout(layout);

        JLabel exchangeRate = new JLabel("The Current Exchange Rate is 1 USD to " + ExchangeComp.getCurrentExchangeRate()*1  + " SWD");
        add(exchangeRate);
        exchangeRate.setVerticalTextPosition(exchangeRate.TOP);
        exchangeRate.setHorizontalTextPosition(exchangeRate.RIGHT);

        JLabel balances = new JLabel("Current Balances: USD: $" + moneyFormat.format(ExchangeComp.getUSDBalance()) + "\n SWD: " + moneyFormat.format(ExchangeComp.getSWDBalance()));
        add(balances);
        balances.setVerticalTextPosition(balances.TOP);
        balances.setHorizontalTextPosition(balances.LEFT);

        /**
         * Withdraw SWD button
         */
        withdrawSWD = new JButton("Withdraw SWD");
        add(withdrawSWD);
        withdrawSWD.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        withdrawSWD.addActionListener(
                new ActionListener()
                {

                    @Override
                    public void actionPerformed(ActionEvent event)
                    {

                        String secNum = JOptionPane.showInputDialog("How much would you like to withdraw from your account in SWD?");
                        float number2 = Float.parseFloat(secNum);
                        Customer.SWDConverter(number2);
                        balances.setText("Current Balanes: USD: $" + moneyFormat.format(ExchangeComp.getUSDBalance()) + "\n SWD: " + moneyFormat.format(ExchangeComp.getSWDBalance()));
                        add(ExchangeComp.SWDBills);
                        add(ExchangeComp.SWDCoins);
                        layout.layoutContainer(container);

                    }
                }
        );

        /**
         * Withdraw USD button
         */
        withdrawUSD = new JButton("Withdraw USD");
        add(withdrawUSD);
        withdrawUSD.addActionListener(
                new ActionListener()
                {

                    @Override
                    public void actionPerformed(ActionEvent event)
                    {

                        String secNum = JOptionPane.showInputDialog("How much would you like to withdraw from your account in USD?");
                        float number2 = Float.parseFloat(secNum);
                        Customer.USDConverter(number2);
                        balances.setText("Current Balances: USD: $" + moneyFormat.format(ExchangeComp.getUSDBalance()) + "\n SWD: " + moneyFormat.format(ExchangeComp.getSWDBalance()));
                        add(ExchangeComp.USDBills);
                        add(ExchangeComp.USDCoins);
                        layout.layoutContainer(container);

                    }
                }
        );

        /**
         * Deposit USD button
         */
        depoUSD = new JButton("Deposit USD");
        add(depoUSD);
        depoUSD.addActionListener(
                new ActionListener()
                {

                    @Override
                    public void actionPerformed(ActionEvent event)
                    {
                        String secNum = JOptionPane.showInputDialog("How much would you like add to from your account in USD?");
                        float number2 = Float.parseFloat(secNum);
                        Customer.depositUSD(number2);
                        balances.setText("Current Balances: USD: $" + moneyFormat.format(ExchangeComp.getUSDBalance()) + "\n SWD: " + moneyFormat.format(ExchangeComp.getSWDBalance()));

                        layout.layoutContainer(container);
                    }
                }
        );

        /**
         * Deposit SWD button
         */
        depositSWD = new JButton("Deposit SWD");
        add(depositSWD);
        depositSWD.addActionListener(
                new ActionListener()
                {

                    @Override
                    public void actionPerformed(ActionEvent event)
                    {
                        String secNum = JOptionPane.showInputDialog("How much would you like add to from your account in SWD?");
                        float number2 = Float.parseFloat(secNum);
                        Customer.depositSWD(number2);
                        balances.setText("Current Balances: USD: $" + moneyFormat.format(ExchangeComp.getUSDBalance()) + "\n SWD: " + moneyFormat.format(ExchangeComp.getSWDBalance()));

                        layout.layoutContainer(container);
                    }
                }
        );
    }
}
