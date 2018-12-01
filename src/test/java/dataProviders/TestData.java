package dataProviders;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "iterations")
    public static Object[][] iterations() {
        return new Object[][] {
                {1000},
                {5000},
                {10000}
        };
    }
}
