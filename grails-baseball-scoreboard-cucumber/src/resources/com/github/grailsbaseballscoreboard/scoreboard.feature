Feature:  The scoreboard is the main piece of the application.
It will let the user know what the score of the game is.

    @Scoreboard
    Scenario: We should give sponsors some recognition
        Given I am checking out the score for the "Cardinals" vs "Cubs"
        When I look at the scoreboard
        Then I should see that it has the message "Scoreboard brought to you by Budweiser"

    @Scoreboard
    Scenario: The home team should have the advantage
        Given I am checking out the score for the "Cardinals" vs "Cubs"
        When I look at the scoreboard
        Then the "Cubs" should bat first

    @Scoreboard
    Scenario: Each inning played should have a score
        Given I am checking out the score for the "Cardinals" vs "Cubs"
        And the "Cardinals" scored "1" run(s) in the inning "1"
        Then inning "1" should show "1" run(s) for the "Cardinals"
        And inning "1" should show "0" runs(s) for the "Cubs"

