package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmiPage {



    @FindBy(xpath = "\t\n" +
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.ImageView")
    public
    MobileElement btn_EmiCalculator;

    @FindBy (id = "com.continuum.emi.calculator:id/etLoanAmount")
    MobileElement txt_amount;

    @FindBy(id = "com.continuum.emi.calculator:id/etInterest")
    MobileElement txt_interest;

    @FindBy(id = "com.continuum.emi.calculator:id/etPeriod")
    MobileElement txt_years;

    @FindBy(id = "com.continuum.emi.calculator:id/periodMonths")
    MobileElement txt_month;

    @FindBy(id = "com.continuum.emi.calculator:id/etEMI")
    MobileElement txt_EMI;

    @FindBy (id = "com.continuum.emi.calculator:id/etFee")
    MobileElement txt_ProcessingFree;

    @FindBy (id = "com.continuum.emi.calculator:id/rbLoanAmount")
    MobileElement rb_Amount;

    @FindBy (id = "com.continuum.emi.calculator:id/rbInterest")
    MobileElement rb_Interest;

    @FindBy (id = "com.continuum.emi.calculator:id/rbPeriod")
    MobileElement rb_Period;

    @FindBy (id = "com.continuum.emi.calculator:id/rbEMI")
    MobileElement rb_EMI;

    @FindBy(id = "com.continuum.emi.calculator:id/btnCalculate")
    MobileElement btn_Calculate;

    @FindBy(id = "com.continuum.emi.calculator:id/btnReset")
    public
    MobileElement btn_Reset;


    //Output
    @FindBy(id = "com.continuum.emi.calculator:id/monthly_emi_result")
    public
    MobileElement Preview_MonthlyEmi;

    @FindBy (id = "com.continuum.emi.calculator:id/total_interest_result")
    public
    MobileElement Preview_TotalInterest;

    @FindBy (id = "com.continuum.emi.calculator:id/processing_fee_result")
    public
    MobileElement Preview_ProcessingFees;

    @FindBy(id = "com.continuum.emi.calculator:id/total_payment_result")
    public
    MobileElement Preview_TotalPayment;

    //Constructor - same name as class -  it will do for use driver to other pages
    public EmiPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickEMIScreen()
    {
        btn_EmiCalculator.click();
    }

    public void calculateEMI(int loanAmount, double interest, int period, double fee)
    {
        txt_amount.sendKeys(""+loanAmount+"");
        txt_interest.sendKeys(""+interest+"");
        txt_years.sendKeys(""+period+"");
        txt_ProcessingFree.sendKeys(""+fee+"");
        btn_Calculate.click();


    }
    public void reset()
    {
        btn_Reset.click();
   }







}
