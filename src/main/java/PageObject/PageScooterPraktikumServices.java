package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageScooterPraktikumServices {

    private WebDriver driver;

    public PageScooterPraktikumServices(WebDriver driver) {
        this.driver = driver;
    }

    public void dropDownListTest(int index) {
        WebElement element = driver.findElement(By.id("accordion__heading-" + index)); // нашли элемент на странице
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); // проскролили страницу до последней стрелки
        element.click(); // кликнули по элементу
    }
    public String getAnswerText(int index){
        return driver.findElement(By.id("accordion__panel-" + index)).getText(); // Вернули текст с ответом
    }

}

