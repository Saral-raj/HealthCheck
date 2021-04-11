Feature:PoliticsPage Validation

  Background:
    Given I launch TheCourier Login CTA Url
    And I accept the policy

  Scenario:01_Verify Politics ICON
    When I click on POLITICS from menu
    Then I Should verify POLITICS Icon

  Scenario:02_Verify Politics Premium Grid
    When I click on POLITICS from menu
    Then I Should verify Premium grid main block
    And I Should verify Premium grid aside block
    And I Should verify Premium grid list block

  Scenario:03_Verify Comment & Analysis Grid
    When I click on POLITICS from menu
    Then I Should verify Comment & Analysis grid

  Scenario:04_Verify Scottish politics
    When I click on POLITICS from menu
    Then I Should verify Scottish politics block

  Scenario:05_Verify UK politics
    When I click on POLITICS from menu
    Then I Should verify UK politics block

  Scenario:06_Verify All politics
    When I click on POLITICS from menu
    And I Should assert Politics papertray block

  Scenario:07_Verify Submenu Navigation
    When I click on POLITICS from menu
    Then I minimize the page and take pic of first half
    And I scroll down the page and take pic of second half



