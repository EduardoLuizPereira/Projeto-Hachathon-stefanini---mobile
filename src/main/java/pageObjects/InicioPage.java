package pageObjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import static utils.Utils.*;

public class InicioPage {
	public InicioPage(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "notizen.basic.notes.notas.note.notepad:id/imgCategory")
	private MobileElement verCategorias;

	public void clicarCategorias() {
		verCategorias.click();
	}
	
	@AndroidFindBy(id = "notizen.basic.notes.notas.note.notepad:id/btnAddNote")
	private MobileElement novaNota;

	@AndroidFindBy(id = "notizen.basic.notes.notas.note.notepad:id/txtChecklist")
	private MobileElement tipoLista;


	@AndroidFindBy(id = "notizen.basic.notes.notas.note.notepad:id/editText")
	private MobileElement digitoTexto;

	@AndroidFindBy(id = "notizen.basic.notes.notas.note.notepad:id/txtAdd")
	private MobileElement confirmaNota;

	
	
	public void criarLista(String string) {
		novaNota.click();
		tipoLista.click();
		digitoTexto.sendKeys(string);
		confirmaNota.click();
	}

}
