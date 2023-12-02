import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.xml.transform.sax.SAXSource;

public class AutoWebElements {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //working with static dropdowns
        WebElement staticDropDown=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown=new Select(staticDropDown);

        //using selectByIndex method
        dropdown.selectByIndex(1);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        Thread.sleep(1000);
        //USING selectByVisibleText method
        dropdown.selectByVisibleText("USD");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        //working with passengers list
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        for (int i=0;i<4;i++)
        {   //choosing 5 adults
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();

        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

    }
}
