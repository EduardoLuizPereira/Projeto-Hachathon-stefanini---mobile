package pageObjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import static utils.Utils.*;

public class ListaPage {
	 public ListaPage(AppiumDriver<?> driver) {
		 	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
		@AndroidFindBy(id = "notizen.basic.notes.notas.note.notepad:id/imgGuide")
		private MobileElement botaoGuia;
		
		public void clicarGuia() {
			botaoGuia.click();
		}
		
		public boolean listaAberta() {
			return botaoGuia.isDisplayed();
		}

		
		@AndroidFindBy(id = "notizen.basic.notes.notas.note.notepad:id/txtGuide")
		private MobileElement tituloGuia;

		public boolean testaTutorial() {
			return tituloGuia.isDisplayed();
		}
		
		
		@AndroidFindBy(id = "notizen.basic.notes.notas.note.notepad:id/imgPlus")
		private MobileElement novoCheck;

		@AndroidFindBy(id = "notizen.basic.notes.notas.note.notepad:id/editText")
		private MobileElement prencheNome;

		@AndroidFindBy(id = "notizen.basic.notes.notas.note.notepad:id/btnAdd")
		private MobileElement confirmaCheck;
		
		public void novaNotaLista(String string) {
			novoCheck.click();
			prencheNome.sendKeys(string);
			confirmaCheck.click();
		}


		@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.TextView")
		private MobileElement holding;

		public void arrastaPraBaixo() {
			dragAndHoldDoing(holding);
		}

		@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.ImageView")
		private MobileElement primeiroCheck;
		@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.ImageView")
		private MobileElement segundoCheck;
		
		public void concluirItens() {
			primeiroCheck.click();
			segundoCheck.click();
			
		}
		
		@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.ImageView")
		private MobileElement botaoExcluir;

		@AndroidFindBy(id = "notizen.basic.notes.notas.note.notepad:id/btnDelete")
		private MobileElement confirmaExcluir;

		public void excluirTudo() {
			botaoExcluir.click();
			confirmaExcluir.click();
		}
		
		@AndroidFindBy(id = "notizen.basic.notes.notas.note.notepad:id/imgLock")
		private MobileElement senhaOpcao;
		
		@AndroidFindBy(id = "notizen.basic.notes.notas.note.notepad:id/editPassword")
		private MobileElement campoSenha;
		
		@AndroidFindBy(id = "notizen.basic.notes.notas.note.notepad:id/txtBtn")
		private MobileElement prosseguirSenha;
		
		@AndroidFindBy(id = "notizen.basic.notes.notas.note.notepad:id/txtBtn")
		private MobileElement confirmarSenha;

		public void adicionaSenha(String keys) {
			senhaOpcao.click();
			campoSenha.sendKeys(keys);
			prosseguirSenha.click();
			campoSenha.sendKeys(keys);
			confirmarSenha.click();
		}

		@AndroidFindBy(id = "notizen.basic.notes.notas.note.notepad:id/txtTitle")
		private MobileElement itemLista;
		
		public void abrirComSenha(String keys) {
			// POR FAVOR, DESABILITAR IMPRESSAO DIGITAL
			itemLista.click();
			campoSenha.sendKeys(keys);
		}
		
		

		
		
		
		


}
