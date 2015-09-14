package starterkit.selenium.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import starterkit.selenium.pages.AddAuthorModal;
import starterkit.selenium.pages.AddNewBookPage;
import starterkit.selenium.pages.BookListPage;
import starterkit.selenium.site.AbstractSelenium;

public class AddNewBookPageTest extends AbstractSelenium {

	private AddNewBookPage addNewBookPage;

	@Before
	@Override
	public void setUp() {
		super.setUp();
		addNewBookPage = openPage().clickBookList().clickAddBook();
	}

	@Test
	public void cancelButtonShouldRedirectToBookList() {
		// given
		// when
		String url = addNewBookPage.clickCancelButton().getCurrentUrl();
		// then
		assertTrue(url.equals("http://localhost:9000/#/books/book-list"));
	}

	@Test
	public void testShouldActualizeBookTitle() {
		// given
		String title = "a title";
		// when
		addNewBookPage.setTitle(title);
		// then
		assertTrue(addNewBookPage.readTitleRepeat().equals(title));
	}

	@Test
	public void testShouldSaveBookIfFormFilledPoperly() {
		// given
		BookListPage bookListPage = addNewBookPage.clickCancelButton().clickSeachButton();
		int before = bookListPage.getBookRowsNumber();
		bookListPage.clickAddBook();
		addNewBookPage.setTitle("aNewTitle");
		AddAuthorModal modal = addNewBookPage.clickAddAuthorButton();
		modal.setName("name");
		modal.setLastName("lastname");
		modal.clickAddButton();
		addNewBookPage = modal.clickOkButton();
		
		// when
		addNewBookPage.clickSaveButton();
		
		// then
		bookListPage = addNewBookPage.clickCancelButton();
		int after = bookListPage.clickSeachButton().getBookRowsNumber();
		assertTrue(after > before);
		cleanUp();
	}
	// ! Assuming than every new added book is placed at the end of the list.
	private void cleanUp() {
		BookListPage bookListPage = openPage().clickBookList().clickSeachButton();
		bookListPage.clickLastDeleteButton();
	}
	
	@Test
	public void testShouldNotSaveAnyBookIfFormNotFilledPoperly() {
		// given
		BookListPage bookListPage = addNewBookPage.clickCancelButton().clickSeachButton();
		int before = bookListPage.getBookRowsNumber();
		bookListPage.clickAddBook();
		addNewBookPage.setTitle("aNewTitle");
		// no author added
		
		// when
		addNewBookPage.clickSaveButton();
		
		// then
		bookListPage = addNewBookPage.clickCancelButton();
		int after = bookListPage.clickSeachButton().getBookRowsNumber();
		assertTrue(after == before);
	}

}
