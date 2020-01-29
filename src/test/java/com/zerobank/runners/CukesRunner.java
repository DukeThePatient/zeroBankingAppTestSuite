package com.zerobank.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-cucumber-reports"
        },
        glue = "com/zerobank/step_definitions",
        features = "src/test/resources/features",
        dryRun = false,
        tags = "@findTransactions"
)

public class CukesRunner { }
