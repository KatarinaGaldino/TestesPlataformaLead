import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestesPlataforma {

    public MyDSL dsl;
	
	public WebDriver driver;
	
	@Before
	public void BeforeMethod() {
		System.setProperty("webdriver.chrome.driver", "/Users/Katarina/Downloads/chromedriver_win32/chromedriver.exe");	
		driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(0, 0));
		driver.get("https://teste.projetolead.com.br/ead2pcd/app/login?ctrl=1");
		dsl = new MyDSL(driver);
	}
	
	@After
	public void AfterMethod() {
		driver.quit();
	}
	
	@Test
	public void testeLogout1() {
		driver.manage().window().setSize(new Dimension(1200, 700));
		driver.get("https://teste.projetolead.com.br/ead2pcd/app/login?ctrl=1");
		
		dsl.escrever("usuario", "alunosurdo");
		dsl.escrever("senha", "abcd1234");
		dsl.clicarPorName("_spring_security_remember_me");
		dsl.clicarTagName("button");
		
		
		dsl.clicarId("imgUsuario");
		dsl.clicarId("logoff");
	}
	
	
	@Test
	public void testeLogout2() {
		driver.manage().window().setSize(new Dimension(700, 700));
		driver.get("https://teste.projetolead.com.br/ead2pcd/app/login?ctrl=1");
		
		dsl.escrever("usuario", "alunosurdo");
		dsl.escrever("senha", "abcd1234");
		dsl.clicarPorName("_spring_security_remember_me");
		dsl.clicarTagName("button");
		
		
		dsl.clicarId("imgUsuario");
		dsl.clicarId("logoff");	
	}
	
	
	@Test
	public void testeRecuperaSenha_EmailValido() {
		driver.manage().window().setSize(new Dimension(1200, 700));
		driver.get("https://teste.projetolead.com.br/ead2pcd/app/login?ctrl=1");
		
		driver.findElement(By.linkText("Esqueci minha senha.")).click();
		driver.findElement(By.id("formRecupera:usuario")).sendKeys("katarinagaldin@gmail.com");
		driver.findElement(By.id("formRecupera:enviar")).click();
		
		driver.findElement(By.tagName("h4")).getText().contains("Pedido realizado com sucesso");
		driver.findElement(By.tagName("div")).getText().contains("Foi enviado para você um e-mail contendo informações para recuperação da senha.");		
	}

	
	@Test
	public void testeRecuperaSenha_EmailInvalido() {
		driver.manage().window().setSize(new Dimension(1200, 700));
		driver.get("https://teste.projetolead.com.br/ead2pcd/app/login?ctrl=1");
		
		driver.findElement(By.linkText("Esqueci minha senha.")).click();
		driver.findElement(By.id("formRecupera:usuario")).sendKeys("email.errado@gmail.com");
		driver.findElement(By.id("formRecupera:enviar")).click();
		
		driver.findElement(By.tagName("div")).getText().contains("Erro no pedido de mudança de senha");		
	}
}
