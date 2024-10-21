import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise03 {
    @Test
    public void testProductUnit () throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rawal-admin.themes-coder.net/admin/login");
        driver.manage().window().maximize();
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("admin@email.com");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123");
        WebElement loginBtn = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
        loginBtn.click();
        Thread.sleep(3000);

        WebElement catalog = driver.findElement(By.xpath("//span[contains(text(), 'Catalog')]/.."));
        catalog.click();

        WebElement productUnit = driver.findElement(By.xpath("//span[contains(text(), 'Product Units')]/.."));
        productUnit.click();

        WebElement id = driver.findElement(By.xpath("//th[contains(text(),'ID')]"));
        Assert.assertTrue(id.isDisplayed()," ID is not displayed.");

        WebElement name = driver.findElement(By.xpath("//th[contains(text(),'Name')]"));
        Assert.assertTrue(name.isDisplayed(),"Name is not displayed");

        WebElement status = driver.findElement(By.xpath("//th[contains(text(),'Status')]"));
        Assert.assertTrue(status.isDisplayed(),"Status is not displayed");

        WebElement action = driver.findElement(By.xpath("//th[contains(text(),'Action')]"));
        Assert.assertTrue(action.isDisplayed()," Action column is not displayed");

        driver.quit();
    }
}
