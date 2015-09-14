package starterkit.selenium.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import starterkit.selenium.site.AbstractPageObject;

public class BookListPage extends AbstractPageObject {
	
	@FindBy(name="search")
	private WebElement searchBooksButton;
	
	@FindBy(tagName="tr")
	private List<WebElement> booksTableRow;
	
	@FindBy(name="add")
	private WebElement addBookButton;
	
	@FindBy(id="deleteButton")
	private List<WebElement> deleteBookButton;
	
	@FindBy(id="editButton")
	private WebElement editBookButton;
	
	@FindBy(name="searchInput")
	private WebElement searchInput;

	public BookListPage(WebDriver driver) {
		super(driver);
	}
		
	public BookListPage clickSeachButton() {
		searchBooksButton.click();
		return this;
	}
	
	public int getBookRowsNumber(){
		return booksTableRow.size();
	}
	
	public WebElement getRow(int index) {
		return booksTableRow.get(index);
	}
	
	public AddNewBookPage clickAddBook(){
		addBookButton.click();
		return PageFactory.initElements(driver, AddNewBookPage.class);
	}
	
	public String getCurrentUrl(){
		return driver.getCurrentUrl();
	}
	
	public BookListPage clickFirstDeleteButton() {
		deleteBookButton.get(0).click();
		return this;
	}
	
	public BookEditModal clickFirstEditButton() {
		editBookButton.click();
		return PageFactory.initElements(driver, BookEditModal.class);
	}
	
	public BookListPage setInput(String string){
		searchInput.sendKeys(string);
		return this;
	}
	
	public BookListPage clickLastDeleteButton(){
		deleteBookButton.get(deleteBookButton.size()-1).click();
		return this;
	}
}
