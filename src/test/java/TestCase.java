
import com.codeborne.selenide.Selenide;
import org.example.Elements;
import org.example.steps.WbSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class TestCase {

    @Test
    @DisplayName("Добавление товара в корзину")
    public void addToCart(){
        open("https://www.wildberries.ru/");
        Selenide.sleep(900);

        Elements.search.shouldBe(enabled).click();
        Elements.search.shouldBe(editable).sendKeys("мобильный телефон");
        Elements.searchButton.shouldBe(visible).click();
        Elements.firstElement.shouldBe(visible).click();
        Elements.bucket.shouldBe(interactable).click();
        Elements.goToBucket.shouldBe(visible).click();

        WbSteps.textEquals(Elements.phoneAssert.getAttribute("data-count"),"1");

    }
}
