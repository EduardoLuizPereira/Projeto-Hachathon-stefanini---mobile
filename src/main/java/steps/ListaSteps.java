package steps;

import io.cucumber.java.pt.Dado;
import pageObjects.CategoriaPage;
import pageObjects.ListaPage;
import pageObjects.PrincipalPage;
import utils.Utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static utils.Utils.driver;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class ListaSteps {

	@Quando("clico no tutorial")
	public void clicoNoTutorial() {
		new ListaPage(driver).clicarGuia();
	}

	@Entao("vejo o tutorial")
	public void vejoOTutorial() {
		assertTrue(new ListaPage(driver).testaTutorial());
	}

	@Quando("eu volto")
	public void euVolto() {
		driver.navigate().back();
	}

	@Quando("crio item {string}")
	public void crioItem(String string) {
		new ListaPage(driver).novaNotaLista(string);
	}

	@Quando("movo objeto pra baixo")
	public void movoObjetoPraBaixo() {
		new ListaPage(driver).arrastaPraBaixo();
	}

	@Quando("concluo os itens")
	public void concluoOsItens() {
		new ListaPage(driver).concluirItens();
	}

	@Quando("excluo os concluidos")
	public void excluoOsConcluidos() {
		new ListaPage(driver).excluirTudo();
	}

	@Entao("foi tudo concluido")
	public void foiTudoConcluido() {
		boolean res = true;
		try {
			new ListaPage(driver).excluirTudo();
		} catch (Exception e) {
			res = false;
		}
		assertTrue(res);
	}
	
	@Quando("adiciono uma senha")
	public void adicionoUmaSenha() {
		new ListaPage(driver).adicionaSenha("0000");
	}
	
	@Quando("clico na lista para abrir com senha")
	public void clicoNaListaParaAbrirComSenha() {
		new ListaPage(driver).abrirComSenha("0000");
	}

	@Entao("a lista e exibida")
	public void aListaEExibida() {
		assertTrue(new ListaPage(driver).listaAberta());
	}
}
