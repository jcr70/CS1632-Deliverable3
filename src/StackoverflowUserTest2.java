import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import junit.framework.TestCase;

import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * As a user,
 * I want to search for certain topics,
 * So that I can find questions relevant to my skills and interests.
 */
public class StackoverflowUserTest2 {

    static WebDriver driver = new HtmlUnitDriver();

    @Before
    public void setUp() throws Exception {
        driver.get("https://stackoverflow.com/");
    }

    // Given that I am on the main page
    // When I view the topbar
    // Then I see that it contains a search bar
    @Test
    public void testHasSearchBar() {

        try {
            driver.findElement(By.id("search"));
        } catch (NoSuchElementException nseex) {
            fail();
        }
    }

    // Given that I am on the tags page
    // When I view the main container
    // Then I see that it contains a "find tags" input field
    @Test
    public void testHasTagSearch() {

        driver.findElement(By.linkText("Tags")).click();
        try {
            driver.findElement(By.id("tagfilter"));
        } catch (NoSuchElementException nseex) {
            fail();
        }
    }

    // Given that I am on the tags page
    // When I view the bottom of the page
    // Then I see a "tag synonyms" link
    @Test
    public void testHasTagSynonyms() {

        driver.findElement(By.linkText("Tags")).click();
        try {
            driver.findElement(By.className("tag-synonym-link"));
        } catch (NoSuchElementException nseex) {
            fail();
        }
    }

    // Given that I am on the tags page
    // When I view the bottom of the page
    // Then I see a "next page" button
    @Test
    public void testHasNextPageButton() {

        driver.findElement(By.linkText("Tags")).click();
        try {
            driver.findElement(By.linkText("next"));
        } catch (NoSuchElementException nseex) {
            fail();
        }
    }

}
