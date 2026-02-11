package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PageOrder {

    private final WebDriver driver;

    // локаторы первой страницы заказа
    private final By TopOrderButton = By.className("Button_Button__ra12g"); // Верхняя кнопка Заказать
    private final By MiddleOrderButton = By.xpath("//button[contains(@class,'Button_Middle__1CSJM') and text()='Заказать']"); // Нижняя кнопка Заказать
    private final By nameField = By.xpath("//input[@placeholder='* Имя']"); // Поле Имя
    private final By lastNameField = By.xpath("//input[@placeholder='* Фамилия']"); // Поле Фамилия
    private final By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']"); // Поле адреса
    private final By metroField = By.xpath("//input[@placeholder='* Станция метро']"); // Поле метро
    private final By metroOption = By.cssSelector(".select-search__option"); // Список станций
    private final By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']"); // Поле Телефон
    private final By nextButton = By.xpath("//button[text()='Далее']"); // Кнопка Далее
    // локаторы второй страницы заказа
    private final By dateField = By.xpath("//input[@placeholder='* Когда привезти самокат']"); // Поле даты заказа
    private final By choseDateField = By.xpath("//div[@aria-label='Choose воскресенье, 15-е февраля 2026 г.']"); // Выбор даты
    private final By leaseField = By.className("Dropdown-placeholder"); // Поле срока аренды
    private final By dropDownMenu = By.xpath("//div[contains(@class,'Dropdown-option') and text()='двое суток']"); // Выпадающий список срока аренды
    private final By colourField = By.id("black"); // Чекбокс
    private final By FinishOrderButton = By.xpath("//button[contains(@class,'Button_Middle__1CSJM') and text()='Заказать']"); // Кнопка Заказать
    private final By yesButton = By.xpath("//button[contains(@class,'Button_Middle__1CSJM') and text()='Да']"); // Кнопка Да
    private final By orderSuccessModal = By.className("Order_ModalHeader__3FDaJ"); // Окно успешного заказа
    private final By seeTheStatus = By.xpath("//button[contains(@class,'Button_Middle__1CSJM') and text()='Посмотреть статус']"); // Кнопка Посмотреть статус

    public PageOrder(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTopOrderButton() {
        driver.findElement(TopOrderButton).click(); // Кликнули по верхней кнопке Заказать
    }

    public void ScrollToMiddleButtonAndClick () {
        WebElement MiddleOrderButton = driver.findElement(By.xpath("//button[contains(@class,'Button_Middle__1CSJM') and text()='Заказать']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MiddleOrderButton); // Скролл до нижней кнопки Заказать
        MiddleOrderButton.click(); // Кликнули по нижней кнопке Заказать
    }

    public void clickNameField() {
        driver.findElement(nameField).click(); // Клик по полю Имя
    }

    public void setNameField(String name) {
        driver.findElement(nameField).sendKeys(name); // Ввод в поле Имя
    }

    public void clickLastNameField() {
        driver.findElement(lastNameField).click(); // Клик по полю Фамилия
    }

    public void setLastNameField(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName); // Ввод в поле Фамилия
    }

    public void clickAddressField() {
        driver.findElement(addressField).click(); // Клик по полю Адрес
    }

    public void setAddressField(String address) {
        driver.findElement(addressField).sendKeys(address); // Ввод в поле Адрес
    }

    public void clickMetroField() {
        driver.findElement(metroField).click(); // Клик по полю Метро
    }

    public void setMetroField(String metro) {
        driver.findElement(metroField).sendKeys(metro); // Ввод в поле Метро
    }

    public void clickMetroOption() {
        driver.findElements(metroOption).get(0).click(); // Клик по первой станции из выпавшего списка
    }

    public void clickPhoneField() {
        driver.findElement(phoneField).click(); // Клик по полю Телефон
    }

    public void setPhoneField(String phone) {
        driver.findElement(phoneField).sendKeys(phone); // Ввод в поле Телефон
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click(); // Клик по кнопке Далее
    }

    //
    public void clickDate() {
        driver.findElement(dateField).click(); // Клик по полю Дата
    }

    public void clickChoseDate() {
        driver.findElement(choseDateField).click(); // Клик по кнопке в календаре
    }

    public void clickLease() {
        driver.findElement(leaseField).click(); // Клик по полю срока аренды
    }

    public void clickDropDownMenu() {
        driver.findElement(dropDownMenu).click(); // Клик по кнопке из выпавшего списка срока аренды
    }

    public void clickColour() {
        driver.findElement(colourField).click(); // Клик по Чекбоксу с выбором цвета
    }

    public void clickFinishOrderButton() {
        driver.findElement(FinishOrderButton).click(); // Клик по кнопке Заказать
    }

    public void clickYesButton() {
        driver.findElement(yesButton).click(); // Клик по кнопке Да
    }

    public String getSuccessText() {
        return driver.findElement(orderSuccessModal).getText(); // Вернули текст сообщения об успешном оформлении заказа
    }

    public void clickSeeTheStatus() {
        driver.findElement(seeTheStatus).click(); // Клик по кнопке Посмотреть статус
    }
}

