package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

import java.util.HashMap;
import java.util.Map;

public class DicePage extends BasePage {

    public DicePage(WebDriver driver) {
        super(driver);
    }

    private By countOfDices = By.name("num");
    private By rollDice = By.cssSelector("input[value^='Roll']");
    private By diceNumber = By.cssSelector("img");


    public Map<Integer, Integer> getResultsForDices(int countOfIteration, int dices) {

        Map<Integer, Integer> results = generateMap(dices);

        selectFromDropDown(countOfDices, String.valueOf(dices));

        for (int i = 0; i < countOfIteration; i++) {
            clickOn(rollDice);
            results.put(summOfPoints(diceNumber), results.get(summOfPoints(diceNumber)) + 1);
        }

        return results;
    }


    private Map<Integer, Integer> generateMap(int dices) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = dices; i <= (6 * dices); i++) {
            map.put(i, 0);
        }
        return map;
    }


}
