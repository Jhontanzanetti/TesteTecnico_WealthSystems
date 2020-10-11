package Teste_2;

import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Teste_2 {
    @Test
    public void Teste_2(){
        System.setProperty("webdriver.chrome.driver", "/Users/jhonatanzanetti/Documents/Teste/TesteTecnico_WealthSystems/2 - Automação de 2 funcionalidades front-end/chromedriver");
        WebDriver navegador = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(navegador, 10); //Setando tempo de espera do wait

        //Vai acessar o site do segundo teste
        navegador.get("https://the-internet.herokuapp.com/challenging_dom");

        //Variaveis do site
        String s_xPath_Botoes_Laterais = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[";
//                                       "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[numero do botao]"

        String s_xPath_BotaoEditDelete = "//tbody/tr[";
        //"//tbody/tr[1]/td[7]/a[1]"
        //"//tbody/tr['numero da linha']/td[7]/a[numero da coluna]"

        //Espera apresentar e clica nos botões laterais
        for (int i = 1;i<=3; i++){
            String s_caminho = (s_xPath_Botoes_Laterais+(i))+"]";
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(s_caminho)));
            element.findElement(By.xpath(s_caminho)).click();
        }

        //Espera apresentar e clica nos botões edit
        for (int i = 1;i<=10; i++){
            String s_caminho = (s_xPath_BotaoEditDelete+(i))+"]/td[7]/a[1]";
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(s_caminho)));
            element.findElement(By.xpath(s_caminho)).click();
        }

        //Espera apresentar e clica nos botões delete
        for (int i = 1;i<=10; i++){
            String s_caminho = (s_xPath_BotaoEditDelete+(i))+"]/td[7]/a[2]";
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(s_caminho)));
            element.findElement(By.xpath(s_caminho)).click();
        }

//        Fecha o navegador
        navegador.close();
    }
}
