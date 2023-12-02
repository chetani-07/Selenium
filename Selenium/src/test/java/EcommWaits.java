package FunctionalityTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class EcommWaits
{
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        addItems(driver);

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promobtn")).click();

    }


    public static void addItems(WebDriver driver)
    {
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        String[] itemsRequired = {"Beetroot", "Tomato", "Potato", "Mango", "Banana"};
        System.out.println("Total products: " + products.size());

        List<String> items = Arrays.asList(itemsRequired);
        System.out.println("Items to be added: " + items);

        int count = 0;
        for (int i = 0; i < products.size(); i++) {
            String itemName = products.get(i).getText().split("-")[0].trim();
            if (items.contains(itemName)) {
                count++;
                driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
            }
            if (count == items.size()) {
                System.out.println("All items added successfully!");
                break;
            }
        }
    }

}
