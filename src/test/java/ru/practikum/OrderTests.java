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
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


@RunWith(Parameterized.class)
public class OrderTests {

    private WebDriver driver;

    private final String name;
    private final String lastName;
    private final String address;
    private final String metro;
    private final String phone;
    private String buttonType;
    private PageOrder page;

    public OrderTests(String name, String lastName, String address, String metro, String phone, String buttonType){
    this.name = name;
    this.lastName = lastName;
    this.address = address;
    this.metro = metro;
    this.phone = phone;
    this.buttonType = buttonType;

}
@Parameterized.Parameters
public static Object[][] getData(){
    return  new Object[][] {
            {"Иван","Иванов","Пушкина 1","Черкизовская","90000000001","top"},
            {"Пётр","Петров","Лермонтова 2","Сокольники","90000000002","bottom"}
            // Тестовые данные
    };
}
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Поставии задержку
    }

    @Test
    public void orderFromTopAndMiddleButtonTests() {
        driver.get("https://qa-scooter.praktikum-services.ru");

        page = new PageOrder(driver);

        page.clickOrderButton(buttonType);

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
        page.clickSeeTheStatus();
        String successOrderStatus = page.getStatus();
        Assert.assertTrue("Cтатус заказа не отображен на экране",
                successOrderStatus.contains("Статус заказа отображен на экране"));

    }


    @After
    public void quit() {
        driver.quit(); // закрыли браузер
    }

}
