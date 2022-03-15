package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class RegistrationTests extends Methods {
    @Test
    public void regSuccess()
    {
        click(By.cssSelector("[href='/login?url=%2Fsearch']"));
        click(By.xpath("//*[text()='Click here']"));
        type(By.cssSelector("#name"),"Anna");
        type(By.cssSelector("#lastName"),"Lorder");
        type(By.cssSelector("#email"),"lordera@mail.ru");
        type(By.cssSelector("#password"),"Mmetro1!");

        WebElement y = wd.findElement(By.cssSelector("[formcontrolname='termsOfUse']"));


        //  WebElement n = wd.findElement(By.xpath("//input[@class='ng-dirty ng-touched ng-invalid']"));
//        if(n != null)
//        {
//            n.click();
//        }
//        System.out.println(n);
        //  click(By.cssSelector("input[type='checkbox']"));
//        List<WebElement> elementList=  wd.findElements(By.cssSelector(".ng-dirty.ng-touched.ng-invalid"));
//        elementList.get(0).click();
//        System.out.println(elementList.size());

       // click(By.cssSelector("#terms-of-use"));
      //  click(By.xpath("//*[@class='ng-dirty ng-touched ng-valid']"));
      // click(By.xpath("//*[@class='checkbox-container']"));
       // click(By.xpath("//*[@class='checkbox-label terms-label']"));


//      for(WebElement e:elementList)
//      {
//          System.out.println(e);
//      }
    // elementList.get(1).click();
   //     elementList.get(2).click();
    }
}
