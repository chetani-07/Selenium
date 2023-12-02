import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public interface WebElements {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //Auto Suggestive DropDowns
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(1500);
        //driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        //Using Parent-Child relationship
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='PNQ']")).click();

        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(1500);
        //Find for generic selector that would be containing all the elements..
        List<WebElement> options=driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for (WebElement option:options)
        {
            if (option.getText().equalsIgnoreCase("India"))
            {
                option.click();
                break;
            }
        }

        //CheckBoxes
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected();
        driver.findElement(By.cssSelector("input[id*='IndArm']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());
        System.out.println("Size of CheckBoxes or No. of Checkboxes : " + driver.findElements(By.cssSelector("input[type='checkbox']")).size());

    }
}
