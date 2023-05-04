package techproed.tests.day27_XMLFile;

public class XMLFileNotlari {
    /*
    Testng.xml dosyasini indirmek icin plugins install ok.
    Smoke test sag tikla createTesngXml tikla ok .
    File reloadAll from disk tikla.Dosya projede olusur.

    Testleri xml file ile Calistirma Mantigi:
       1.Istedigim classlari tek seferde tek bir Suite altinda calistirabilmek
       2.Istedigim Package yada methodlari tek seferde  tek bir suite altinda calistirabilmek
       3.Farkli classlar icindeki farkli methodlari tek sefer ve tek bir suite altinda calistirabilmek
       4.Group isimleri atadigimiz methodlari tek seferde tek bir suite altinda calistirabilmek

    * suite name= e isim verilir.Bu suite altinda istenilen Testler calisir.
    * verbose= classlar yada methodlar ile ilgili bilgi verir.bu önemli degil, html codelari icinden direk silebiliriz.
    * Sadece  Methodlari calistirmak istiyorsak methodlari,sadece classlari calistirmak istiyorsak classlari calistirabiliriz.
    * exclude name(haric)=exclude ibaresi eklenen methodlar haric tutulur calismaz class'taki diger methodlar calisir.
    * include name=(dahil) bu tag icindeki methodlar test'e dahil olur
    *Testlerimizde .xml file ile belirli gruplari calistirmak istersek @Test notasayonundan sonra  grup parametresi ile isim belirtmek gerekir
    *<Test> tagindan sonra <grup> tag i kullanilir sonrasinda <run> ve <include> taglari kullanilir ve <group> taginin arkasinda hangi pakage yada hangi class oldugu belirtilir.
    *group tagindaki package da 'techproed.*' bu package altindaki bütün(*) package lari conltrol eder.
           */
}
