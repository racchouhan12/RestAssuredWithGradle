
#  About Project

This is very Basic Rest assured project I used for automating one of the token generation process which requires certificate for approval.
I did not created much classes to give whole framework structure but it has got neccessary Utils classes for get, post request and
JSON and File Utils for extracting data with JSON String and files resp.


## Pre-requisites:

1. Java8 or higher should be installed.2.
2. Set JAVA_HOME
3. Install gradle and set GRADLE_HOME

## Framework structure:

1. It's a is a gradle project.
2. There are Utils classes which in main/java/com/automation/api/utils
3. Test classes lies in test/java/com/automation/api/tests
4. Certificates required to genearte access token are placed in test/resources/Certificates
5. For Password related to certificate I directly wrote in code.
6. For Request body which are long JSONs I have kept in test/resources/RequestJSONs : Here we can extract the section of JSON and pass it on in our request.

 ##  How to run Test:

 1. I have included include and exclude groups tags in build.gradle.
 2. To run specific groups we can manipulate those tags.
 3. Command: To run single class: gradle test --tests com.example.testClass
 4. Command: To run single method: gradle test --tests com.example.testClass.testMethod (include and exclude tags will have higher priority)
 5. Command: To run all method from different classes: gradle test.

 ##  Reports
 1. TestNG report will be generated in ./testngOutput"
 2. Also Gradle provide its reports in $buildDir/reports/tests/test
