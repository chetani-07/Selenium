import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("name")).sendKeys("Chetan");
        driver.findElement(By.xpath("//*[@id='confirmbtn']")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        System.out.println(alert.getText());
        alert.dismiss();
        driver.findElement(By.id("name")).sendKeys("Chetan");
        driver.findElement(By.cssSelector("#alertbtn")).click();
        Alert alert1=driver.switchTo().alert();
        Thread.sleep(2000);
        System.out.println(alert1.getText());
        alert1.accept();


    }
}
