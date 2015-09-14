package starterkit.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import starterkit.selenium.site.AbstractPageObject;

public class AddNewBookPage extends AbstractPageObject {
	
	@FindBy(name="flash")
	public WebElement flashMessage;
	
	@FindBy(name="title")
	private WebElement titleInput;
	
	@FindBy(name="cancel")
	private WebElement cancelButton;

	@FindBy(name="addAuthor")
	private WebElement addAuthorButton;
	
	@FindBy(name="titleRepeat")
	private WebElement titleRepeat;
	
	@FindBy(name="save")
	private WebElement saveButton;
	
	public AddNewBookPage(WebDriver driver) {
		super(driver);
	}
	
	public AddNewBookPage setTitle(String input) {
		titleInput.sendKeys(input);
		return this;
	}
	
	public String readTitleRepeat() {
		return titleRepeat.getText();
	}
	
	public BookListPage clickCancelButton() {
		cancelButton.click();
		return PageFactory.initElements(driver, BookListPage.class);
	}

	public AddAuthorModal clickAddAuthorButton() {
		addAuthorButton.click();
		return PageFactory.initElements(driver, AddAuthorModal.class);
	}
	
	public String currentURL() {
		return driver.getCurrentUrl();
	}
	
	public AddNewBookPage clickSaveButton() {
		saveButton.click();
		return this;
	}
	
	public boolean flashMessageIsEqual(String expectedMsg) {
		return expectedMsg.equals(flashMessage.getText());
	}
	
}
