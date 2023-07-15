import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class ReferAFriend {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
//            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Navigate to the Amaysim website
        driver.get("https://www.amaysim.com.au");


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Find and click the Login button
        WebElement loginButton = driver.findElement(By.partialLinkText("Login"));
        loginButton.click();

        // Enter the login credentials
        WebElement phoneNumberField = driver.findElement(By.id("username"));
        phoneNumberField.sendKeys("0466134574");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("AWqasde321");

        WebElement loginSubmitButton = driver.findElement(By.xpath("//button[@class='arrow-next']"));
        loginSubmitButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Check if multiple services are presented and pick one

        WebElement servicesList = driver.findElement(By.xpath("//div[@class='sc-eNQAEJ cRCZqq']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        List<WebElement> plans = servicesList.findElements(By.xpath("//div[@id='service_tile_mobile']"));
        if (plans.size() >= 1) {
            plans.get(0).click();
        }
//
//            // Go to "Refer a Friend" page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement referFriendLink = driver.findElement(By.partialLinkText("Refer a friend"));
        referFriendLink.click();

        WebElement textEmail = driver.findElement(By.id("a"));
        textEmail.sendKeys("janedoe@gmail.com");
        WebElement btnShare = driver.findElement(By.xpath("//button[@id='c']"));
        btnShare.click();
//
//            // Validate functionalities on the "Refer a Friend" page
//            // Add your validation code here
//
//            // Close the browser
//            driver.quit();
    }
}