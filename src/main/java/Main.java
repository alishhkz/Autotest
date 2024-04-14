import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://www.saucedemo.com/");

        WebElement username_input = driver.findElement(By.xpath("//input[@id='user-name']"));
        WebElement password_input = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement login_btn = driver.findElement(By.xpath("//input[@id='login-button']"));
        By addCardBtn = By.xpath("(//button[text()='Add to cart'])[1]");
        By addCardBtn2 = By.xpath("(//button[text()='Add to cart'])[2]");
        By addCardBtn3 = By.xpath("(//button[text()='Add to cart'])[3]");

        By busketBtn = By.xpath("//a[@class='shopping_cart_link']");
        By continueBtn = By.xpath("//button[@id='continue-shopping']");

        username_input.sendKeys("standard_user");
        Thread.sleep(3000);
        password_input.sendKeys("secret_sauce");
        login_btn.click();
        Thread.sleep(3000);

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addCardBtn));
        button.click();
        Thread.sleep(3000);
        button = wait.until(ExpectedConditions.elementToBeClickable(addCardBtn2));
        button.click();
        Thread.sleep(3000);
        button = wait.until(ExpectedConditions.elementToBeClickable(addCardBtn3));
        button.click();
        Thread.sleep(3000);
        button = wait.until(ExpectedConditions.elementToBeClickable(busketBtn));
        button.click();
        Thread.sleep(3000);
        button = wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        button.click();
        Thread.sleep(3000);
        driver.quit();
    }
}
