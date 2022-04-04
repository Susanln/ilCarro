package manager;

import org.openqa.selenium.*;

public class SearchHelper extends HelperBase{

    public SearchHelper(WebDriver wd) {
        super(wd);
    }

    public void searchCurrentMonth(String city, String from, String to) {
        typeCity(city);
        selectPeriod(from,to);

    }

    private void selectPeriod(String from, String to) {
        click(By.id("dates"));
        String[] f =from.split("/");
        String[] t =to.split("/");
        click(By.xpath("//*[text()=' "+f[1]+" ']"));
        click(By.xpath("//*[text()=' "+t[1]+" ']"));

    }

    public void searchCurrentMonthInPast(String city, String from, String to) {
        typeCity(city);
        typePeriodInPast(from,to);
    }

    private void typePeriodInPast(String from, String to) {
       // JavascriptExecutor executor= (JavascriptExecutor) wd;
       // executor.executeScript("document.querySelector('#dates').value='"+from + " - "+ to+"';");
        WebElement toClear = wd.findElement(By.cssSelector("#dates"));
        toClear.sendKeys(Keys.CONTROL + "a");
        toClear.sendKeys(Keys.DELETE);
        type(By.cssSelector("#dates"),from+" - "+to);


    }

    private void typeCity(String city) {
        type(By.id("city"),city);
        click(By.cssSelector(".pac-item"));
        pause(1000);
    }

    public boolean isListOfCarsAppeared() {
        return isElementPresent(By.xpath("//*[@class='car-container ng-star-inserted']"));
    }

    public void switchToGeneral() {
        click(By.cssSelector("[alt='logo']"));
    }
}
