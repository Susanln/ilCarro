package tests;

import manager.MyDataProvider;
import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTest extends Methods{
    @BeforeMethod(alwaysRun = true)
    public void preCondition(){

        if(app.getUser().isLoginUnsuccess())
        {
         new LoginTests().loginSuccessModel();
        }

    }
    @Test(dataProvider = "validAddNewCarData",dataProviderClass = MyDataProvider.class)
    public void addNewCarSuccessWithDataProvider(String address, String make, String model, String year, String engine, String fuel
    ,String gear,String wD, String doors, String seats, String carClass, String fuelConsumption, String carRegNumber,
     String price,String distanceIncluded, String features, String about){
//        int index = (int)System.currentTimeMillis()/1000%3600;
//        Car car = Car.builder().address("Tel aviv").make("BMW").model("M5").year("2022").engine("2.5")
//                .fuel("Petrol").gear("AT").wD("AWD").doors("5").seats("5").carClass("C").fuelConsumption("6.5")
//                .carRegNumber("100-52-"+ index).price("65").distanceIncluded("500").features("Type of features").about("Very good")
//                .build();
        app.getCar().openCarForm();
        app.getCar().fillCarForm2(address,make,model,year,engine,fuel,gear,wD,doors,seats,carClass,fuelConsumption,
                carRegNumber,price,distanceIncluded,features,about);
        app.getCar().attachPhoto("D:/download.jpg");
        logger.info("Attach photo-->"+ "D:/download.jpg");
        app.getUser().pause(2000);
        app.getCar().submit();
        app.getCar().submitOkbutton();
        Assert.assertTrue(app.getCar().isCarAdded());

    }
    @Test(groups = {"problem"})
    public void addNewCarSuccess() {
        int index = (int) (System.currentTimeMillis() / 1000) % 36000;
        logger.info(" 'Car Reg number' 100-22" +index);


        Car car = Car.builder()
                .address("Tel Aviv, Israel")
                .make("BMW")
                .model("M5")
                .year("2022")
                .engine("2.5")
                .fuel("Petrol")
                .gear("MT")
                .wD("AWD")
                .doors("5")
                .seats("4")
                .carClass("C")
                .fuelConsumption("6.5")
                .carRegNumber("100-22-" + index)
                .price("65")
                .distanceIncluded("500")
                .features("Type of features")
                .about("Very good car")
                .build();
        logger.info("Add car --->" + car.toString());

        app.getCar().openCarForm();
        app.getCar().fillCarForm(car);
        app.getCar().attachPhoto("D:/download.jpg");
        logger.info("Attach photo --> D:/download.jpg" );
        app.getCar().submit();
        app.getCar().submitOkbutton();

        Assert.assertTrue(app.getCar().isCarAdded());


    }
}
