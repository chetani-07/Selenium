import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        //WebDriver driver1 = new FirefoxDriver();

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("Chetan I");
        driver.findElement(By.name("inputPassword")).sendKeys("admin123");
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(3000);

        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.xpath("//input[@placeholder=\"Name\"]")).sendKeys("Chetan I");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("chetan@gmail.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("1234567890");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        Thread.sleep(2000);

        String password = getPassword(driver);
        driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Chetan I");
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/form/button")).click();
        Thread.sleep(3000);

        System.out.println(driver.findElement(By.tagName("p")).getText());
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/button")).click();
        //driver.quit();
    }

    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordTxt=driver.findElement(By.cssSelector("form p")).getText();
        passwordTxt.split("'");
        String[] passwordArray = passwordTxt.split("'");
        // String[] passwordArray2 = passwordArray[1].split("'");
        // passwordArray2[0]
        String password = passwordArray[1].split("'")[0];
        return password;

        //0th index - Please use temporary password
        // 1st index - rahulshettyacademy' to Login.
        //0th index - rahulshettyacademy
        //1st index - to Login.
    }
}
