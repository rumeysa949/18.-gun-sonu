package tests.day16_testNG_framework;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;

public class C04_QualitydemyPozitifLogin {

    @Test
    public void pozitifLoginTesti(){

        Driver.getDriver().get("https://www.qualitydemy.com/");

       // 2-login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();

        ///3-kullanici email'i olarak valid email girin
        qualitydemyPage.emailKutusu.sendKeys("anevzatcelik@gmail.com");

        //4- kullanici sifresi olarak valid sifre girin
        qualitydemyPage.passwordKutusu.sendKeys("Nevzat152032");

        //5-Login butonuna basarak login olun
        qualitydemyPage.loginButonu.click();

        //6-Basarili olarak giris yapilabildigini test edin

        Assert.assertTrue(qualitydemyPage.basariliGirisElementi.isDisplayed());

        Driver.closeDriver();



    }

}
