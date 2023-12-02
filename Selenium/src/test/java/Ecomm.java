package FunctionalityTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class Ecomm {
    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
        String[] itemsRequired={ "Beetroot", "Tomato", "Potato","Mango", "Banana"};
        System.out.println(products.size());
        List<String> items = Arrays.asList(itemsRequired);
        System.out.println(items);
        int count=0;
        for (int i=0;i<products.size();i++)
        {
            String[] name=products.get(i).getText().split("-");
            String it=name[0].trim();
            if (items.contains(it))
            {
                count+=1;
                driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
            }
            if (count==5)
            {
                break;
            }
        }
    }
}
