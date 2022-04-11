package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }
    public void type(By locator, String text){
        if(text!=null) {
            WebElement element = wd.findElement(locator);
            element.click();
            pause(500);
            element.clear();
            element.sendKeys(text);
        }
    }
    public void click(By locator){
        wd.findElement(locator).click();

    }
    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }
    public void pause(int milse)
    {
        try {
            Thread.sleep(milse);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void submit() {
        new WebDriverWait(wd,10).until(ExpectedConditions
                .elementToBeClickable(wd.findElement(By.xpath("//button[@type='submit']"))));

        click(By.xpath("//button[@type='submit']"));
    }
    public boolean isYallaButtonNotClickable() {
        return isElementPresent(By.cssSelector("button[disabled]"));
    }
    public void takeScreenShot(String pathToFile){
        File tmp=  ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(pathToFile);
        try {
            Files.copy(tmp,screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
