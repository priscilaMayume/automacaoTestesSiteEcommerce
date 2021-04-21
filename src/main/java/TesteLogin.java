import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteLogin {

    @Test
    public void ClicarContasEListas() {
        System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.br/");
        driver.findElement(By.id("nav-link-accountList")).click();

        Assert.assertEquals("Acessar Amazon", driver.getTitle());

        driver.quit();
    }

    @Test
    public void deveFazerLoginComSucesso() {
        System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.br/");

        driver.findElement(By.id("nav-link-accountList")).click();

        driver.findElement(By.id("ap_email")).sendKeys("ze.silva.testes@gmail.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("brasil@123");
        driver.findElement(By.id("signInSubmit")).click();

        // System.out.println(driver.findElement(By.tagName("body")).getText().contains("Olá, Ze"));
        Assert.assertEquals("Olá, Ze", driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText());

        driver.quit();
    }

    @Test
    public void deveFazerLoginEmailErrado() {
        System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.br/");

        driver.findElement(By.id("nav-link-accountList")).click();

        driver.findElement(By.id("ap_email")).sendKeys("sasaksoojcvd@okdos.com");
        driver.findElement(By.id("continue")).click();
        String captura = driver.findElement(By.className("a-list-item")).getText();

        Assert.assertEquals("Não encontramos uma conta associada a este endereço de e-mail", captura);

        driver.quit();
    }

    @Test
    public void deveFazerLoginComSenhaErrada() {
        System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.br/");

        driver.findElement(By.id("nav-link-accountList")).click();

        driver.findElement(By.id("ap_email")).sendKeys("ze.silva.testes@gmail.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("123456");
        driver.findElement(By.id("signInSubmit")).click();

        String captura = driver.findElement(By.className("a-list-item")).getText();

        Assert.assertEquals("Sua senha está incorreta", captura);

        driver.quit();
    }
}
