import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import jdk.jfr.Description;
import org.example.HerokuElements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class HerokuTestCases {

    @BeforeEach
    public void openHeroku() {
        open("https://the-internet.herokuapp.com/");
        Selenide.sleep(300);
    }

    @Test
    @DisplayName("Появление элемента при нажатии на кнопку AddElement")
    @Description("Ожидание появления элемента")
    public void elementVisible(){

        HerokuElements.addRemoveElementsPage.click();
        HerokuElements.addElement.click();
        HerokuElements.elementAppeared.shouldBe(visible);
    }

    @Test
    @DisplayName("Появление элемента при переходе на страницу Key Presses")
    @Description("Ожидание появления элемента")
    public void elementVisible2(){

        HerokuElements.keyPressesPage.click();
        HerokuElements.inputSymbolsField.shouldBe(visible);
    }

    @Test
    @DisplayName("Исчезновения элемента при нажатии на Delete")
    @Description("Ожидание исчезновения элемента")
    public void elementDisappear(){

        HerokuElements.addRemoveElementsPage.click();
        HerokuElements.addElement.click();
        HerokuElements.elementAppeared.shouldBe(visible).click();
        HerokuElements.elementAppeared.should(disappear);
    }

    @Test
    @DisplayName("Корректность заголовка на главной странице")
    @Description("Ожидание определенного текста")
    public void elementExpectText(){

        HerokuElements.mainPageTitle.shouldHave(text("Welcome to the-internet"));
    }

    @Test
    @DisplayName("Проверка ввода на странице Inputs")
    @Description("Ожидание определенного значения")
    public void elementExpectValueNumbers(){

        HerokuElements.inputsPage.click();
        HerokuElements.inputNumberField.shouldBe(visible).sendKeys("123");
        HerokuElements.inputNumberField.shouldHave(value("123"));
    }

    @Test
    @DisplayName("Проверка ввода на странице Key presses")
    @Description("Ожидание определенного значения")
    public void elementExpectValueSymbols(){

        HerokuElements.keyPressesPage.click();
        HerokuElements.inputSymbolsField.shouldBe(visible).sendKeys("A");
        HerokuElements.inputSymbolsField.shouldHave(value("A"));
    }

    @Test
    @DisplayName("Наличие аттрибута у элемента на странице Infinite scroll")
    @Description("Ожидание атрибута")
    public void elementExpectAttribute(){

        HerokuElements.infiniteScrollPage.click();
        HerokuElements.infiniteAttribute.shouldHave(attribute("class", "large-12 columns"));
    }

    @Test
    @DisplayName("Корректность отобржения имени при наведении на элемент на странице Hovers")
    @Description("Таймауты")
    public void elementTimeouts(){

        HerokuElements.hoversPage.click();
        Configuration.timeout = 5000;
        HerokuElements.firstFigure.hover();
        HerokuElements.firstFigureName.shouldHave(text("name: user1"));
    }

    @Test
    @DisplayName("Корректность отобржения имени при наведении на элемент на странице Hovers")
    @Description("Ожидание со слипом")
    public void elementSleep(){

        HerokuElements.hoversPage.click();
        Selenide.sleep(300);
        HerokuElements.firstFigure.hover();
        HerokuElements.firstFigureName.shouldHave(text("name: user1"));

    }
}
