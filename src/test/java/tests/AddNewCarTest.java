package tests;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTest extends Methods{
    @BeforeMethod
    public void preCondition(){

        if(app.getUser().isLoginSuccess()==false)
        {
            User user= new User().withEmail("qdas1@mail.ru").withPassword("Qweasd12");
         app.getUser().openLoginForm();
         app.getUser().fillLoginForm(user);
         app.getUser().submit();
         app.getUser().submitOkButton();
         logger.info("Test start with user--> " + user.getName());
        }

    }
    @Test
    public void addNewCarSuccess(){
        int index = (int)System.currentTimeMillis()/1000%3600;
        Car car = Car.builder().address("Tel aviv").make("BMW").model("M5").year("2022").engine("2.5")
                .fuel("Petrol").gear("AT").wD("AWD").doors("5").seats("5").carClass("C").fuelConsumption("6.5")
                .carRegNumber("100-52-"+ index).price("65").distanceIncluded("500").features("Type of features").about("Very good")
                .build();
        app.getUser().pause(500);
        app.getCar().openCarForm();
        app.getCar().fillCarForm(car);
        app.getCar().attachPhoto("D:/download.jpg");
        logger.info("Attacj photo-->"+ "D:/download.jpg");
        app.getUser().pause(2000);
        app.getCar().submit();
        app.getCar().submitOkbutton();
        Assert.assertTrue(app.getCar().isCarAdded());

    }
}
