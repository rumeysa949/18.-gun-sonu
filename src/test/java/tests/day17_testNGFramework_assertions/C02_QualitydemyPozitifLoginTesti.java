package tests.day17_testNGFramework_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_QualitydemyPozitifLoginTesti {

    @Test
    public void pozitifLoginTesti(){

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        QualitydemyPage qualitydemyPage=  new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();

        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliEmail"));

        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.basariliGirisElementi.isDisplayed());
        ReusableMethods.tumSayfaFotografCek("QualitydemyPozitifLogin");

        Driver.closeDriver();


    }
}
