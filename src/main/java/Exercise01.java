import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise01 {
    @Test
    public void testInput(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://rawal-admin.themes-coder.net/admin/login");
        driver.manage().window().maximize();

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));

        //check display
        Assert.assertTrue(email.isDisplayed(), "Email textbox is not displayed");
        Assert.assertTrue(password.isDisplayed(), "Password textbox is not displayed");
        Assert.assertTrue(loginBtn.isDisplayed(), "Login button is not displayed");
        driver.quit();
    }
}
