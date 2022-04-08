package manager;

import org.openqa.selenium.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

        String osname =System.getProperty("os.name");
        System.out.println(osname);
        if(osname.startsWith("Windows"))
        {

        }

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

    public void searchAnyPeriod(String city, String from, String to) {
        typeCity(city);
        selectPeriodAnyData(from,to);
    }

    private void selectPeriodAnyData(String from, String to) {
        LocalDate now = LocalDate.now();
        LocalDate f = LocalDate.parse(from,DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate t = LocalDate.parse(to, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        click(By.id("dates"));
        int diffYear;
        int diffMonth;
        diffYear=f.getYear()-now.getYear();
        if(diffYear==0)
        {
            diffMonth=f.getMonthValue()-now.getMonthValue();
        }
        else{
            diffMonth=12-now.getMonthValue()+ f.getMonthValue();
        }
        clickByNextMonth(diffMonth);
        String locator = String.format("//div[text()=' %s ']",f.getDayOfMonth());
        click(By.xpath(locator));


        diffYear = t.getYear()-f.getYear();
        if(diffYear==0)
        {
            diffMonth=t.getMonthValue()-f.getMonthValue();
        }
        else{
            diffMonth=12-f.getMonthValue()+t.getMonthValue();
        }
        clickByNextMonth(diffMonth);
        locator = String.format("//div[text()=' %s ']",t.getDayOfMonth());
        click(By.xpath(locator));
    }

    private void clickByNextMonth(int count) {
        for (int i = 0; i < count; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));
        }
    }

    public boolean isPeriodInPast() {
        WebElement el = wd.findElement(By.xpath("//div[@class='ng-star-inserted']"));
        String error = el.getText();
        System.out.println(error);
        return error.equals("You can't pick date before today");

    }
}
