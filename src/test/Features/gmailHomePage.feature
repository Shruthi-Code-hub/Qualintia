Feature: Compose and Send Email
Background: Login to Gmail Account
  Given I am on the Gmail login page
  When I enter valid credentials as "xyzqualintia@gmail.com" and "Abc@123456"
  And I click on the login button
  Then I should be logged in successfully

@test
  Scenario: Open Compose Window
    When user is able to clicks on the Compose button
    Then the compose window should open


  Scenario Outline: compose and send an email
    When user is able to clicks on the Compose button
    And user is able to enters "<toEmailAddress>" in the "To" field
    And user is able to enters subject as "Subject" in the "Subject" field
    And user is able to enters emailBody as "emailBody" in the "Body" field
    And user is able to clicks the "Send" button
    Then email should be sent successfully
    And user should see a confirmation message "Email sent."
    Examples:
      | toEmailAddress                 |
      | xyzqualintia@gmail.com |

  Scenario Outline: Compose email without subject and send
    When user is able to clicks on the Compose button
    And user is able to enters "<toEmailAddress>" in the "To" field
    And user leaves the "Subject" field blank
    And user is able to enters emailBody as "emailBody" in the "Body" field
    And user is able to clicks the "Send" button
    Then user is able to see a warning message "Send this message without a subject or text in the body?"
    When user is able to confirm to send the email without a subject
    Then email should be sent successfully
    And user should see a confirmation message "Email sent."
    Examples:
      | toEmailAddress                 |
      | xyzqualintia@gmail.com |

  Scenario: Compose email without recipient and try to send
    When user is able to clicks on the Compose button
    And the user leaves the "To" field blank
    And user is able to enters subject as "Subject" in the "Subject" field
    And user is able to enters emailBody as "emailBody" in the "Body" field
    And user is able to clicks the "Send" button
    Then user should see an error message "Recipient email address is required."

  Scenario Outline:Error Handling for Invalid Recipient
    When user is able to clicks on the Compose button
    And the user is able to enters invalid <toInvalidEmailAddress> email address
    And user is able to enters subject as "Subject" in the "Subject" field
    And user is able to enters emailBody as "emailBody" in the "Body" field
    And user is able to clicks the "Send" button
    Then user should see an error message as <toInvalidEmailAddress>
    Examples:
      | toInvalidEmailAddress |
      | xyzqualintia@gmail    |

  Scenario Outline:Failed Error Handling for Invalid Recipient
    When user is able to clicks on the Compose button
    And the user is able to enters invalid <toInvalidEmailAddress> email address
    And user is able to enters subject as "Subject" in the "Subject" field
    And user is able to enters emailBody as "emailBody" in the "Body" field
    And user is able to clicks the "Send" button
    Then user should see an Failed error message as <toInvalidEmailAddress>
    Examples:
      | toInvalidEmailAddress |
      | xyzqualintia@gmail    |

