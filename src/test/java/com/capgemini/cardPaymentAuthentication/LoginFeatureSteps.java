package com.capgemini.cardPaymentAuthentication;

import com.capgemini.cardPaymentAuthentication.service.myUserDetailsService;
import com.capgemini.cardPaymentAuthentication.users.CardOpUser;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import jakarta.validation.constraints.AssertTrue;
import org.junit.Assert;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;

public class LoginFeatureSteps {
    myUserDetailsService userService = new myUserDetailsService();
    @Given("the {string} and {string} combination is in the database")
    public void theAndCombinationIsInTheDatabase(String username, String password) {
        CardOpUser cardUser = userService.getUserFromUsername(username);
        Assert.assertNotNull(cardUser.getUserId());
        throw new PendingException();
    }

    @When("I make a POST request with my username and password")
    public void iMakeAPOSTRequestWithMyUsernameAndPassword() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("the application should generate a JWT token with claims that is valid for one hour")
    public void theApplicationShouldGenerateAJWTTokenWithClaimsThatIsValidForOneHour() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("the user name and password combination given is not in the database")
    public void theUserNameAndPasswordCombinationGivenIsNotInTheDatabase() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("the application should return an error informing the user that the credentials are incorrect")
    public void theApplicationShouldReturnAnErrorInformingTheUserThatTheCredentialsAreIncorrect() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


}
