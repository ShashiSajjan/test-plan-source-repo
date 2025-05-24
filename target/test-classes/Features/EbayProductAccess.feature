#Feature: Accessing a Product via Category and Search
#
#  @web
#  Scenario Outline: Access a product after applying multiple filters
#    Given User lauches Ebay application
#    When User Clicks on "Shop by category" dropdown
#    And Select "Cell phones & accessories" under "Electronics" category
#    And User clicks on "Cell Phones & Smartphones" in the left-hand navigation section
#   And User clicks on "All Filters"
#    #And User applies the Filter Type with Filter Value
#      #| Filter Type   | Filter Value |
#      #| Condition     | New          |
#      #| Price a        | $200-$400    |
#      #| Item Location | US Only      |
#    #Then Verify that user should see <Filter Tags> are applied
#    Examples:
#      | Filter Tags                                         |
#      | Condition:New;Price:$200-$400;Item Location:US Only |
#
#  @web
#  Scenario: Access a Product via Search
#    Given User lauches Ebay application
#    When User enter "MacBook" in the search bar
#    And User change Search category to "Computers/Tablets & Networking" and click "Search"
#    #Then verify that the page loads completely
#    #And verify that the first result name matches "MacBook"
#     |
