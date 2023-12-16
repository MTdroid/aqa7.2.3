package org.example;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class Elements {

    public static SelenideElement search = $x("//input[@id='searchInput']");
    public static SelenideElement searchButton = $(By.id("applySearchBtn"));
    public static SelenideElement firstElement = $x("//article[@data-nm-id][1]");
    public static SelenideElement bucket = $x("//span[contains(text(), 'Добавить в корзину')]");
    public static SelenideElement goToBucket  = $x("//span[@class='navbar-pc__icon navbar-pc__icon--basket']");
    public static SelenideElement phoneAssert   = $x("//h1[@class='basket-section__header active']");
}
