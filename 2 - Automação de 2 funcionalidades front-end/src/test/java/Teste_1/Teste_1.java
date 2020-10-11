package Teste_1;

import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Teste_1 {
    @Test
    public void Teste_1(){
        System.setProperty("webdriver.chrome.driver", "/Users/jhonatanzanetti/Documents/Teste/TesteTecnico_WealthSystems/2 - Automação de 2 funcionalidades front-end/chromedriver");
        WebDriver navegador = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(navegador, 10); //Setando tempo de espera do wait

        //Vai acessar o site do primeiro teste
        navegador.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Variaveis do site
        String s_xPath_BotaoStart = "//button[contains(text(),'Start')]";
        String s_xPath_HelloWorld = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/h4[1]";

        //Espera apresentar e clica no botão start
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(s_xPath_BotaoStart)));
        element.findElement(By.xpath(s_xPath_BotaoStart)).click();

        //Aguarda apresentar o texto após clicar no botão
        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(s_xPath_HelloWorld)));
        String texto = element.findElement(By.xpath(s_xPath_HelloWorld)).getText(); //obtém o texto

        //Valida se houve mudanças no texto comparando com "Hello World!"
        Assert.assertEquals("Hello World!", texto);

        //Fecha o navegador
        navegador.close();
    }
}
