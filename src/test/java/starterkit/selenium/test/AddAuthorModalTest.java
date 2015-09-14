package starterkit.selenium.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import starterkit.selenium.pages.AddAuthorModal;
import starterkit.selenium.site.AbstractSelenium;

public class AddAuthorModalTest extends AbstractSelenium {

	private AddAuthorModal addAuthorModal;
	
	@Before
	@Override
	public void setUp() {
		super.setUp();
		addAuthorModal = openPage().clickBookList().clickAddBook().clickAddAuthorButton();
	}
	
	@Test
	public void testShouldChekIfNameFieldOnlyIsNotValid() {
		// when
		addAuthorModal.setName("a name");
		addAuthorModal.clickAddButton();
		// then
		assertFalse(addAuthorModal.getAuthorsAdded().size()>2);
	}

	@Test
	public void testShouldChekIfLastNameFieldOnlyIsNotValid() {
		// when
		addAuthorModal.setLastName("a lastname");
		addAuthorModal.clickAddButton();
		// then
		assertFalse(addAuthorModal.getAuthorsAdded().size()>2);
	}

	@Test
	public void testShouldChekIfEveryFieldFilledIsValid() {
		// when
		addAuthorModal.setName("a name");
		addAuthorModal.setLastName("a lastname");
		addAuthorModal.clickAddButton();
		// then
		assertTrue(addAuthorModal.getAuthorsAdded().size()>2);
	}

	@Test
	public void testShouldChekIfAuthorListDoesntChangeAfterCancel() {
		// when
		addAuthorModal.setName("a name");
		addAuthorModal.setLastName("a lastname");
		addAuthorModal.clickCancelButton();
		// then
		assertFalse(addAuthorModal.getAuthorsAdded().size()>2);
	}
	
	@Test
	public void testShouldChekIfAuthorListDoesntChangeAfterOkOnly() {
		// when
		addAuthorModal.setName("a name");
		addAuthorModal.setLastName("a lastname");
		addAuthorModal.clickOkButton();
		// then
		assertFalse(addAuthorModal.getAuthorsAdded().size()>2);
	}

	@Test
	public void testShouldChekIfAuthorListDoesntChangeAfterOkAfterAdd() {
		// when
		addAuthorModal.setName("a name");
		addAuthorModal.setLastName("a lastname");
		addAuthorModal.clickAddButton();
		addAuthorModal.clickOkButton();
		// then
		assertTrue(addAuthorModal.getAuthorsAdded().size()>2);
	}
	
}
