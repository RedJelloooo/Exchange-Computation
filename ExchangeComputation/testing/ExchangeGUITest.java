import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class ExchangeGUITest {

    /*
     * this function works because it has been previously testing in B01
     */

    DecimalFormat moneyFormat = new DecimalFormat("#.##");

    @Test
    void validConstructors(){
        ExchangeComp customer1 = new ExchangeComp(125);
        ExchangeComp customer2 = new ExchangeComp(540.68f);
        ExchangeComp customer3 = new ExchangeComp(0.52f);
        ExchangeComp customer4 = new ExchangeComp(100200.43f);
    }


}
