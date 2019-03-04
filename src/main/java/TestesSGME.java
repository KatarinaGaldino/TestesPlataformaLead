import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestesSGME {

public MyDSL dsl;
	
	public WebDriver driver;
	
	@Before
	public void BeforeMethod() {
		System.setProperty("webdriver.chrome.driver", "/Users/Katarina/Downloads/chromedriver_win32/chromedriver.exe");	
		driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(1200, 700));
		driver.get("http://teste.projetolead.com.br/sgme-spa/pt/login");
		dsl = new MyDSL(driver);
	}
	
	@After
	public void AfterMethod() {
		driver.quit();
	}
	
	@Test
	public void testeLogin_CredenciaisErradas() {
		dsl.escrever("login", "email@errado.com");
		dsl.escrever("inputPassword", "abcd1235");
		dsl.clicarId("btnLogin");
		//dsl.pegaTextoPorElemento(By.tagName("div")).contains("Usuário e/ou senha inválidos. Verifique o usuário e senha e tente novamente.");
		Assert.assertEquals("Usuário e/ou senha inválidos. Verifique o usuário e senha e tente novamente.", dsl.pegaTextoPorElemento(By.tagName("div")));
	}
	
	@Test
	public void testeLogin_Email() {
		dsl.escrever("login", "katarina.galdino@dellead.com");
		dsl.escrever("inputPassword", "abcd1234");
		dsl.clicarId("btnLogin");
	}
	
}
