# SM Test Framework

## Description
This is a basic example of a UI test framework using Scala, SBT, Cucumber, Selenium & ScalaTest.
    
## Requirements
* [sbt 1.1.1](http://www.scala-sbt.org)
* [scala 2.12.4](https://www.scala-lang.org/)
* [selenium 3.9.1](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.9.1)
* [chrome 64.0.3282.140](https://www.google.co.uk/chrome/browser/features.html) (Tested using this version, but any 
version compatible with Selenium `3.9.1` will suffice)
    
     
## Usage

The following will run all gherkin features/scenarios tagged with `@ui`. The terminal output will be colourful and the
results will be presented in 3 formats: `html`, `json` & `xml`
    
    sbt compile 'run --tags @ui --plugin pretty --plugin junit:junitresults/junit_outcome.xml --plugin json:jsonresults/json_outcome.json --plugin html:htmlresults/ --glue com.stevenm classpath:feature'

