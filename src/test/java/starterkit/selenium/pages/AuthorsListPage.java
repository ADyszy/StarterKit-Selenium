package starterkit.selenium.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import starterkit.selenium.site.AbstractPageObject;

public class AuthorsListPage extends AbstractPageObject {

	@FindBy(name="findButton")
	private WebElement findButton;
	
	@FindBy(name="authorInput")
	private WebElement authorInput;
	
	@FindBy(linkText="Any")
	private WebElement any;
	
	@FindBy(linkText="By Name")
	private WebElement byName;
	
	@FindBy(linkText="By LastName")
	private WebElement byLastName;
	
	@FindBy(tagName="tr")
	private List<WebElement> rows;
	
	
	public AuthorsListPage(WebDriver driver) {
		super(driver);
	}
	
	public AuthorsListPage clickFindButton() {
		findButton.click();
		return this;
	}

	public AuthorsListPage setInput(String input) {
		authorInput.sendKeys(input);
		return this;
	}
	
	public AuthorsListPage clickAny(){
		any.click();
		return this;
	}
	
	public AuthorsListPage clickByName(){
		byName.click();
		return this;
	}
	
	public AuthorsListPage clickByLastname(){
		byLastName.click();
		return this;
	}
	
	public int countAuthors(){
		return rows.size()-1;
	}
	
}
