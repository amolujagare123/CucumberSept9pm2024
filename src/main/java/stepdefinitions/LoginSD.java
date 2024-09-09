package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class LoginSD {

/*    @Given ("I am on login page")
    public void loginPage()
    {

    }*/
     WebDriver driver;
    @Given("I am on login page")
    public void i_am_on_login_page() {
        System.out.println("I am on login page");


        driver.get("https://stock.scriptinglogic.in/");

    }


    @When("I enter username and password")
    public void i_enter_username_and_password() {
        System.out.println("I enter username and password");

        driver.findElement(By.id("login-username")).sendKeys("admin");
        driver.findElement(By.id("login-password")).sendKeys("admin");
    }
    @And("I click on login button")
    public void i_click_on_login_button() {
        System.out.println("I click on login button");
        driver.findElement(By.name("submit")).click();
    }
    @Then("I should be redirected to home page")
    public void i_should_be_redirected_to_home_page() {
        System.out.println("I should be redirected to home page");

        String expected = "POSNIC - Dashboard";
        String actual = driver.getTitle();

        System.out.println("actual="+actual);
        System.out.println("expected="+expected);

        Assert.assertEquals("This is not a Dashboard",expected,actual);
    }

    @When("I enter invalid username and password")
    public void iEnterInvalidUsernameAndPassword() {
        driver.findElement(By.id("login-username")).sendKeys("sdsds");
        driver.findElement(By.id("login-password")).sendKeys("sdsds");

    }

    @Then("I should get an error")
    public void iShouldGetAnError() {
        String expected = "POSNIC - Login to Control Panel";
        String actual = driver.getTitle();

        System.out.println("actual="+actual);
        System.out.println("expected="+expected);

        Assert.assertEquals("This is not a Dashboard",expected,actual);
    }

    @When("I enter blank username and password")
    public void iEnterBlankUsernameAndPassword() {
        driver.findElement(By.id("login-username")).sendKeys("");
        driver.findElement(By.id("login-password")).sendKeys("");

    }

    @When("I enter {string} and {string} as username & password")
    public void iEnterAndAsUsernamePassword(String username, String password) {
        driver.findElement(By.id("login-username")).sendKeys(username);
        driver.findElement(By.id("login-password")).sendKeys(password);
    }

    @And("I click on add customer link")
    public void iClickOnAddCustomerLink() {
        driver.findElement(By.linkText("Add Customer")).click();
    }

    @And("I click on submit")
    public void iClickOnSubmit() {
        driver.findElement(By.name("Submit")).click();
    }

   /* @And("I enter below Data")
    public void iEnterBelowData() {


    }*/

    @When("I enter below Data")
    public void i_enter_below_data(DataTable dataTable) {


        List<List<String>> data = dataTable.asLists();

        driver.findElement(By.name("name")).sendKeys(data.get(0).get(0));
        driver.findElement(By.name("address")).sendKeys(data.get(0).get(1));
        driver.findElement(By.name("contact1")).sendKeys(data.get(0).get(2));
        driver.findElement(By.name("contact2")).sendKeys(data.get(0).get(3));


    }

    @And("I enter the Data {} , {} , {} , {}")
    public void iEnterTheData(String name, String address, String contact1, String contact2) {
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.name("address")).sendKeys(address);
        driver.findElement(By.name("contact1")).sendKeys(contact1);
        driver.findElement(By.name("contact2")).sendKeys(contact2);

    }

    @Given("i open browser")
    public void iOpenBrowser() {
        driver = new ChromeDriver();

    }

    @And("I maximize")
    public void iMaximize() {
        driver.manage().window().maximize();
    }
}
