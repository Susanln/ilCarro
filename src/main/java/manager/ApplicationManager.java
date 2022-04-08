package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    UserHelper user;
    CarHelper car;
    SearchHelper search;

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    public void init(){
        wd = new ChromeDriver();
        logger.info("All tests start in 'ChromeDriver'");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro.xyz/");
        user = new UserHelper(wd);
        car= new CarHelper(wd);
        search = new SearchHelper(wd);
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
      //  wd.quit();
    }
}
