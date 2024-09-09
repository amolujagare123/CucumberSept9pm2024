package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {


    @Before
    public void beforeHook()
    {
        System.out.println("=======> beforeHook");
    }

    @After
    public void afterHook()
    {
        System.out.println("=======> afterHook");
    }

}
