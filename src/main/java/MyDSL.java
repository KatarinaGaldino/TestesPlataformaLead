import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyDSL {

	public WebDriver driver;
	
	public MyDSL(WebDriver driver) {
		this.driver = driver;
	}
	
	public void escrever(By by, String texto){
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(texto);
	}

	public void escrever(String id, String texto){
		escrever(By.id(id), texto);
	}
	
	public void clicarPorName(String name) {
    	driver.findElement(By.name(name)).click();
    }
	
	public void clicarTagName(String name) {
    	driver.findElement(By.tagName(name)).click();
    }
	public void clicarClassName(String classe) {
		driver.findElement(By.className(classe));
	}
	
	public void clicarId(String id) {
    	driver.findElement(By.id(id)).click();
    }
	
	public String pegaTextoPorElemento(By by) {
    	return driver.findElement(by).getText();
    }
	
    public String pegaTexto(String id) {
    	return pegaTextoPorElemento(By.id(id));
    }
    
    public void clicarLinkText(String id) {
    	driver.findElement(By.linkText(id)).click();
    }
    
    public void clicarCss(String css) {
    	driver.findElement(By.cssSelector(css)).click();
    }
    
    public void limpaCampo(String id) {
    	driver.findElement(By.id(id)).clear();
    }
    
    public boolean verificaSelecao(String id) {
    	return driver.findElement(By.id(id)).isSelected();
    }
}
