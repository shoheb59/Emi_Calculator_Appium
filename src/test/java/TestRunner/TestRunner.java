package TestRunner;

import DataSet.DataSet;
import Pages.EmiPage;
import Setup.AppSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestRunner extends AppSetup {

    @Test(priority = 1)
    public void runSplashScreen()
    {
        EmiPage emiPage=new EmiPage(driver);
        emiPage.clickEMIScreen();
    }

    @Test(priority = 2, dataProvider = "data-provider", dataProviderClass = DataSet.class)
    public void RunTest(int loanAmount, double rInterest, int period, double pFee, int PreviewAmount, double previewInterest, double previewProcessingFee, int previewTotalPayment )
    {
        EmiPage emiPage = new EmiPage(driver);
        emiPage.reset();
        emiPage.calculateEMI(loanAmount, rInterest, period, pFee);

        String emi = emiPage.Preview_MonthlyEmi.getText();
        String interest = emiPage.Preview_TotalInterest.getText();
        String processingFee = emiPage.Preview_ProcessingFees.getText();
        String totalPayment = emiPage.Preview_TotalPayment.getText();

        Assert.assertEquals(Integer.parseInt(String.valueOf(Math.round(Double.parseDouble(emi.replace(",",""))))),PreviewAmount);
        Assert.assertEquals(Integer.parseInt(String.valueOf(Math.round(Double.parseDouble(interest.replace(",",""))))),previewInterest);
        Assert.assertEquals(Integer.parseInt(String.valueOf(Math.round(Double.parseDouble(processingFee.replace(",",""))))),previewProcessingFee);
        Assert.assertEquals(Integer.parseInt(String.valueOf(Math.round(Double.parseDouble(totalPayment.replace(",",""))))),previewTotalPayment);





    }
   @Test(priority = 3)
    public void reset() {
        EmiPage emiPage = new EmiPage(driver);
        emiPage.reset();
   }
}
