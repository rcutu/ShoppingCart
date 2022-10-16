package com.shopping;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "com.shopping",
        tags = "@RunDev",
        plugin = {
                "pretty",
                "html:/some-path/"
        }
)

public class TestRunner {

}
