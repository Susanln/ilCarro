package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    EventFiringWebDriver wd;
    UserHelper user;
    CarHelper car;
    SearchHelper search;
    String browser;

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init(){

        if(browser.equals(BrowserType.CHROME))
        {
            wd = new EventFiringWebDriver(new ChromeDriver()) ;
            logger.info("All tests start in 'ChromeDriver'");
        }else if(browser.equals(BrowserType.FIREFOX))
        {
            wd = new EventFiringWebDriver(new FirefoxDriver()) ;
            logger.info("All tests start in 'FirefoxDriver'");
        }

        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro.xyz/");
        user = new UserHelper(wd);
        car= new CarHelper(wd);
        search = new SearchHelper(wd);
        wd.register(new MyListener());
    }

    public CarHelper getCar() {
        return car;
    }

    public UserHelper getUser() {
        return user;
    }

    public SearchHelper getSearch() {
        return search;
    }

    public void stop() {
       wd.quit();
    }
}
