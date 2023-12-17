import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import jdk.jfr.Description;
import org.example.elementsLocation.ElementsForThreeScripts;
import org.example.steps.AssertForTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

public class HerokuTestForThreeScripst {

    @BeforeEach
    public void openHeroku() {

        Configuration.baseUrl= "https://the-internet.herokuapp.com/";
    }

    @Test
    @DisplayName("Проверка кнопки JS Alert")
    @Description("Первый скрипт")
    public void firstScript(){

        open("frames");
        ElementsForThreeScripts.firstScriptIframe.shouldBe(visible).click();
        switchTo().frame(ElementsForThreeScripts.frameSwitch);

        ElementsForThreeScripts.firstScriptTextField.shouldBe(interactable).clear();
        ElementsForThreeScripts.firstScriptTextField.sendKeys("Hello World");

        switchTo().defaultContent();
        ElementsForThreeScripts.firstScriptBoldText.shouldBe(interactable).click();
    }

    @Test
    @DisplayName("Проверка кнопки JS Confirm")
    @Description("Второй скрипт")
    public void secondScript(){

        open("windows");
        ElementsForThreeScripts.secondScriptNewWindow.shouldBe(visible).click();

        switchTo().window(1);
        AssertForTests.textEquals("New Window",Selenide.title());

        switchTo().window(0);
        AssertForTests.textEquals("The Internet",Selenide.title());
    }

    @Test
    @DisplayName("Проверка кнопки JS Prompt")
    @Description("Третий скрипт")
    public void thirdScript(){

        open("javascript_alerts");
        ElementsForThreeScripts.thirdScriptjsAlert.shouldBe(interactable).click();
        AssertForTests.textEquals("I am a JS Alert",switchTo().alert().getText());
        switchTo().alert().accept();
        AssertForTests.textEquals("You successfully clicked an alert", ElementsForThreeScripts.thirdScriptAlertResult.shouldBe(visible).getText());

        ElementsForThreeScripts.thirdScriptjsConfirm.shouldBe(interactable).click();
        switchTo().alert().dismiss();
        AssertForTests.textEquals("You clicked: Cancel", ElementsForThreeScripts.thirdScriptAlertResult.shouldBe(visible).getText());

        ElementsForThreeScripts.thirdScriptjsPrompt.shouldBe(interactable).click();
        switchTo().alert().sendKeys("Hello World");
        switchTo().alert().accept();
        AssertForTests.textEquals("You entered: Hello World", ElementsForThreeScripts.thirdScriptAlertResult.shouldBe(visible).getText());
    }
}
