import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class demoBorland extends BaseTest {




@BeforeMethod
public void loginbeforetests(){

}
    WebDriver driver = new ChromeDriver();
public demoBorland siteyeGit() {
    System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");

    driver.get("http://demo.borland.com/InsuranceWebExtJS/");
    driver.manage().window().maximize();
    return this;
}
public demoBorland kayitOl()
{
   driver.findElement(By.id("login-form:signup")).click();

   return this;
}
    public String createRandomText(int textSize) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < textSize; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();

        return output;
    }
    public String createRandomNumber(int length) {
        Random r = new Random();
        List<Integer> digits = new ArrayList<Integer>();
        String number = "";

        for (int i = 0; i < length - 1; i++) {
            digits.add(i);
        }

        for (int i = length - 1; i > 0; i--) {
            int randomDigit = r.nextInt(i);
            number += digits.get(randomDigit);
            digits.remove(randomDigit);
        }

        number = "1" + number;

        return number;
    }
    String email =createRandomText(7);

    public demoBorland textleriDoldur(){
       driver.findElement(By.id("signup:fname")).sendKeys(createRandomText(5));
       driver.findElement(By.id("signup:lname")).sendKeys(createRandomText(7));
       driver.findElement(By.xpath("//*[@id=\"BirthDate\"]")).sendKeys(createRandomNumber(2)+"/"+createRandomNumber(2)+"/"+"1992");
       driver.findElement(By.id("signup:email")).sendKeys( email+"@gmail.com");
       driver.findElement(By.id("signup:street")).sendKeys(createRandomText(30));
       driver.findElement(By.id("signup:city")).sendKeys(createRandomText(7));
       driver.findElement(By.id("signup:state")).sendKeys("Alaska");
       driver.findElement(By.id("signup:zip")).sendKeys(createRandomNumber(5));
       driver.findElement(By.id("signup:password")).sendKeys("123456789");

        return this;
    }
    public demoBorland signUp(){
    driver.findElement(By.id("signup:signup")).click();
    return this;
    }
    public demoBorland logIn(){
        driver.findElement(By.id("signup:continue")).click();
        driver.findElement(By.xpath("//*[@id=\"home\"]/a")).click();
driver.findElement(By.id("logout-form:logout")).click();
driver.findElement(By.id("login-form:email")).sendKeys(email+"@gmail.com");
driver.findElement(By.id("login-form:password")).sendKeys("123456789");
driver.findElement(By.id("login-form:login")).click();
return this;
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0001 : Kayıt ol ekranının doldurulması")
    public void TS0001 () throws InterruptedException {
    siteyeGit();
    kayitOl();
    textleriDoldur();
    signUp();
    logIn();

    }


}