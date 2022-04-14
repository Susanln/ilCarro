package tests;

import manager.MyDataProvider;
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
        Assert.assertTrue(app.getSearch().isPeriodInPast());

    }
    @Test
    public void searchAnyPeriod(){
        app.getSearch().searchAnyPeriod("Tel Aviv","05/05/2022","04/05/2023");
        app.getSearch().submit();
    }
    @Test(dataProvider = "validSearchData",dataProviderClass = MyDataProvider.class)
    public void searchAnyPeriodWithMyData(String city,String from,String to){
        app.getSearch().searchAnyPeriod(city,from,to);
        app.getSearch().submit();
    }
}
