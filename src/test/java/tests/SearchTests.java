package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTests extends Methods{
    @BeforeMethod
    public void preConditions(){
        app.getSearch().switchToGeneral();
    }
    @Test
    public void searchCurrentMonth(){
        app.getSearch().searchCurrentMonth("Tel Aviv","4/10/2022","4/20/2022");
        app.getSearch().submit();
        Assert.assertTrue(app.getSearch().isListOfCarsAppeared());
    }
    @Test
    public void searchCurrentMonthInPast(){
        app.getSearch().searchCurrentMonthInPast("Tel Aviv","2/1/2022","4/20/2022");

        Assert.assertTrue(app.getSearch().isYallaButtonNotClickable());

    }
}
