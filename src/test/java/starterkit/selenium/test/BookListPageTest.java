package starterkit.selenium.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import starterkit.selenium.pages.BookListPage;
import starterkit.selenium.site.AbstractSelenium;

public class BookListPageTest extends AbstractSelenium {

	private String testBookTitle = "title45689";
	private BookListPage bookListPage;

	@Before
	@Override
	public void setUp() {
		super.setUp();
		bookListPage = openPage().clickBookList();
	}

	@Test
	public void testShouldFindSomeBooksAfterSearchButton() {
		// when
		bookListPage.clickSeachButton();
		int after = bookListPage.getBookRowsNumber();
		// then
		assertTrue(after > 1);
	}

	@Test
	public void testShouldDeleteABook() {
		// given
		bookListPage.clickSeachButton();
		int before = bookListPage.getBookRowsNumber();
		// when
		bookListPage.clickFirstDeleteButton();
		bookListPage.clickSeachButton();
		int after = bookListPage.getBookRowsNumber();
		// then
		assertTrue(before - after == 1);
	}
	
	@Test
	public void testShouldFindBookByPrefix(){
		// given
		addTestBook();
		
		// when
		bookListPage.setInput(testBookTitle).clickSeachButton();
		
		// then
		assertTrue(bookListPage.getBookRowsNumber() > 1);
		cleanUp();
	}
	
	private void addTestBook() {
		bookListPage.clickAddBook().setTitle(testBookTitle).clickAddAuthorButton()
				.setName("name").setLastName("lastname")
				.clickAddButton().clickOkButton().clickSaveButton().clickCancelButton();
	}
	
	private void cleanUp() {
		deleteAllTestTitleInput();
		deleteTestBook();
	}
	
	private void deleteTestBook() {
		bookListPage.setInput(testBookTitle).clickSeachButton().clickFirstDeleteButton();
	}
	
	private void deleteAllTestTitleInput(){
		for (int i=0; i<testBookTitle.length(); i++) {
			bookListPage.setInput("\u0008");
		}
	}

}
