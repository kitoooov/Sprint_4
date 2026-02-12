package ru.practikum;

import PageObject.PageOrder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

@RunWith(Parameterized.class)
public class OrderTests {

    private WebDriver driver;

    private final String name;
    private final String lastName;
    private final String address;
    private final String metro;
    private final String phone;
    private PageOrder page;

    public OrderTests(String name, String lastName, String address, String metro, String phone){
    this.name = name;
    this.lastName = lastName;
    this.address = address;
    this.metro = metro;
    this.phone = phone;
}
@Parameterized.Parameters
public static Object[][] getSuccessfulOrder(){
    return  new Object[][] {
                {"Иван", "Иванов", "Пушкина 1", "Черкизовская", "90000000001"},
                {"Пётр", "Петров", "Лермонтова 2", "Сокольники", "90000000002"} // Тестовые данные

    };
}


    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Поставии задержку
    }

    @Test
    public void orderFromTopButtonTest() {
        driver.get("https://qa-scooter.praktikum-services.ru");

        page = new PageOrder(driver);

        page.clickTopOrderButton();
        page.clickNameField();
        page.setNameField(name);
        page.clickLastNameField();
        page.setLastNameField(lastName);
        page.clickAddressField();
        page.setAddressField(address);
        page.clickMetroField();
        page.setMetroField(metro);
        page.clickMetroOption();
        page.clickPhoneField();
        page.setPhoneField(phone);
        page.clickNextButton();

        page.clickDate();
        page.clickChoseDate();
        page.clickLease();
        page.clickDropDownMenu();
        page.clickColour();
        page.clickFinishOrderButton();
        page.clickYesButton();
        String successText = page.getSuccessText();
        Assert.assertTrue("Заказ не получиось оформить",
                successText.contains("Заказ оформлен"));
        page.clickSeeTheStatus();
    }

    @Test

    public void orderFromMiddleButtonTest() {
        driver.get("https://qa-scooter.praktikum-services.ru");

        page = new PageOrder(driver);

        page.ScrollToMiddleButtonAndClick();
        page.clickNameField();
        page.setNameField(name);
        page.clickLastNameField();
        page.setLastNameField(lastName);
        page.clickAddressField();
        page.setAddressField(address);
        page.clickMetroField();
        page.setMetroField(metro);
        page.clickMetroOption();
        page.clickPhoneField();
        page.setPhoneField(phone);
        page.clickNextButton();

        page.clickDate();
        page.clickChoseDate();
        page.clickLease();
        page.clickDropDownMenu();
        page.clickColour();
        page.clickFinishOrderButton();
        page.clickYesButton();
        String successText = page.getSuccessText();
        Assert.assertTrue("Заказ не получиось оформить",
                successText.contains("Заказ оформлен"));
        page.clickSeeTheStatus();
    }


    @After
    public void quit() {
        driver.quit(); // закрыли браузер
    }

}
