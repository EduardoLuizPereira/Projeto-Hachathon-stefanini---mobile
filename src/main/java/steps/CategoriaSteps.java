package steps;

import io.cucumber.java.pt.Dado;
import pageObjects.CategoriaPage;
import pageObjects.PrincipalPage;
import utils.Utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static utils.Utils.driver;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class CategoriaSteps {

	@Dado("que eu estou usando o aplicativo de Notas")
	public void queEuEstouUsandoOAplicativoDeNotas() {

	}

	@Quando("crio uma categoria chamada {string}")
	public void crioUmaCategoriaChamada(String string) {
		new CategoriaPage(driver).adicionarCategoria();
		new CategoriaPage(driver).editarTexto(string);
		new CategoriaPage(driver).preencherCat();

	}

	@Quando("movo a categoria {string} pra cima")
	public void movoACategoriaPraCima(String string) {
		new CategoriaPage(driver).trocar1com2();
	}

	@Entao("a categoria {string} esta em primeira")
	public void aCategoriaEstaEmPrimeira(String string) {
		new CategoriaPage(driver).primeiroE2();
	}
	
	@Entao("clico para remover {string}")
	public void clicoParaRemover(String string) {
	   new CategoriaPage(driver).removerCat();
	   new CategoriaPage(driver).removerCat();
	   // remove os dois
	}

	@Entao("javascript e removido")
	public void javascriptERemovido() {
	    assertFalse(new CategoriaPage(driver).verificaRemovido());
	}
}
