import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise02 {
    @Test
    public void testDashboard () throws InterruptedException {

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

        //Verify dashboard:
        WebElement media = driver.findElement(By.xpath("//span[contains(text(), 'Media')]/.."));
        Assert.assertTrue(media.isDisplayed(), "Dashboard is not displayed");

        WebElement catalog = driver.findElement(By.xpath("//span[contains(text(), 'Catalog')]/.."));
        Assert.assertTrue(catalog.isDisplayed(), "Catalog is not displayed");

        WebElement stoke_Inven = driver.findElement(By.xpath("//span[contains(text(),'Stock / Inventory')]/.."));
        Assert.assertTrue(stoke_Inven.isDisplayed(), "Stoke / Inventory is not displayed");


        // Verify panel
        WebElement orderPanel = driver.findElement(By.xpath("//h3[contains(text(), 'Orders')][1]/.."));
        Assert.assertTrue(orderPanel.isDisplayed(), "Order panel is not displayed ");

        WebElement productsPanel = driver.findElement(By.xpath("//h3[contains(text(), 'Products')][1]/.."));
        Assert.assertTrue(productsPanel.isDisplayed(), "Product panel is not displayed");

        WebElement userPanel = driver.findElement(By.xpath("//h3[contains(text(), 'Users')][1]/.."));
        Assert.assertTrue(userPanel.isDisplayed(), "User panel is not displayed.");

        WebElement salePanel = driver.findElement(By.xpath("//h3[contains(text(), 'Sales')][1]/.."));
        Assert.assertTrue(salePanel.isDisplayed(), "Sale panel is not displayed.");

        driver.quit();
    }
}
