package tests;

import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends Methods {
    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLoginSuccess())
        {
            app.getUser().logout();
        }
    }

    @Test
    public void regSuccess()
    {
        int index = (int)System.currentTimeMillis()/1000%3600;
        logger.info("Test start with data: " + " Name:Anna "," Surname:Lomar ", "Email: akdx"+index+"zc@gmail.com "," Password:Zcvbb2ds2!");
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm("Anna","Lomar", "akdx"+index+"zc@gmail.com","Zcvbb2ds2!");
      //  app.getUser().checkPolice();
        app.getUser().checkPoliceXY();
        app.getUser().submit();
        Assert.assertEquals(app.getUser().checkMessage(),"You are logged in success");

    }
    @Test
    public void regSuccessModel()
    {
        int index = (int)System.currentTimeMillis()/1000%3600;
        User user = new User().withName("Anna").withLastname("Lomar").withEmail("akdx"+index+"zc@gmail.com").withPassword("Zcvbb2ds2!");
logger.info("Test start with data: "+user.toString());
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        //  app.getUser().checkPolice();
        app.getUser().checkPoliceXY();
        app.getUser().submit();
        app.getUser().pause(1000);
        Assert.assertEquals(app.getUser().checkMessage(),"You are logged in success");

    }
    @Test
    public void regSuccessWrongPasswordModel()
    {

        User user = new User().withName("Anna").withLastname("Lomar").withEmail("akdxzc@gmail.com").withPassword("12345");
        logger.info("Test start with data: "+user.toString());
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().checkPoliceXY();
        Assert.assertTrue(app.getUser().isErrorPasswordDisplayed());
        Assert.assertTrue(app.getUser().isErrorPasswordDisplayedSize());
        Assert.assertFalse(app.getUser().isYallaButtonNotActive());
        Assert.assertTrue(app.getUser().isYallaButtonNotClickable());
    }
    @Test(dataProvider = "validRegData", dataProviderClass = MyDataProvider.class)
    public void regSuccessWithMyData(String name,String lastName,String email,String password)
    {
        logger.info("Test start with data: " +" Name: "+name," Surname: "+lastName, "Email: " + email," Password: "+password);
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(name,lastName,email,password);
        //  app.getUser().checkPolice();
        app.getUser().checkPoliceXY();
        app.getUser().submit();
        Assert.assertEquals(app.getUser().checkMessage(),"You are logged in success");

    }
    @AfterMethod
    public void postCondition()
    {
        app.getUser().submitOkButton();
    }



}
