package org.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HerokuElements {
    public static SelenideElement addRemoveElementsPage = $x("//a[@href='/add_remove_elements/']");
    public static SelenideElement addElement   = $x("//button[@onclick=\"addElement()\"]");
    public static SelenideElement elementAppeared = $x("//button[@class='added-manually']");

    public static SelenideElement mainPageTitle = $x("//h1");

    public static SelenideElement inputsPage = $x("//a[@href='/inputs']");
    public static SelenideElement inputNumberField = $x("//input[@type='number']");
    public static SelenideElement infiniteScrollPage = $x("//a[@href='/infinite_scroll']");
    public static SelenideElement infiniteAttribute = $x("//div[@id='content']");

    public static SelenideElement hoversPage = $x("//a[@href='/hovers']");
    public static SelenideElement firstFigure = $x("//div[@class='figure'][1]");
    public static SelenideElement firstFigureName = $x("//div[@class='figure'][1]//h5");

    public static SelenideElement keyPressesPage = $x("//a[@href='/key_presses']");
    public static SelenideElement inputSymbolsField = $x("//input[@id='target']");
}
