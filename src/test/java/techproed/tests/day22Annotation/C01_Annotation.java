package techproed.tests.day22Annotation;

import org.testng.annotations.*;

public class C01_Annotation {
    /*
    Testlerimizi yazmak icin kullandigimiz annotation(notasyon)
    @ BeforeSuite : Her bir test suitinden once bir kez calisir
    @ AfterSuite : Her bir test suitinden sonra bir kez calisir
    @BeforeTest : Her bir test oncesi bir kez calisir
    @BAfterTest : Her bir test sonrasi bir kez calisir
    @BeforClass : Her bir classtan once bir kez calisir
    @AfterClass : Her bir classtan sonra bir kez calisir
    @BeforeMethod : Her bir test methodundan once bir kez calisir => JUmitteki @Before ile ayni
    @AfterMethod : Her bir test methodundan sonra bir kez calisir => JUmitteki @After ile ayni
    --TestNG de @BeforeGroups,@AfterGroups,@FindBy gibi notasyonlarda vardir Bunlar ileriki konularda ogrenecegiz.
    --JUnit te BeforeClass ve AfterClass notasyonuna sahip methodlar static olmak zorundadir
    --TestNG freamworkunde boyle bir zorunluluk yoktur.
     */
    @BeforeSuite
    public  void beforeSuite(){
        System.out.println("Before Suite");
    }

    @Test
    public void test1() {
        System.out.println("Test 1 Calisti");

    }

    @Test
    public void test2() {
        System.out.println("Test 2 calisti");
    }

    @Test
    public void test3() {
        System.out.println("Test 3 calisti");
    }

    @Test
    public void test4() {
        System.out.println("Test 4 calisti");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After Method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After test");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }
    /*
Before Suite
Before Test
Before Class
Before Method
Test 1 Calisti
After Method
Before Method
Test 2 calisti
After Method
Before Method
Test 3 calisti
After Method
Before Method
Test 4 calisti
After Method
After Class
After test
After Suite

calistirdigimizda bu siralamada calisir
     */

}
