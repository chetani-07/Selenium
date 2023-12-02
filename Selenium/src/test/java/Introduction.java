import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Introduction
{
    public static void main(String[] args) throws InterruptedException
    {

        //Invoking Browser
        WebDriver driver = new ChromeDriver();
        //WebDriver driver1 = new FirefoxDriver();

        driver.get("https://www.google.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Thread.sleep(2000);

        driver.quit();
    }
}
