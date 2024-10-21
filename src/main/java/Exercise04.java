import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise04 {
    @Test
    public void testPaymentAdjust() throws InterruptedException {
        //open web
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

        WebElement account = driver.findElement(By.xpath("//span[contains(text(), 'Accounts')]/.."));
        account.click();

        WebElement paymentAdj = driver.findElement(By.xpath("//span[contains(text(),'Asset Adjustment')]"));
        paymentAdj.click();

        WebElement labelAccountType = driver.findElement(By.xpath("//label[contains(text(),'Account Type')]"));
        Assert.assertTrue(labelAccountType.isDisplayed(), "Account type label is not displayed");

        WebElement accountTypeTextbox  = driver.findElement(By.xpath("//label[contains(text(),'Account Type')]/following::select[1]"));
        Assert.assertTrue(accountTypeTextbox.isDisplayed(), "Account type text box is not displayed");

        WebElement accountSelectAccTextbox = driver.findElement(By.xpath("//label[contains(text(),'Account Type')]/following::select[2]"));
        Assert.assertTrue(accountSelectAccTextbox.isDisplayed(), "Amount select account textbox is not displayed");

        WebElement amount = driver.findElement(By.xpath("//label[contains(text(),'Amount')]/following::input[1]"));
        Assert.assertTrue(amount.isDisplayed(), "Amount textbox is not displayed");

        WebElement descriptionTextbox = driver.findElement(By.xpath("//label[contains(text(),'Description')]/following::input[1]"));
        Assert.assertTrue(descriptionTextbox.isDisplayed(), "Description textbox is not displayed");

        WebElement submitBtn = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        Assert.assertTrue(submitBtn.isDisplayed(), "Submit button is not displayed");

        driver.quit();
    }
}
