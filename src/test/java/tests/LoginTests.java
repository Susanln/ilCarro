package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends Methods {



    @BeforeMethod
    public void preCondition(){
       if(app.getUser().isLoginSuccess())
       {
           app.getUser().logout();
           logger.info("Test needs logout");
       }
    }
    @Test
    public void loginSuccess()
    {   logger.info("Start test LoginSuccess");
        logger.info("The test starts with data[qdas1@mail.ru] & [Qweasd12]");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm("qdas1@mail.ru","Qweasd12");
        app.getUser().submit();
        app.getUser().pause(1000);
        Assert.assertEquals(app.getUser().checkMessage(),"Logged in success");
        app.getUser().submitOkButton();
        logger.info("Test passed");
    }
    @Test
    public void loginSuccessModel()
    {
        User user= new User().withEmail("qdas1@mail.ru").withPassword("Qweasd12");

        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submit();
        app.getUser().pause(1000);
        Assert.assertEquals(app.getUser().checkMessage(),"Logged in success");
        app.getUser().submitOkButton();
    }
    @Test
    public void loginSuccessNew()
    {
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm("qdas1@mail.ru","Qweasd12");
        app.getUser().submit();
        app.getUser().pause(1000);
        Assert.assertEquals(app.getUser().checkMessage(),"Logged in success");
        app.getUser().submitOkButton();
    }
    @AfterMethod
    public void postCondition()
    {
        app.getUser().submitOkButton();
    }




}
