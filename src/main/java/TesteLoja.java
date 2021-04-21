import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TesteLoja {

    @Test
    public void abrirBrowserComSucesso() {
        System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.br/");

        Assert.assertEquals("Amazon.com.br | Compre livros, Kindle, Echo, Fire Tv e mais.", driver.getTitle());

        driver.quit();
    }

    @Test
    public void ClicarMaisVendidosMenu() {
        System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.br/");

        driver.findElement(By.id("nav-hamburger-menu")).click();

        //Esperar e clicar
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Mais Vendidos")));

        driver.quit();

    }

    @Test
    public void deveVerificarValoresDropdownPesquisa() {
        System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.br/");

        //identificar o campo do combo
        WebElement element = driver.findElement(By.id("searchDropdownBox"));
        //selecionar um elemento do combo
        Select box = new Select(element);
        //retorna uma lista de WebElements
        List<WebElement> options = box.getOptions();

        //Se uma determinada opção está presente no combo
        boolean encontrou = false;
        for (WebElement option : options) {
            if (option.getText().equals("Games")) {
                encontrou = true;
                break;
            }
        }
        Assert.assertTrue(encontrou);

        driver.quit();

    }

    @Test
    public void devePesquisarComBarraDePesquisa() {
        System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.br/");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("1984");
        driver.findElement(By.id("nav-search-submit-button")).click();

        Assert.assertTrue(driver.findElement(By.className("sg-col-inner")).getText().contains("resultados para"));

        driver.quit();

    }
}