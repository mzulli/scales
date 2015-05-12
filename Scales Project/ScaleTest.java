import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ScaleTest.
 *
 * @author  Michelle Zulli
 * @version 2015.05.12
 */
public class ScaleTest
{
    private Scale scale1;

    /**
     * Default constructor for test class ScaleTest
     */
    public ScaleTest()
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
        scale1 = new Scale();
        scale1.setStartNote();
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

    @Test
    public void testStartNote()
    {
        scale1.printTonic();
    }

    @Test
    public void testChromatic()
    {
        scale1.printChromatic();
    }

    @Test
    public void testMajor()
    {
        scale1.printMajor();
    }
}



