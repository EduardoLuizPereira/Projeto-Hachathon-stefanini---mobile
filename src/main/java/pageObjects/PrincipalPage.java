package pageObjects;

import static org.junit.Assert.assertTrue;
import static utils.Utils.inputTextAppiumCommand;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PrincipalPage {

	 public PrincipalPage(AppiumDriver<?> driver) {
		 	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button")
	private MobileElement adicionarBtn;

	@AndroidFindBy(accessibility = "Selecionar o tipo de transação")
	private MobileElement campoTransacao;

	@AndroidFindBy(accessibility = "Insira o valor")
	private MobileElement campoInsiraValor;
	
	@AndroidFindBy(accessibility = "Selecione a moeda da transação")
	private MobileElement campoMoedaTransacao;

	@AndroidFindBy(accessibility = "Especificar conta")
	private MobileElement campoEspecificarConta;
	
	@AndroidFindBy(accessibility = "Selecionar um ícone para a categoria")
	private MobileElement campoSelecionarIcone;
	
	@AndroidFindBy(accessibility = "Caso necessário, adicione uma nova categoria")
	private MobileElement campoNovaCategoria;
	
	@AndroidFindBy(accessibility = "Selecione a data")
	private MobileElement campoSelecioneData;
	
	@AndroidFindBy(accessibility = "Adicionar comentário")
	private MobileElement campoAdicionarComentario;
	
	@AndroidFindBy(accessibility = "Você pode adicionar uma foto")
	private MobileElement campoAdicionarFoto;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText")
	private MobileElement campoGasto;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Transporte\"]/android.widget.ImageView")
	private MobileElement categoriaTransporte;
	
	@AndroidFindBy(accessibility = "Adicionar")
	private MobileElement adicionarGastoFinal;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Total R$ 900,00\"]")
	private MobileElement saldo900;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Total R$ 0,00\"]")
	private MobileElement saldo0;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Total -R$ 500,00\"]")
	private MobileElement saldoMenos500;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View")
	private MobileElement frenteActivity;
	
	@AndroidFindBy(accessibility = "RENDA Guia 2 de 2")
	private MobileElement adicionaRenda;
	
	
	public void clicarParaAdicionarGasto() {
		adicionarBtn.click();
	}
	
	public void pularTutorial() {
		campoTransacao.click();
		campoInsiraValor.click();
		campoMoedaTransacao.click();
		campoEspecificarConta.click();
		campoSelecionarIcone.click();
		campoSelecionarIcone.click();
		campoSelecioneData.click();
		campoAdicionarComentario.click();
		campoAdicionarFoto.click();
	}
	
	public void adicionarGasto(String valor) {
		campoGasto.click();
		inputTextAppiumCommand(campoGasto, valor);
	}
	
	public void selecionaTransporte() {
		categoriaTransporte.click();
	}
	
	public void confirmarAdicionarGasto() {
		adicionarGastoFinal.click();
	}
	
	public void confirmaSaldoDe900() {
		frenteActivity.click();
		assertTrue(saldo900.isDisplayed());
	}

	public void confirmaSaldoDe0() {
		frenteActivity.click();
		assertTrue(saldo0.isDisplayed());
	}

	public void confirmaSaldoDe500Negativo() {
		frenteActivity.click();
		assertTrue(saldoMenos500.isDisplayed());
	}

}

