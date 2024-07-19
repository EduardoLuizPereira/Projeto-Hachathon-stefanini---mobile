package steps;

import io.cucumber.java.pt.Dado;
import pageObjects.InicioPage;
import pageObjects.PrincipalPage;
import utils.Utils;

import static utils.Utils.driver;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class InicioSteps {
	public void queEuEstouUsandoOAplicativoDeNotas() {


		
		
		
	}

	@Quando("eu seleciono para ver minhas categorias")
	public void euSelecionoParaVerMinhasCategorias() {
	    new InicioPage(driver).clicarCategorias();
	}
	
	
	@Quando("eu crio uma lista chamada {string}")
	public void euCrioUmaListaChamada(String string) {
		 new InicioPage(driver).criarLista(string);
	}
}
