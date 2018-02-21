# SM Test Framework

## Description
This is a basic example of a UI test framework using Scala, SBT, Cucumber, Selenium & ScalaTest.
    
## Requirements
* [sbt 1.1.1](http://www.scala-sbt.org)
* [scala 2.12.4](https://www.scala-lang.org/)
* [selenium 3.9.1](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.9.1)
* [chrome 64.0.3282.140](https://www.google.co.uk/chrome/browser/features.html) (Tested using this version, but any
version compatible with Selenium `3.9.1` will suffice)
* chromedriver 2.33.506106 (might need to `brew install chromedriver`)
    
     
## Usage

The following will run the end to end UI tests (all gherkin features/scenarios tagged with `@ui`). The terminal output will be colourful and the
results will be presented in 3 formats: `html`, `json` & `xml`
    
    sbt compile 'run --tags @ui --plugin pretty --plugin junit:junitresults/junit_outcome.xml --plugin json:jsonresults/json_outcome.json --plugin html:htmlresults/ --glue com.stevenm classpath:feature'
    
The following will run the API unit tests:    

    sbt clean compile test
    
## Tech Debt

Due to time constraints, the list below outlines some of the tech debt accumulated:
* Remove reliance on xpaths which make tests very brittle
* Pay more attention to asynchronous loaded elements on page
* Use POM more elaborately (very basic implementation)
* Add wrapper to unpacking of elements, which will handle StaleElementExceptions and remove `.head.underlying`
* Move hardcode password to encrypted password store like kdbx
* move iframe switching to utility method passing in the executable operation a parameter
* Assert more of the returned payload in the API tests