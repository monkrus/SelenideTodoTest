package TodoTests;

import com.codeborne.selenide.ElementsCollection;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


//DESIGN: End-to-end test style, emulates real user behavior.
public class Todo1 {
    public  void clearCompleted() {
        $("#clear-completed").click();
    }

    public void addTask(String text) {
        $("#new-todo").setValue(text).pressEnter();

    }
    //String[] texts= {"1", "2", "3", "4"};
    public void addTask(String... texts) {
        for (String text : texts) {
            $("#new-todo").setValue(text).pressEnter();
        }


    }

//F8--> step over after setting a brakepoint

    //runs only ONCE
    @BeforeClass
    public static void openTodoMVC() {
        //ALWAYS static
        open("https://todomvc4tasj.herokuapp.com/");
    }

    @Before// before EVERY test
    public void clearData() {
        executeJavaScript("localStorage.clear()");
        //refresh();
        open("https://todomvc4tasj.herokuapp.com/");
        open("https://todomvc4tasj.herokuapp.com/#/active");


    }
    @After
    public void clearData2(){
        executeJavaScript("localStorage.clear()");
    }

    @Test
    public void Test1() {

        ElementsCollection tasks = $$("#todo-list>li");



        //-->original code $("#new-todo").setValue("1").pressEnter();
        addTask("1");
        addTask("2");
        addTask("3");
        addTask("4");
        //addTask("1","2","3","4");
        tasks.shouldHave(exactTexts("1", " 2", "3", "4"));
        //option-->tasks.filter(cssClass("active")).shouldHave(texts("1","2"));


        tasks.find(text("2")).hover().find(".destroy").click();
        //option-->tasks.filter(cssClass("completed").shouldHave(texts("2"))
        tasks.shouldHave(texts("1", "3", "4"));

        tasks.find(text("4")).find(".toggle").click();
        // option-->$("#todo-list>li:nth-child(1)  .toggle").click();
        $("#clear-completed").click();
        tasks.shouldHave(texts("1", "3"));

        $("#toggle-all").click();
        clearCompleted();
        tasks.shouldBe(empty);


    }
//
//        @Test
//        public void testAtActiveFilter() {
//
//            addTask("a");
//            addTask("b");
//            addTask("c");
//            //toggle()
//            $(By.linkText("Active")).click();
//            addTask("active:d");
//
//            //tasks.filter(visible).shouldHave(texts("a", "b", "active:d"));
//            //tasks.shouldHave(texts("a", "b", "c", "active:d"));
}





