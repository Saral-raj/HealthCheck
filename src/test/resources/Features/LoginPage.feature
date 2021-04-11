Feature: LoginPage Validation

  Scenario: Verify Successful logging in
    Given I launch TheCourier Login CTA Url
    When I accept the policy
    Then I click on NEWS from menu
    Then I Should verify NEWS Icon
