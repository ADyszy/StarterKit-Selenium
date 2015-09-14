package starterkit.selenium.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import starterkit.selenium.pages.BookEditModal;
import starterkit.selenium.site.AbstractSelenium;

public class BookEditModalTest extends AbstractSelenium {

	private BookEditModal bookEditModal;
	
	@Before
	@Override
	public void setUp() {
		super.setUp();
		bookEditModal = openPage().clickBookList().clickSeachButton().clickFirstEditButton();
	}
	
	@Test
	public void testShouldCheckIfRequiredInfoIfInputIsEmpty() {
		// when
		bookEditModal.clickEditButton();
		// then
		assertTrue(bookEditModal.reqInfoVisible());
	}
	
	@Test
	public void testShouldCheckIfNoRequiredInfoIfInputIsNotEmpty() {
		// TODO: revert changes maybe.
		// given
		String input = createRandomFiveCharInput();
		bookEditModal.insertIntoInputField(input);
		// when
		bookEditModal.clickEditButton();
		// then
		assertTrue(bookEditModal.clickOkButton().getRow(1).getText().contains(input));
	}
	
	// to make sure that after cleaning up the possibility of delete another data
	// is not big.. 
	private String createRandomFiveCharInput(){
		List<Character> charList = Arrays.asList('a','b','c','d','f','g','h','x','y','z');
		Collections.shuffle(charList);
		StringBuilder builder = new StringBuilder(5);
		for(int i=0; i<6; i++) 
			builder.append(charList.get(i));
		return builder.toString();
	}
	
}
