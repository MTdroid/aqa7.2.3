
import com.codeborne.selenide.Selenide;

import org.example.elementsLocation.WbElements;
import org.example.steps.AssertForTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class WBTestCase {

    @Test
    @DisplayName("Добавление товара в корзину")
    public void addToCart(){
        open("https://www.wildberries.ru/");
        Selenide.sleep(900);

        WbElements.search.shouldBe(enabled).click();
        WbElements.search.shouldBe(editable).sendKeys("мобильный телефон");
        WbElements.searchButton.shouldBe(visible).click();
        WbElements.firstElement.shouldBe(visible).click();
        WbElements.bucket.shouldBe(interactable).click();
        WbElements.goToBucket.shouldBe(visible).click();

        AssertForTests.textEquals(WbElements.phoneAssert.getAttribute("data-count"),"1");

    }
}
