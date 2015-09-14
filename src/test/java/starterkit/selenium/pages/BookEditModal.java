package starterkit.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import starterkit.selenium.site.AbstractPageObject;

public class BookEditModal extends AbstractPageObject {

	@FindBy(name="edit")
	private WebElement editButton;
	
	@FindBy(name="ok")
	private WebElement okButton;
	
	@FindBy(name="reqInfo")
	private WebElement reqInfo;
	
	@FindBy(name="title")
	private WebElement inputField;
	
	public BookEditModal(WebDriver driver) {
		super(driver);
	}
	
	public BookEditModal clickEditButton(){
		editButton.click();
		return this;
	}
	
	public BookListPage clickOkButton(){
		okButton.click();
		return PageFactory.initElements(driver, BookListPage.class);
	}
	
	public boolean reqInfoVisible(){
		return reqInfo.isDisplayed();
	}
	
	public BookEditModal insertIntoInputField(String input){
		this.inputField.sendKeys(input);
		return this;
	}

}
