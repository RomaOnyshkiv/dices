package utils;

import java.util.Map;

public class CalculationHelper {

    public double calculateDeviation(Map<Integer, Integer> inputMap, int dices) {
        double minValue = Double.MAX_VALUE;
        double maxValue = Double.MIN_VALUE;

        for (int i = dices; i <= inputMap.size(); i++) {
            if (inputMap.get(i) == 0) {
                continue;
            }
            if (maxValue <= inputMap.get(i)) {
                maxValue = inputMap.get(i);
            }
            if (minValue >= inputMap.get(i)) {
                minValue = inputMap.get(i);
            }
        }

        return ((maxValue / minValue) * 100) - 100;
    }
}
