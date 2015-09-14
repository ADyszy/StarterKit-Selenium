package starterkit.selenium.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import starterkit.selenium.pages.AuthorsListPage;
import starterkit.selenium.site.AbstractSelenium;

public class AuthorsListPageTest extends AbstractSelenium {

	AuthorsListPage authorsListPage;

	@Before
	@Override
	public void setUp() {
		super.setUp();
		authorsListPage = openPage().clickAuthorsDialog();
	}

	@Test
	public void testShouldFindAllAuthorsWhenFindClickedWthNoInput() {
		// given
		// when
		authorsListPage.clickFindButton();
		// then
		assertTrue(authorsListPage.countAuthors() > 0);
	}

	@Test
	public void testShouldFindNoBooksIfFindNeverClicked() {
		// given
		// when
		// then
		assertTrue(authorsListPage.countAuthors() == 0);
	}
	
	@Test
	public void testShouldCheckIfFiltersAreWorking() {
		// given
		// when
		int before = authorsListPage.clickAny().setInput("ak").clickFindButton().countAuthors();
		int after = authorsListPage.clickByName().setInput("ak").clickFindButton().countAuthors();
		// then
		assertTrue(after < before);
		before = authorsListPage.clickAny().setInput("ak").clickFindButton().countAuthors();
		assertTrue(before < after);
	}

}
