Feature:SportPage Validation

  Background:
    Given I launch TheCourier Login CTA Url
    And I accept the policy

  Scenario:01_Verify Sport ICON
    When I click on Sport from menu
    Then I Should verify Sport Icon

  Scenario:02_Verify Advertising blocks
    When I click on Sport from menu
    Then I Should verify Advertising blocks

  Scenario:03_Verify Submenu List
    When I click on Sport from menu
    Then I Should verify Sports Submenu list

