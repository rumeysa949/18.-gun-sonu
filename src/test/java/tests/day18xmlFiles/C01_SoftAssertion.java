package tests.day18xmlFiles;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroAppPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C01_SoftAssertion {

    @Test
    public void zeroAppTesti(){
        //"https://zero.webappsecurity.com/" Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroAppUrl"));

        //Sign in butonuna basin
        ZeroAppPage zeroAppPage = new ZeroAppPage();
        zeroAppPage.ilkSignInButonu.click();

        // Login kutusuna "username" yazin
        zeroAppPage.loginKutusu.sendKeys(ConfigReader.getProperty("zeroUsername"));


        //Password kutusuna "password" yazin
        zeroAppPage.passwordKutusu.sendKeys(ConfigReader.getProperty("zeroPassword"));

        //sign in tusuna basin
        zeroAppPage.signInButonu.click();

        //back tusuna basip ,Online banking menusu icinde Pay Bills sayfasina gidin
        Driver.getDriver().navigate().back();
        zeroAppPage.onlineBankingLinki.click();
        zeroAppPage.payBillsLinki.click();

        //Purchase Foreign Currency tusuna basin
        zeroAppPage.purchaseForeignCurrencyElementi.click();

        //Currency drop down menusunden Eurozone'u secin
        Select select = new Select(zeroAppPage.pcCurrencyDropdown);
        select.selectByValue("EUR");

        //soft assert kullanarak "Eurozone (euro) " secildigini test edin

        SoftAssert softassert = new SoftAssert();

        String actualSecilmisOpsiyon = select.getFirstSelectedOption().getText();
        String expectedSecilecekOpsiyon = "Eurozone (euro)";

        softassert.assertEquals(actualSecilmisOpsiyon,expectedSecilecekOpsiyon,"secilen opsiyon Eurozone degil");

        //soft assert kullanarak DropDown Listesinin su secenekleri oldugunu test edin "Select One", "Australia (dollar)" , "Canada (dollar)",
        //"Switzerland (franc)", "China(yuan)" , "Denmark (krone)","Eurozone (euro)", "Great Britain (pound)", "Hong Kong (dollar)
        //"Japonya"

        String[] dropdownElementelriArr = {"Select One", "Australia (dollar)" , "Canada (dollar)",
                "Switzerland (franc)", "China(yuan)" , "Denmark (krone)","Eurozone (euro)", "Great Britain (pound)", "Hong Kong (dollar)"};

        List<String> expectedDropDownElementleriList = Arrays.asList(dropdownElementelriArr);

        List<WebElement> dropdownElementleriList = select.getOptions();

        List<String> actualDropdownOpsiyonlariList = new ArrayList<>();

        for (WebElement each: dropdownElementleriList
             ) {
            actualDropdownOpsiyonlariList.add(each.getText());
            
        }

        softassert.assertEquals(actualDropdownOpsiyonlariList,expectedDropDownElementleriList,"dropdown opsiyonlari istenilen sekilde degil");



       softassert.assertAll();

       Driver.closeDriver();

    }
}
