@amazon
#@amazon -->> if we put it here it will be apllied for both of them.
Feature: Amazon title


  Scenario: Amazon verification scenario
   When user goes to amazon application
   Then user should see proper title


    Scenario: Amazon url verification
      When user goes to amazon application
      Then user should validate url
