package tests.day17_testNGFramework_assertions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.ConfigReader.*;
import static utilities.Driver.getDriver;

public class C01_ConfigurationPropertiesKullanimi {

    @Test
    public void test01() {

        // amazon anasayfaya gidin

        Driver.getDriver().get(getProperty("amazonUrl"));
        //parantein icine configuration.properties dosyasindan amazonUrl'i
        // bana getirecek birseyler yazmam lazim

        //arama kutusuna aranacak kelimeyi yazdirin ve aratin
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(getProperty("aranacakKelime")+ Keys.ENTER);

        //arama sonuclarinin aranan kelimeyi icerdigini test edin

        String expectedIcerik = getProperty("amazonAranacakKelime");
        String actualAramaSonucu = amazonPage.sonucYaziElementi.getText();

        Assert.assertTrue(actualAramaSonucu.contains(expectedIcerik));

        //sayfayi kapatin
        ReusableMethods.bekle(1);
        Driver.closeDriver();


    }
}

