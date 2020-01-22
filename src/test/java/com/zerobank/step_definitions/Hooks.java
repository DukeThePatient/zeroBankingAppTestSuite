package com.zerobank.step_definitions;


import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){
        Driver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Driver.get().manage().window().maximize();
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

    }

    @After
    public void tearDown(Scenario scenario){

        //if scenario fails, this will take the screenshot
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }

        Driver.closeDriver();
    }
}
