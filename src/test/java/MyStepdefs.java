import Base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

import static Base.Base.driver;


public class MyStepdefs {

    Base variables = new Base();


    @Given("OBSS Girilir")
    public void obssGirilir() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(variables.baseUrl);
        Thread.sleep(2000);
    }

    @When("Cerezler Kabul Edilir")
    public void cerezlerKabulEdilir() {
        WebElement addButton= driver.findElement(By.id(variables.acceptCookies)) ;
        addButton.click();
    }
    @And("Search Ikonuna Tıklanır")
    public void searchIkonunaTıklanır() {
        WebElement searchButton= driver.findElement(By.id(variables.searchIcon)) ;
        searchButton.click();
    }
    @And("Text Alana Automation Yazılır")
    public void textAlanaAutomationYazılır() {
        WebElement searchBox= driver.findElement(By.id(variables.searchBox)) ;
        searchBox.sendKeys("Automation");
        searchBox.sendKeys(Keys.ENTER);
    }
    @And("Sonuçların Geldiği Doğrulanır")
    public void sonuçlarınGeldiğiDoğrulanır() {
        String TEXT = "Testing & Automation";
        String mesaj = driver.findElement(By.cssSelector("body > div.search-form > div > div.container > div > div.col-lg-8.col-md-8.text-start > article:nth-child(1) > h2 > a")).getText();
        Assert.assertEquals(mesaj,TEXT,"kontrol başarısız");
    }
    @And("Çıkan Sonuçlardan Ilkine Tıklanır")
    public void çıkanSonuçlardanIlkineTıklanır() throws InterruptedException {
        Thread.sleep(2000);
        WebElement element= driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/article[1]/h2/a")) ;
        element.click();
    }
    @And("Testing & Automation Sayfasının Açıldığı Doğrulanır")
    public void testingAutomationSayfasınınAçıldığıDoğrulanır() {
        String automationText = "Testing & Automation";
        String mesaj = driver.findElement(By.xpath("/html/body/section[2]/div/div/div/div/h1")).getText();
        Assert.assertEquals(mesaj,automationText,"kontrol başarısız");

    }
    @And("Sayfanın En Altına Gidilir")
    public void sayfanınEnAltınaGidilir() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
    }
    @Then("Obss Footer Geldiği Doğrulanır")
    public void obssFooterGeldiğiDoğrulanır() {
        String automationText = "KVKK";
        String mesaj = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/h2[3]/a")).getText();
        Assert.assertEquals(mesaj,automationText,"kontrol başarısız");
    }
}