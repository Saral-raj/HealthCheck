Feature: LoginPage Validation

  Scenario: Verify Successful logging in
    Given I launch TheCourier Login CTA Url
    When I accept the policy
    Then I provide login details
    And I Should validate Homepage title