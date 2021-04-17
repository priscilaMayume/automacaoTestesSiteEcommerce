import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteLoja {

    @Test
    public void a1_abrirBrowser() {
        System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.br/");

        Assert.assertEquals("Amazon.com.br | Compre livros, Kindle, Echo, Fire Tv e mais.", driver.getTitle());

        driver.quit();
    }

    @Test
    public void a2_deveClicarContasEListas() {
        System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.br/");
        driver.findElement(By.id("nav-link-accountList")).click();

        Assert.assertEquals("Acessar Amazon", driver.getTitle());

        driver.quit();
    }

    @Test
    public void a3_deveFazerLoginComSucesso() {
        System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.br/");

        driver.findElement(By.id("nav-link-accountList")).click();

        driver.findElement(By.id("ap_email")).sendKeys("ze.silva.testes@gmail.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("brasil@123");
        driver.findElement(By.id("signInSubmit")).click();

        driver.quit();
    }
}