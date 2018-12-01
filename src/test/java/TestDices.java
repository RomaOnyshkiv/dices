import dataProviders.TestData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.DicePage;
import utils.BaseTest;
import utils.CalculationHelper;
import utils.TestReporter;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertTrue;

@Listeners({TestReporter.class})
public class TestDices extends BaseTest {

    private Map<Integer, Integer> results = new HashMap<Integer, Integer>();
    private CalculationHelper helper = new CalculationHelper();
    private double deviation;
    private int dices;
    private DicePage dicePage;

    @BeforeMethod
    public void goHome() {
        getDriver().get(BASE_URL);
        dicePage = new DicePage(getDriver());
    }

    @Test(dataProvider = "iterations", dataProviderClass = TestData.class)
    public void testOneDice(int iterations) {
        dices = 1;
        results = dicePage.getResultsForDices(iterations, dices);
        deviation = helper.calculateDeviation(results, dices);
        assertTrue(deviation <= 5, "Maximum deviation is not 5%. Expected <= 5, actual " + deviation);

    }

    @Test(dataProvider = "iterations", dataProviderClass = TestData.class)
    public void testTwoDices(int iterations) {
        dices = 2;
        results = dicePage.getResultsForDices(iterations, dices);
        deviation = helper.calculateDeviation(results, dices);
        assertTrue(deviation <= 5, "Maximum deviation is not 5%. Expected <= 5, actual " + deviation);
    }
}
