package org.example.elementsLocation;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.*;

public class ElementsForThreeScripts {

    public static SelenideElement firstScriptIframe = $x("//a[@href='/iframe']");
    public static SelenideElement firstScriptTextField = $x("//body[@id='tinymce']");
    public static SelenideElement firstScriptBoldText = $x("//button[@aria-label='Bold']");
    public static String frameSwitch = "mce_0_ifr";

    public static SelenideElement secondScriptNewWindow = $x("//a[@href='/windows/new']");

    public static SelenideElement thirdScriptjsAlert = $x("//button[@onclick='jsAlert()']");
    public static SelenideElement thirdScriptjsConfirm = $x("//button[@onclick='jsConfirm()']");
    public static SelenideElement thirdScriptjsPrompt = $x("//button[@onclick='jsPrompt()']");
    public static SelenideElement thirdScriptAlertResult = $x("//p[@id='result']");




}
