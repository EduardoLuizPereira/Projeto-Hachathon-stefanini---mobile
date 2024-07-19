package pageObjects;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import static utils.Utils.*;

import java.time.Duration;

public class CategoriaPage {
	public CategoriaPage(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "notizen.basic.notes.notas.note.notepad:id/imgPlus")
	private MobileElement maisCategoria;

	public void adicionarCategoria() {
		maisCategoria.click();
	}
	
	
	
	@AndroidFindBy(id = "notizen.basic.notes.notas.note.notepad:id/editText")
	private MobileElement editarTexto;

	public void editarTexto(String texto) {
		editarTexto.sendKeys(texto);
	}
	
	@AndroidFindBy(id = "notizen.basic.notes.notas.note.notepad:id/txtAdd")
	private MobileElement addTextoCat;

	public void preencherCat() {
		addTextoCat.click();
	}
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[2]")
	private MobileElement segundo;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]")
	private MobileElement primeira;

	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.ImageView")
	private MobileElement moverPrimeira;
	


	public void trocar1com2() {
		TouchAction action = new TouchAction(driver);
		new Actions(driver).clickAndHold(primeira).perform();
		new MultiTouchAction(driver);
		action.press(new PointOption().point(moverPrimeira.getLocation().getX(),moverPrimeira.getLocation().getY()))
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .moveTo(new PointOption().point(moverPrimeira.getLocation().getX(),1000)).release();
        
		new MultiTouchAction(driver).add(action).perform();
	}






	public boolean primeiroE2() {
		return primeira.getText().contains("java");
	}

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]")
	private MobileElement removerCat;
	

	public void removerCat() {
		removerCat.click();	
	}






	public boolean verificaRemovido() {
		try{
			removerCat.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	


}
