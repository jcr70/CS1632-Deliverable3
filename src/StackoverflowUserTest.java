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
 * I want to navigate any links on stackoverflow,
 * So that I can receive and administer help on computer science-related problems in a streamlined way.
 */
public class StackoverflowUserTest {

    static WebDriver driver = new HtmlUnitDriver();

    @Before
    public void setUp() throws Exception {
        driver.get("https://stackoverflow.com/");
    }

    // Given that I am on the main page
    // When I view the title
    // Then I see that it contains the word "Stack Overflow"
    @Test
    public void testShowsCorrectTitle() {

        String title = driver.getTitle();
        assertTrue(title.contains("Stack Overflow"));
    }

    // Given that I am on the main page
    // When I view the topbar
    // Then I see that it contains "sign up", "log in", "tour", and "help" links
    @Test
    public void testHasCorrectHeaderLinks() {

        try {
            driver.findElement(By.linkText("sign up"));
            driver.findElement(By.linkText("log in"));
            driver.findElement(By.linkText("tour"));
            driver.findElement(By.linkText("help"));
        } catch (NoSuchElementException nseex) {
            fail();
        }
    }

    // Given that I am on the main page
    // When I view the topbar
    // Then I see that it contains a button that links to my recent inbox messages
    @Test
    public void testHasInboxButton() {

        try {
            driver.findElement(By.className("js-inbox-button"));
        } catch (NoSuchElementException nseex) {
            fail();
        }
    }

    // Given that I am on the main page
    // When I click on the "featured" link
    // Then I should be redirected to the "featured questions" page
    @Test
    public void testSeeFeatured() {

        driver.findElement(By.partialLinkText("featured")).click();
        String newPageTitle = driver.getTitle();
        assertTrue(newPageTitle.contains("Featured Questions"));
    }

    // Given that I am on the main page
    // When I click on the "tags" link
    // Then I should be redirected to the "tags" page
    @Test
    public void testSeeTags() {

        driver.findElement(By.linkText("Tags")).click();
        String newPageTitle = driver.getTitle();
        assertTrue(newPageTitle.contains("Tags"));
    }

    // Given that I am on the main page and not logged in
    // When I click on the "Ask Question" link
    // Then I should be redirected to the "Users" page and prompted to log in or sign up
    @Test
    public void testAskQuestionNotLoggedIn() {

        driver.findElement(By.linkText("Ask Question")).click();
        String newPageTitle = driver.getTitle();
        assertTrue(newPageTitle.contains("Log In"));
    }
}
