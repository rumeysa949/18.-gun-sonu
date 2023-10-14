package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {

    public  static void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void tumSayfaFotografCek(String resimAdi){


        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmm");
        String tarihEtiketi = ldt.format(formatter);

        String dinamikDosyaYolu = "target/screenShots/" + resimAdi + tarihEtiketi + ".jpg";


        TakesScreenshot tss = (TakesScreenshot) Driver.getDriver();

        File tumSayfaSS = new File(dinamikDosyaYolu);

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);
    }

    public static void webElementFotografCek(WebElement webElement, String resimAdi){}


}
