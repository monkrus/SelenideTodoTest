package TodoTests;

import org.junit.Test;
import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;
public class Todo {
    @Test
    public void Test() {
        //Configuration.browser = "chrome";
//        open("https://todomvc4tasj.herokuapp.com/");
//        $("#new-todo").setValue("do something").waitUntil(visible, 5000).pressEnter();
//        $("#new-todo").setValue("do something else").waitUntil(visible, 5000).pressEnter();
//        $$(".view>label").shouldHave(exactTexts("do something", "do something else"));
//        $("#toggle-all").click();
//        $("#clear-completed").click();
//        // URL из Google док и задание от туда https://docs.google.com/document/d/1yvUML7eXyEyDh5asUIL7M88RStlE1RZmgUOJZSXjMVo
//// работает до момента click - немогу подобрать локатор - "Задача 3"
        open("https://todomvc4tasj.herokuapp.com/");
        $("#new-todo").setValue("task1").pressEnter();
        $("#new-todo").setValue("task2").pressEnter();
        $("#new-todo").setValue("task3").pressEnter();
        $("#new-todo").setValue("task4").pressEnter();
        $$(".view>label").shouldHave(exactTexts("task1", "task2", "task3", "task4"));
        $("#todo-list li:nth-child(3) div").hover().click();
    }
}