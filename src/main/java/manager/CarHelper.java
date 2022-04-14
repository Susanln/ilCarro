package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarHelper extends HelperBase{
    public CarHelper(WebDriver wd){
        super(wd);
    }

    public void openCarForm() {
        pause(1000);
        new WebDriverWait(wd, 20).until(ExpectedConditions.visibilityOf(wd.findElement(By.id("1")))).click();
    }
    public void fillCarForm2(String address, String make, String model, String year, String engine, String fuel
            ,String gear,String wD, String doors, String seats, String carClass, String fuelConsumption, String carRegNumber,
                             String price,String distanceIncluded, String features, String about) {
        typeLocation(address);
        type(By.id("make"), make);
        type(By.id("model"),model);
        type(By.id("year"),year);
        type(By.id("engine"),engine);

        select(By.id("fuel"),fuel);
        select(By.id("gear"),gear);
        select(By.id("wheelsDrive"),wD);

        type(By.id("doors"),doors);
        type(By.id("seats"),seats);
        type(By.id("class"),carClass);
        type(By.id("fuelConsumption"),fuelConsumption);
        type(By.id("serialNumber"),carRegNumber);
        type(By.id("price"),price);
        type(By.id("distance"),distanceIncluded);
        type(By.id("about"),about);
        type(By.cssSelector("[placeholder='Type feature']"),features);
        click(By.xpath("//*[text()='Add feature']"));

    }
    public void fillCarForm(Car car) {
        typeLocation(car.getAddress());
        type(By.id("make"), car.getMake());
        type(By.id("model"),car.getModel());
        type(By.id("year"),car.getYear());
        type(By.id("engine"),car.getEngine());

        select(By.id("fuel"),car.getFuel());
        select(By.id("gear"),car.getGear());
        select(By.id("wheelsDrive"),car.getWD());

        type(By.id("doors"),car.getDoors());
        type(By.id("seats"),car.getSeats());
        type(By.id("class"),car.getCarClass());
        type(By.id("fuelConsumption"),car.getFuelConsumption());
        type(By.id("serialNumber"),car.getCarRegNumber());
        type(By.id("price"),car.getPrice());
        type(By.id("distance"),car.getDistanceIncluded());
        type(By.id("about"),car.getAbout());
        type(By.cssSelector("[placeholder='Type feature']"),car.getFeatures());
        click(By.xpath("//*[text()='Add feature']"));

    }

    private void select(By locator, String option) {
     //   new Select(wd.findElement(locator)).selectByIndex(1);
       // new Select(wd.findElement(locator)).selectByValue(" Diesel ");
        new Select(wd.findElement(locator)).selectByValue(option);
    }

    private void typeLocation(String address) {
        type(By.id("pickUpPlace"),address);
        click(By.cssSelector(".pac-item"));
        pause(500);

    }

    public void attachPhoto(String filePath) {
        By fileInput = By.cssSelector("input[type=file]");
        wd.findElement(fileInput).sendKeys(filePath);
    }

    public void submitOkbutton() {
     click(By.xpath("//*[text()='Show car']"));
    }

    public boolean isCarAdded() {
        new WebDriverWait(wd,10).until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("div.dialog-container"))));
   String message = wd.findElement(By.cssSelector("div.dialog-container h1")).getText();
   //click(By.xpath("//button[text()='Search cars']"));
    return message.equals("Car added");
    }
//    private void multySelect(By locator, String options)
//    {
//        WebElement select = wd.findElement(locator);
//        new Select(select).selectByValue("");
//        new Select(select).selectByValue("");
//        new Select(select).selectByValue("");
//    }
}
