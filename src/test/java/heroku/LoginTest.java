package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class LoginTest_sample {
    /**
     TC01: Form Authentication : Login successful with valid credentials
     *
     1. Open browser
     2. Navigate to https://the-internet.herokuapp.com/login
     3. Fill in username with tomsmith
     4. Fill in the password with SuperSecretPassword!
     5. Click on Login button
     6. And the home page is appear
     */
    @Test

    public void successfullyWithValidCredential() throws InterruptedException {
        // Tắt Google Password Manager popup
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/login");
        /**
         * TagName:input
         * Attributes:
         *      + type=text
         *      + name=username
         *      + id=username
         * Text: n/a
         * id => name => tagName => cssSelector => xpath
         * cssSelect formular: [A=t] if A=id ==> #t
         * xpath formular: //*[@A='t']
         */
// Tìm theo id
        //driver.findElement(By.id("username")).sendKeys("tomsmith");
// Tìm theo name
        //driver.findElement(By.name("username")).sendKeys("tomsmith");
// Tìm theo tagName
        //driver.findElement(By.tagName("input")).sendKeys("tomsmith");
// Tìm theo CSS selector (theo tag)
        //driver.findElement(By.cssSelector("input")).sendKeys("tomsmith");
// Tìm theo CSS selector (theo type)
        //driver.findElement(By.cssSelector("[type='text']")).sendKeys("tomsmith");
// Tìm theo XPath (theo type)
        //driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tomsmith");
// Tìm theo CSS selector (theo name)
        //driver.findElement(By.cssSelector("input[name='username']")).sendKeys("tomsmith");
// Tìm theo XPath (theo name)
        //driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");
// Tìm theo CSS selector (theo id)
        //driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
// Tìm theo XPath (theo id)
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("tomsmith");

        //---Password---//
        /**
         * tagName: input
         * Attr:
         *   type = password
         *   name = password
         *   id = password
         * Text: N/A
         **/

// Tìm theo id
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
// Tìm theo name
       // driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
// Tìm theo CSS selector (id)
        //driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");
// Tìm theo CSS selector (tag + id)
       // driver.findElement(By.cssSelector("input#password")).sendKeys("SuperSecretPassword!");
// Tìm theo CSS selector (type)
        //driver.findElement(By.cssSelector("[type=password]")).sendKeys("SuperSecretPassword!");
// Tìm theo CSS selector (name)
       // driver.findElement(By.cssSelector("[name=password]")).sendKeys("SuperSecretPassword!");
// Tìm theo XPath (id)
        //driver.findElement(By.xpath("//*[@id='password']")).sendKeys("SuperSecretPassword!");
// Tìm theo XPath (name)
       // driver.findElement(By.xpath("//*[@name='password']")).sendKeys("SuperSecretPassword!");
// Tìm theo XPath (type)
        //driver.findElement(By.xpath("//*[@type='password']")).sendKeys("SuperSecretPassword!");
// Tìm theo XPath (input + type)
       // driver.findElement(By.xpath("//input[@type='password']")).sendKeys("SuperSecretPassword!");
// Tìm theo CSS selector (kết hợp nhiều attribute)
        //driver.findElement(By.cssSelector("[type=password][name=password]")).sendKeys("SuperSecretPassword!");

        //Button click//
        /**
         * tagName: Button
         * Attr:
         *   class = radius
         *   type  = submit
         * Text: Login
         **/

        // Tìm theo tag + attribute
       // driver.findElement(By.tagName("button")).click();
// Tìm theo name (nút này không có name, bỏ qua)
// Tìm theo className
       // driver.findElement(By.className("radius")).click();
// Tìm theo CSS selector (class)
       // driver.findElement(By.cssSelector(".radius")).click();
// Tìm theo CSS selector (type)
       driver.findElement(By.cssSelector("button[type=submit]")).click();
// Tìm theo CSS selector (class + type)
       // driver.findElement(By.cssSelector("button.radius[type=submit]")).click();
// Tìm theo XPath (theo tag + text)
       // driver.findElement(By.xpath("//button[text()=' Login']")).click();
// Tìm theo XPath (theo contains text)
       // driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
// Tìm theo XPath (theo attribute type)
       // driver.findElement(By.xpath("//button[@type='submit']")).click();
// Tìm theo XPath (theo attribute class)
       // driver.findElement(By.xpath("//button[@class='radius']")).click();
        // Verify URL
        Thread.sleep(2000);
        String expectedUrl = "https://the-internet.herokuapp.com/secure";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "❌ Login không thành công, URL không đúng");

        // Verify message xuất hiện sau khi login
        WebElement flashMessage = driver.findElement(By.id("flash"));
        String messageText = flashMessage.getText();
        Assert.assertTrue(messageText.contains("You logged into a secure area!"),
                "❌ Không thấy message login thành công. Actual: " + messageText);
    }
}