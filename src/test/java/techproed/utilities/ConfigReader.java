package techproed.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //once properties dosyasindaki verileri okuyabilmek icin Javadan properties classindan
    // bir obje olustururuz.

    public static Properties properties;

    //Herseyden once calismasi icin static bloc icerisinde olusturmus oldugumuz properties
    // dosyasini tanimlar ve atamasini yapariz.
    //File.input.stream ile dosya yolunu akisa aliriz.
    static {
        String dosyaYolu="configuration.properties";//copy path content rooht
        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            properties= new Properties(); //objeyi olusturdu ve atamasini gerceklestirdik.
            properties.load(fis); //fis in okudugu bilgileri properties e yukler.

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //properties dosyasindaki key degerini alip test methodunda kullanabilmek icin bir method olusturmaliyiz

    public static String getProperty(String Key){//String bir deger dondurmesi icin String bir parametre atariz.
        /*
        Test methodundan gonderdigimiz string key degerini alip Configreader classindan getProperty methodunu
        kullanarak bu key e ait value u bize getirir
         */
        return properties.getProperty(Key);

    }

}
