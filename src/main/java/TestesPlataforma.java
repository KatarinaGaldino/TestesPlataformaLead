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
	public void testeLogin_CredenciaisErradas() {
		driver.manage().window().setSize(new Dimension(1200, 700));
		
		dsl.escrever("usuario", "alunosurdo");
		dsl.escrever("senha", "abcd1235");
		dsl.clicarPorName("_spring_security_remember_me");
		dsl.clicarTagName("button");
		
		dsl.pegaTextoPorElemento(By.className("loginerror")).contains("Usuário e/ou senha inválidos. Verifique o usuário e senha e tente novamente.");
	}
	
	
	@Test
	public void testeLogout1() {
		driver.manage().window().setSize(new Dimension(1200, 700));
		
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
		
		dsl.clicarLinkText("Esqueci minha senha.");
		dsl.escrever("formRecupera:usuario", "katarina.galdino@dellead.com");
		dsl.clicarId("formRecupera:enviar");
		
		dsl.pegaTextoPorElemento(By.tagName("h4")).contains("Pedido realizado com sucesso");
		dsl.pegaTextoPorElemento(By.tagName("div")).contains("Foi enviado para você um e-mail contendo informações para recuperação da senha.");		
	}

	
	@Test
	public void testeRecuperaSenha_EmailInvalido() {
		driver.manage().window().setSize(new Dimension(1200, 700));
		
		dsl.clicarLinkText("Esqueci minha senha.");
		dsl.escrever("formRecupera:usuario", "email@errado.com");
		dsl.clicarId("formRecupera:enviar");

		dsl.pegaTextoPorElemento(By.id("formRecupera:msgErroRecuperaSenha")).contains("Erro no pedido de mudança de senha");
	}
	
	@Test
	public void testePerfil() {
		driver.manage().window().setSize(new Dimension(1200, 700));
		
		dsl.escrever("usuario", "katarinaaluna");
		dsl.escrever("senha", "katbug2o1#");
		dsl.clicarTagName("button");
		
		dsl.clicarId("imgUsuario");
		dsl.clicarCss(".popover-content li:nth-child(1) > a");				
	}
	
	@Test
	public void testePerfil_VerificaOpAcessibilidade() {
		driver.manage().window().setSize(new Dimension(1200, 700));
		
		dsl.escrever("usuario", "katarinaaluna");
		dsl.escrever("senha", "katbug2o1#");
		dsl.clicarTagName("button");
		
		dsl.clicarId("imgUsuario");
		dsl.clicarCss(".popover-content li:nth-child(1) > a");
		
		
		if(dsl.verificaSelecao("def:0") == true) {
			System.out.println("Teclado Virtual: ATIVADO");
		}
		else {
			System.out.println("Teclado Virtual: DESATIVADO");
		}
		
		if(dsl.verificaSelecao("def:1") == true) {
			System.out.println("Comando de Voz: ATIVADO");
		}
		else {
			System.out.println("Comando de Voz: DESATIVADO");
		}
		
		if(dsl.verificaSelecao("def:2") == true) {
			System.out.println("Aumentar/Diminuir Fonte: ATIVADO");
		}
		else {
			System.out.println("Aumentar/Diminuir Fonte: DESATIVADO");
		}
		
		if(dsl.verificaSelecao("def:3") == true) {
			System.out.println("Vídeo em Libras: ATIVADO");
		}
		else {
			System.out.println("Vídeo em Libras: DESATIVADO");
		}
		
		if(dsl.verificaSelecao("def:4") == true) {
			System.out.println("Tradução Libras para Português e Português para Libras: ATIVADO");
		}
		else {
			System.out.println("Tradução Libras para Português e Português para Libras: DESATIVADO");
		}
		
		if(dsl.verificaSelecao("def:5") == true) {
			System.out.println("Alto-Contraste: ATIVADO");
		}
		else {
			System.out.println("Alto-Contraste: DESATIVADO");
		}
		
		if(dsl.verificaSelecao("def:6") == true) {
			System.out.println("Alertas Sonoros: ATIVADO");
		}
		else {
			System.out.println("Alertas Sonoros: DESATIVADO");
		}

	}
	
		
	}

