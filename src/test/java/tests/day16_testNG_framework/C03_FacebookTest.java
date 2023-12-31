package tests.day16_testNG_framework;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.Driver.getDriver;

public class C03_FacebookTest {

    @Test
    public void facebookTesti(){
        //1-https://www.facebook.com / adresine gidin

        Driver.getDriver().get("https://www.facebook.com");

        //2- POM'a uygun olarak email,sifre kutularini ve giris yap butonunuu locate edin

        ReusableMethods.bekle(1);

        //3- Faker class'ini kullanarakk email ve sifre degerlerini yazdirip ,giris butonuna basin

        Faker faker = new Faker();
        FacebookPage facebookPage = new FacebookPage();
        ReusableMethods.bekle(1);


        facebookPage.emailKutusu.sendKeys(faker.internet().emailAddress());
        facebookPage.passwordKutusu.sendKeys(faker.internet().password());
        facebookPage.loginButonu.click();


        //4- Basarili giris yapilamadigini test edin

        Assert.assertTrue(facebookPage.girisYapilamadiYaziElementi.isDisplayed());

        ReusableMethods.tumSayfaFotografCek("Facebook");

        Driver.closeDriver();


    }


}
