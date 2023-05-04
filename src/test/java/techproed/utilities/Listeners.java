package techproed.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    /*
    ilk once classi implements ederiz ITEstListener a
    Listeners: TestNG de bir testin durumunu ve sonucunu izleyen ve bu duruma yanit veren bir yapidir.
    Testlerin passed failed olma durumlarini, baslangic ve bitisini takip eder ve raporlayabilir
        Bunun icin TestNg den ITestListener arayuzunu (interface) kullaniriz. olusturdugumuz listerner
         classina Itestlistener arayuzundeki methodlari Override etmek icin implements ederiz.
     */

    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart Methodu -> tüm testlerden once tek bir kere cagrilir"+context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish Methodu -> tüm testlerden sonra tek bir kere cagrilir"+context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart Methodu -> Her bir  testten once tek bir kere cagrilir"+result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess Methodu -> Passed olan  testten sonra tek bir kere cagrilir"+result.getName());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure Methodu -> Failed olan  testten sonra tek bir kere cagrilir"+result.getName());
        ReusableMethods.tumSayfaResmiParametreli(result.getName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped Methodu -> skipp(atlanan) olan  testten sonra tek bir kere cagrilir"+result.getName());

    }
}
