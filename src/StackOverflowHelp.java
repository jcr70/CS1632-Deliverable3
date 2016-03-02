import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.junit.Assert.*;

/**
 * As a user,
 * I want to view the help page
 * So I can learn how to use StackOverflow
 */

public class StackOverflowHelp {
    static WebDriver driver = new HtmlUnitDriver();


    @Test
    public void TestGoToHelpPage(){
        driver.get("https://stackoverflow.com/");
        String expected = "Help Center - Stack Overflow";
        assertNotEquals(expected, driver.getTitle()); //Right now we are at the home page

        driver.findElement(By.xpath("//*[@id=\"footer-menu\"]/div[1]/a[3]")).click();
        String observed = driver.getTitle();
        assertEquals(expected, observed);

    }

    /*
    Given that I am on the main page
    When I click on badges
    Then I am taken to the badges page
     */
    @Test
    public void TestGetTitle(){
        driver.get("https://stackoverflow.com/help");

        String expected = "Help Center - Stack Overflow";
        String observed = driver.getTitle();
        assertEquals(expected, observed);
    }

    /*
    Given that I am brand new
    When I click on tour from the help page
    Then I want to be taken to the tour page
     */
    @Test
    public void TestGetTour() {
        driver.get("https://stackoverflow.com/help");

        String expected = "Tour - Stack Overflow";
        assertNotEquals(expected, driver.getTitle());   //This tests that we are not currently on the tour page
        driver.findElement(By.id("tell-me-more")).click();
        String observed = driver.getTitle();
        assertEquals(expected, observed);
    }

    /*
    Given that I am on the help page
    When I click "View More" under the asking category
    Then I want to view more help on asking
     */
    @Test
    public void TestViewAskingQuestions(){
        driver.get("https://stackoverflow.com/help");

        String expected = "Asking - Help Center - Stack Overflow";
        assertNotEquals(expected, driver.getTitle());   //This tests that we are not currently on the asking page page
        driver.findElement(By.xpath("//*[@id=\"help-index\"]/div[4]/div[1]/a")).click();
        String observed = driver.getTitle();
        assertEquals(expected, observed);
    }


    /*
    Given that I am on the help page
    When I click "View More" under the answering category
    Then I want to view more help on answering
     */
    @Test
    public void TestViewAnsweringQuestions(){
        driver.get("https://stackoverflow.com/help");

        String expected = "Answering - Help Center - Stack Overflow";
        assertNotEquals(expected, driver.getTitle());   //This tests that we are not currently on the asking page page
        driver.findElement(By.xpath("//*[@id=\"help-index\"]/div[5]/div[1]/a")).click();
        String observed = driver.getTitle();
        assertEquals(expected, observed);
    }

    /*
    Given that I am on the help page
    When I enter a search query in the search box
    Then I want to see my results
     */
    @Test
    public void TestSearchBox(){
        driver.get("https://stackoverflow.com/help");

        driver.findElement(By.name("q")).sendKeys("reputation");
        driver.findElement(By.xpath("//*[@id=\"bigsearch\"]/table/tbody/tr/td[2]/input")).click();
        String expected = "Help Center Search - Stack Overflow";
        String observed = driver.getTitle();
        assertEquals(expected, observed);
    }

}
