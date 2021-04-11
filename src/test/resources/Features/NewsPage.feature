Feature: NewsPage Validation

  Background:
    Given I launch TheCourier Login CTA Url
    And I accept the policy

  Scenario:01_Verify News ICON
    When I click on NEWS from menu
    Then I Should verify NEWS Icon

  Scenario:02_Verify Ad block
    When I click on NEWS from menu
    Then I Should verify Ad blocks

  Scenario:03_Verify Submenu List
    When I click on NEWS from menu
    Then I Should verify Submenu list

  Scenario:04_Verify Post Block List
    When I click on NEWS from menu
    Then I Should verify PostBlock list

  Scenario:05_Verify Timeline Block
    When I click on NEWS from menu
    Then I Should assert timeline block

  Scenario:06_Verify Photo&Video Block
    When I click on NEWS from menu
    Then I Should assert Photo&Video block

  Scenario:07_Verify Papertray Block
    When I click on NEWS from menu
    Then I Should assert Papertray block

  @ignore
  Scenario Outline:08_Verify Submenu Navigation
    When I click on NEWS from menu
    Then I Should verify "<subMenu>" Navigation
    Examples:
    |    subMenu       |
    |CORONAVIRUS       |
    |Dundee            |
    |Angus & The Mearns|
    |Perth & Kinross   |
    |Fife              |
    |Send us a story   |
    |Supplements       |
    |Home delivery     |

  Scenario:09_Verify Submenu Navigation
    When I click on NEWS from menu
    Then I minimize the page and take pic of first half
  And I scroll down the page and take pic of second half
