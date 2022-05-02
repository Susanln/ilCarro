package tests;


import manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class Methods {
    Logger logger = LoggerFactory.getLogger(Methods.class);
    @BeforeMethod(alwaysRun = true)
    public void startLogger(Method m){
        logger.info("Start test --->" + m);
    }
    @AfterMethod (alwaysRun = true)
    public void endLogger(Method m){
        logger.info("Finish test--->"+m);
    }

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    @BeforeSuite(alwaysRun = true)
    public void setUp()
    {
       app.init();

    }
    @AfterSuite(alwaysRun = true)
    public void tearDown(){
       app.stop();
    }



}
