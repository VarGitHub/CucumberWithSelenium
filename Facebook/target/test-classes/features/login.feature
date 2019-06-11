Feature: Login to Facebook
  This feature logs in to facebook

#  Scenario Outline: Login with invalid credentials
#    Given user navigates to the login page
#    And user enters an invalid "<UserName>" and an invalid "<Password>"
#    When user clicks on login button
#    Then user should see an error message
#
#    Examples:
#      | UserName | Password    |
#      | usus@q.tst   | fakepass123 |
#      | lololq@ass.as  | pwdpwd      |

  Scenario: Login with invalid credentials
    Given user navigates to the login page
    And user enters an invalid email and an invalid password
      | emailId       | password |
      | userfake@tst.com | testpwd666  |
    When user clicks on login button
    Then user should see an error message

