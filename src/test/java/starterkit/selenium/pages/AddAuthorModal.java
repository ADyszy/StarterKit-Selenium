package starterkit.selenium.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import starterkit.selenium.site.AbstractPageObject;

public class AddAuthorModal extends AbstractPageObject {

	public AddAuthorModal(WebDriver driver) {
		super(driver);
	}

	@FindBy(name="addModal")
	private WebElement addButton;

	@FindBy(name="okModal")
	private WebElement okButton;

	@FindBy(name="cancelModal")
	private WebElement cancelButton;
	
	@FindBy(name="name")
	private WebElement nameInput;
	
	@FindBy(name="lastname")
	private WebElement lastNameInput;
	
	@FindBy(tagName="tr")
	private List<WebElement> authorsAdded;
		
	public AddAuthorModal clickAddButton(){
		addButton.click();
		return this;
	}
	
	public AddNewBookPage clickOkButton() {
		okButton.click();
		return PageFactory.initElements(driver, AddNewBookPage.class);
	}
	
	public AddNewBookPage clickCancelButton() {
		cancelButton.click();
		return PageFactory.initElements(driver, AddNewBookPage.class);
	}
	
	public AddAuthorModal setName(String name) {
		nameInput.sendKeys(name);
		return this;
	}
	
	public AddAuthorModal setLastName(String lastName) {
		lastNameInput.sendKeys(lastName);
		return this;
	}
	
	public List<WebElement> getAuthorsAdded(){
		return authorsAdded;
	}
 	
}
