import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoogleSheetApiTest {
    private WebDriver driver;
    private ProductPage productPage;
    private SpreadSheetIntegration spreadsheet;
    private String spreadsheetId,range, option;

    @BeforeClass
    public void beforeClass() throws GeneralSecurityException, IOException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://vikwp.com/demo/vikrentitems/products-list/");
        productPage = new ProductPage(driver);
        spreadsheet = new SpreadSheetIntegration();
        spreadsheetId = spreadsheet.createSpreadsheet("Product data");

        range = "A:B";
        option = "USER_ENTERED";
    }

    @Test
    public void Test_01_Save_Product_Data_To_Google_Sheet(){
        List<List<Object>> productData = productPage.getProductData();
        AppendValuesResponse result = spreadsheet.appendValuesToSpreadSheet(spreadsheetId, range, option, productData);

        //Verify number of row and column
        Assert.assertEquals(productData.size(), result.getUpdates().getUpdatedRows().intValue());
        Assert.assertEquals(2, result.getUpdates().getUpdatedColumns().intValue());
    }

    @Test
    public void Test_02_Get_Product_Data_On_Google_Sheet() throws IOException {
        ValueRange result = spreadsheet.getValuesFromSpreadSheet(spreadsheetId,range);
        List<List<Object>> productData = result.getValues();
        System.out.println(productData);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        driver.quit();
        if(spreadsheet!=null){
            spreadsheet.close();
        }
    }
}
