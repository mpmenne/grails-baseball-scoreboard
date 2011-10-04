package com.github.grailsbaseballscoreboard;

import cuke4duke.annotation.I18n;
import cuke4duke.annotation.Pending;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.StringContains.containsString;

import java.lang.reflect.InvocationTargetException;

public class Scoreboard_CT {

    private final WebDriver d;

    public Scoreboard_CT(WebDriverFacade facade) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        d = facade.getWebDriver();
    }

//    @I18n.EN.Given("^I am checking out the score for the \"([^\"]*)\" vs \"([^\"]*)\"$")
//    public void iAmCheckingOutTheScoreForTheCardsVsCubs_(String homeTeamName, String awayTeamName) {
//        d.get("http://localhost:8080/grails-baseball-scoreboard/scoreboard/show?homeTeamName=" + homeTeamName + "&awayTeamName="+ awayTeamName);
//    }
//
//    @I18n.EN.When("^I look at the scoreboard$")
//    public void iLookAtTheScoreboard() {
//        //nada -- don't don anything
//    }
//
//    @I18n.EN.Then("^I should see that it has the message \"([^\"]*)\"$")
//    public void iShouldSeeThatItHasTheMessageScoreboardBroughtToYouByBudweiser_(String message) {
//        assertThat(d.getPageSource(), containsString("Scoreboard brought to you by Budweiser"));
//    }

    @I18n.EN.Then("^the \"([^\"]*)\" should bat first$")
    public void theBlankShouldBatFirst(String team) {
        assertEquals("Cubs", d.findElement(By.xpath("//div[@name='top']/child::h3[1]")).getText());
    }

    @I18n.EN.Then("^I should see inning \"([^\"]*)\"$")
    @Pending
    public void iShouldSeeInningX(String inningNumber) {
        assertThat(d.findElement(By.name("inning9-label")).getText(), containsString(inningNumber));
    }

//    public static void main(String[] varArgs) throws InvocationTargetException, IllegalAccessException, InstantiationException {
//        Scoreboard_CT scoreboard = new Scoreboard_CT(new WebDriverFacade());
//        scoreboard.iAmCheckingOutTheScoreForTheCardsVsCubs_("Cardinals", "Cubs");
//        scoreboard.iLookAtTheScoreboard();
//        scoreboard.theBlankShouldBatFirst("Cubs");
//    }
}
