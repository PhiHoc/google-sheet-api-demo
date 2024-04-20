import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductPage {
    WebDriver driver;
    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public List<List<Object>> getProductData() {
        List<WebElement> productName =  driver.findElements(By.className("vrilistitemname"));
        List<WebElement> productPrice =  driver.findElements(By.className("item_cost"));
        List<List<Object>> products = new ArrayList<>();

        for(int i=0;i<productName.size();i++){
            products.add(Arrays.asList(productName.get(i).getText(),productPrice.get(i).getText()));
        }
        return products;
    }
}
