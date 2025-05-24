Feature: Plansource Platform

  @web
  Scenario : Create Employee and Benifits
    Given Login to Plansource Portal
    And Click on Add New Employee
    When Create Employee with following basic and Contact data:
    |first_name|Teet|
    |last_name |USER|
    |password  |sjheiufd24|
    |ssn_text  |343434343 |
    |address_1 | 202 hartnell|
    |city      |      town     |
    |stateTypeahead|      mexico   |
    |zip_code      | 58930        |
    |countryTypeahead| Uganda        |
    |birthdate|          05/12/1998         |
    |gender   | Male                        |
    |marital_status| Married                |
    |hire_date     | 05/05/2025             |
   |benefits_start_date| 05/05/2025        |
    |employment_level   |P                  |
    |location           |SCA                |
    |current_salary     | 20000             |
    |benefit_salary     | 10000             |
    And User clicks on "New Hire Enrollment"
    And User clicks on "Get Started"
    And User click on Review My Family to fill depeendent details
    Then User click on Add Family Member button
    And Enter the dependents basic information with following data:
      |first_name|ter|
      |last_name |trtrsst|
      |gender    |    Male   |
      |birthdate |  05/12/2001  |
      |relationship       |    Child             |
    And User click on Medical Shops Plan and Available Plan
    Then Enroll Employee into Dental Benefits via API
    And Click on Admin and Proceed To Checkout
