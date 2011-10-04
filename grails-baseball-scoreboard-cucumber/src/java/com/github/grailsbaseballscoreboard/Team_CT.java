package com.github.grailsbaseballscoreboard;

import cuke4duke.annotation.I18n;
import cuke4duke.annotation.Pending;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class Team_CT {

    private final WebDriver d;

    public Team_CT(WebDriverFacade facade) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        d = facade.getWebDriver();
    }

    @I18n.EN.Given("^that I am on the create team page$")
    public void thatIAmOnTheCreateTeamPage() {
        d.get("http://localhost:8080/grails-baseball-scoreboard/team/create");
    }

    @I18n.EN.When("^I look at the page$")
    public void iLookAtThePage() {
        //NADA
    }

    @I18n.EN.Then("^I should see the following fields:$")
    public void iShouldSeeTheFollowingFieldsWithTable(cuke4duke.Table table) {
        for (List<String> field : table.rows()) {
            d.findElement(By.name(field.get(0)));
        }
    }

    @I18n.EN.Given("^I have all legit values$")
    public void iHaveAllLegitValues() {
        d.findElement(By.name("teamName")).clear();
        d.findElement(By.name("teamName")).sendKeys("Cardinals");
        d.findElement(By.name("homeStadium")).clear();
        d.findElement(By.name("homeStadium")).sendKeys("Busch Stadium");
        d.findElement(By.name("city")).clear();
        d.findElement(By.name("city")).sendKeys("St. Louis");
    }

    @I18n.EN.Given("^I set (.*?) to (.*?)")
    public void iSetTeamNameToCardinals(String field, String value) {
        d.findElement(By.name(field)).clear();
        d.findElement(By.name(field)).sendKeys(value);
    }

    @I18n.EN.When("^I save my changes$")
    public void iSaveMyChanges() {
        d.findElement(By.className("save")).submit();
    }

    @I18n.EN.Then("^I should see that (.*?) is (.*?)$")
    public void iShouldSeeThatFieldIsValue(String field, String value) {
        String savedValue = d.findElement(By.xpath("//span[@id='" + field + "-label" + "']/following-sibling::span[1]")).getText();
        assertEquals(value, savedValue);
    }

    @I18n.EN.Then("^I should see a validation for field (.*?) because (.*?)")
    public void iShouldSeeAValidationForTeamName(String field, String reason) {
        String validation = d.findElement(By.className("errors")).getText();
        assertThat(validation, containsString(field));
        assertThat(validation, containsString(reason));
    }

    @I18n.EN.Then("^I should see no validation messages$")
    public void iShouldSeeNoValidationMessages() {
        boolean noErrors = false;
        try {
            d.findElement(By.className("errors")).getText();
        } catch (Exception e) {
            noErrors = true;
        }
        assertTrue(noErrors);
    }

    public void testSaving() {
        thatIAmOnTheCreateTeamPage();
        iHaveAllLegitValues();
        iSaveMyChanges();
        iShouldSeeNoValidationMessages();
    }

    public static void main(String[] varArgs) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Team_CT team_ct = new Team_CT(new WebDriverFacade());
        team_ct.testSaving();
    }
}
