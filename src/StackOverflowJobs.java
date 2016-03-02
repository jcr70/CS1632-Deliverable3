import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.*;

/**
 * As a user,
 * I want to search the jobs page
 * To find a job that fits me best
 */

public class StackOverflowJobs {
    static WebDriver driver = new HtmlUnitDriver();

    @Before
    public void setUp() throws Exception{
        driver.get("https://stackoverflow.com/");
    }

    /*
    Given that I am on the main page
    When I click on jobs
    Then I am taken to the jobs page
     */
    @Test
    public void TestGetJobsPage(){
        String expected = "Job Listings - Stack Overflow";
        assertNotEquals(expected, driver.getTitle());   //Before we click on jobs
        driver.findElement(By.linkText("Jobs")).click();
        String observed = driver.getTitle();    //After we click on jobs, check if it has updated
        assertEquals(expected, observed);


    }


    /*
    Given that I am on the jobs page
    When I look at the title
    Then I see that it contains "Job Listings"
     */
    @Test
    public void TestGetTitleOfJobsPage(){
        driver.get("https://stackoverflow.com/jobs");
        String expectedTitle = "Job Listings - Stack Overflow";
        String observedTitle = driver.getTitle();
        assertEquals(expectedTitle, observedTitle);
    }

    /*
    Given that I am on the jobs page
    When I click "Search Companies"
    Then the tab switches to search companies
     */
    @Test
    public void TestClickSearchCompanies(){
        driver.get("https://stackoverflow.com/jobs");
        String expected = "Companies - Stack Overflow";
        driver.findElement(By.linkText("search companies")).click();
        String observed = driver.getTitle();
        assertEquals(expected, observed);
    }

    /*
    Given that I am on the search company tab of the jobs page
    When I click "search jobs"
    Then the tab switches to search jobs
     */
    @Test
    public void TestClickSearchJobs(){
        driver.get("http://stackoverflow.com/jobs/companies");
        String expected = "Job Listings - Stack Overflow";
        driver.findElement(By.linkText("search jobs")).click();
        String observed = driver.getTitle();
        assertEquals(expected, observed);
    }

}
