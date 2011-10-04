Feature:  The user needs to be able to create different teams so that the scoreboard can show who's playing

    Background:
        Given that I am on the create team page


    Scenario: A user should be able to save certain information about a team
        When I look at the page
        Then I should see the following fields:
        | Field        |
        | teamName     |
        | city         |
        | homeStadium  |

    Scenario: A user should have the ability to save certain information about a team
        Given I have all legit values
        When I save my changes
        Then I should see no validation messages

    Scenario Outline: A user shouldn't be able to save certain values about a team
        Given I have all legit values
        And I set <Field> to <Value>
        When I save my changes
        Then I should see a validation for field <Field> because <Reason>

        Examples:

            |  Field      |   Value     |  Reason   |
            |  teamName   |             |  blank    |
            |  city       |  the longest city ever known that would never actually exist     |  size  |