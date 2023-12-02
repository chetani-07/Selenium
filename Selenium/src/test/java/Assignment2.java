import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Chetan I");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Chetan@example.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("RajuBhai");
        driver.findElement(By.cssSelector("input[type='checkbox']")).click();
        driver.findElement(By.xpath("//*[@id='exampleFormControlSelect1']/option[1]")).click();
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("13/08/1947");

        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
    }
}
