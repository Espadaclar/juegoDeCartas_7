

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CartaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CartaTest
{
    private Carta carta1_2espad;
    private Carta carta1_4espa;
    private Carta carta1_1espa;
    private Carta carta1_3bast;
    private Carta carta1_12bast;
    private Carta carta1_3oros;
    private Carta carta1_1copas;
    private Carta carta1_7oros;

    /**
     * Default constructor for test class CartaTest
     */
    public CartaTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        carta1_2espad = new Carta(2, 2);
        carta1_4espa = new Carta(4, 2);
        carta1_2espad.ganaA(carta1_4espa, 1);
        carta1_4espa.ganaA(carta1_2espad, 1);
        carta1_1espa = new Carta(1, 2);
        carta1_2espad.ganaA(carta1_1espa, 1);
        carta1_4espa.ganaA(carta1_1espa, 1);
        carta1_1espa.ganaA(carta1_2espad, 1);
        carta1_3bast = new Carta(3, 3);
        carta1_4espa.ganaA(carta1_3bast, 0);
        carta1_4espa.ganaA(carta1_3bast, 3);
        carta1_12bast = new Carta(12, 3);
        carta1_12bast.ganaA(carta1_3bast, 1);
        carta1_3bast.ganaA(carta1_12bast, 1);
        carta1_3oros = new Carta(3, 0);
        carta1_1copas = new Carta(1, 1);
        carta1_7oros = new Carta(7, 0);
        carta1_7oros.ganaA(carta1_3oros, 1);
        carta1_3oros.ganaA(carta1_7oros, 1);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
