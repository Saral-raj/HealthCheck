Feature: NewsPage Validation

  Background:
    Given I launch TheCourier Login CTA Url
    When I accept the policy

  Scenario:01_Verify Social Media Icons
    Then I click on Facebook Icon and verify FBpage
    And I click on Twitter Icon and verify twitter page

  Scenario:02_Verify Clearfix,TopMainmenu and submenu
    Then I verify clearfix list
    And  I verify TopMainmenu list
    And I Should verify Submenu list

  Scenario Outline:03_Verify Search Functionality
    And I provide "<keyWord>" in search box
    Then I get the total results and assert the pagination
    And I assert search filters
    And I assert Author filters and assert the pagination
    Examples:
      |      keyWord      |
      | Vaccine roll out  |
#      | scottish elections|






