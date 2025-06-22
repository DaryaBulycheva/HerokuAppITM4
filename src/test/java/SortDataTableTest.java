import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SortDataTableTest {
    @Test
    public void sortDataTable() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/tables");
        //Проверяю lastName
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[2]/td[1]"));
        softAssert.assertEquals(lastName.getText(), "Bach");
        //Проверяю firstName
        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[3]/td[2]"));
        softAssert.assertEquals(firstName.getText(), "Jason");
        //Проверяю email
        WebElement email = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[3]/td[3]"));
        softAssert.assertEquals(email.getText(), "jdoe@hotmail.com");
        //Проверяю due
        WebElement due = driver.findElement(By.xpath("//*[@id=\"table2\"]/tbody/tr[2]/td[4]"));
        softAssert.assertEquals(due.getText(), "$51.00");
        //Проверяю webSite
        WebElement webSite = driver.findElement(By.xpath("//*[@id=\"table2\"]/tbody/tr[3]/td[5]"));
        softAssert.assertEquals(webSite.getText(), "http://www.jdoe.com");
        driver.quit();
        softAssert.assertAll();
    }
}
