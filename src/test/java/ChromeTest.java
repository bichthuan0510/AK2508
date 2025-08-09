import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChromeTest {

    @Test
    public void normalModeTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(), "Selenium");
        driver.quit();
    }

    @Test
    public void headlessModeTest() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(), "Selenium");
        driver.quit();
    }
    @Test
    void openBrowserWithOldVersion() {
        // Tạo ChromeOptions
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("129"); // Chỉ định phiên bản Chrome (cần có driver tương ứng)

        // Mở Chrome
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");

        // Kiểm tra tiêu đề trang
        Assert.assertEquals(driver.getTitle(), "Selenium");

        // Đóng trình duyệt
        driver.quit();
    }
}
