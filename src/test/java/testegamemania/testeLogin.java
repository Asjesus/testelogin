package testegamemania;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testeLogin {
	private WebDriver driver;
	
	@Before 
	public void abrirNavegador() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Arquivos de Programas\\Chrome driver\\chromedriver.exe");
		driver = new ChromeDriver ();
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void testeNavagedor() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:4200/login");
		
		WebElement inputEmail = driver.findElement(By.id("email"));
		WebElement inputSenha = driver.findElement(By.id("senha"));
		WebElement botaoLogin = driver.findElement(By.id("botao-enviar"));
		
		String[] listaSenhas = {"senha1", "senhaerrada","teste", "test", "teste123"};
		
		for(int tentativa = 0; tentativa < listaSenhas.length; tentativa++) {
			try {
			inputEmail.clear();
			inputSenha.clear();
			
			inputEmail.sendKeys("lucas@email.com");
			inputSenha.sendKeys(listaSenhas[tentativa]);
			botaoLogin.click();
		
			Thread.sleep(3000);
			
			} catch(InterruptedException e){
				e.printStackTrace();
			
		}
		}
		}

	
}
