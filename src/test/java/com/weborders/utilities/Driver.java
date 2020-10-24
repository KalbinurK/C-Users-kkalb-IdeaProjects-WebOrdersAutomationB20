package com.weborders.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.management.RuntimeErrorException;

public class Driver {

    // reference variable, pointer on obj
    //if reference variable doesn't point on any obj it will have null value
    // whenevre we type new class()- we create new abj
    //reference typ can be class parent class or interface implemanted by class or parent class
    // since we driver is a interface implemented by RemoteWebDriver class
    // and RomoteWebDriver is a parent class of ChromeDriver, firefix, etc.. classes
    //we can specify reference type as a webDriver
    // it helps to define obj type in a run time(polymorphism)
    private static WebDriver driver;

    private Driver(){  // constructor
    }

    public static WebDriver getDriver(){
        if(driver==null){
         String browser ="chrome";
          switch (browser) {
              case "chrome":
                  WebDriverManager.chromedriver().setup();
              driver = new ChromeDriver();
              break;
              case "firefox":
                  WebDriverManager.firefoxdriver().setup();
                  driver= new FirefoxDriver();
                  break;
              default:
                  throw  new RuntimeException("browser is not implemented yet: "+browser);


          }

        }
        return driver;
    }
}
