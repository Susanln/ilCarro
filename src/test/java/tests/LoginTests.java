package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTests extends Methods {
    @Test
    public void loginSuccess()
    {
        click(By.cssSelector("[href='/login?url=%2Fsearch']"));
        type(By.cssSelector("#email"),"susanln@mail.ru");
        type(By.cssSelector("#password"),"mmetro123");
        click(By.xpath("//button[@type='submit']"));
    }

}
