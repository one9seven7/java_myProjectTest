import com.github.javafaker.Faker;
import com.mifmif.common.regex.Generex;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class myProjectTest {

    @Test
    public void myProjectTest() {

        System.setProperty("webdriver.chrome.driver", "c:/drivers/chrome/chromedriver100.exe");
        WebDriver myProjectTest = new ChromeDriver();

        String regex = "\\w{10}\\@gmail\\.com";

        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        myProjectTest.manage().window().maximize();
        myProjectTest.navigate().to("https://myproject.passfail.pl");
        myProjectTest.findElement(By.className("zarejestruj_mnie")).click();

        myProjectTest.findElement(By.xpath("/html/body/div/div/form/span/label/a")).click();
        myProjectTest.findElement(By.xpath("/html/body/div/div/form/fieldset/button")).click();

        myProjectTest.findElement(By.id("myInput_Name")).sendKeys(firstName);
        myProjectTest.findElement(By.id("myInput_Surname")).sendKeys(lastName);
        myProjectTest.findElement(By.id("myInput_Email")).sendKeys(new Generex(regex).random());
        myProjectTest.findElement(By.id("myInput_Occupation")).sendKeys("Tester");
        myProjectTest.findElement(By.id("myInput_Login")).sendKeys(firstName + lastName);
        myProjectTest.findElement(By.id("myInput_Password")).sendKeys("Password123!");
        myProjectTest.findElement(By.id("myInput_Password_Confirm")).sendKeys("Password123!");
        myProjectTest.findElement(By.xpath("/html/body/div/div/form/span/label/input")).click();
        myProjectTest.findElement(By.id("myRegister")).click();

        myProjectTest.findElement(By.xpath("/html/body/div/div/form/fieldset/div/button")).click();

        myProjectTest.findElement(By.id("myInput_Password")).sendKeys("Password123!");
        myProjectTest.findElement(By.xpath("/html/body/div/div/form/fieldset/button")).click();

        myProjectTest.close();
    }
}
