package stepDefinitions;

import domainPages.PoliticsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utilities.BaseTest;
import utilities.BaseUtilities;

import java.io.IOException;

public class PoliticsPageSteps extends BaseTest {
    PoliticsPage politicsPage = new PoliticsPage();

    @Then("I Should verify POLITICS Icon")
    public void iShouldVerifyPOLITICSIcon() throws IOException {
        politicsPage.verifyPoliticsIcon();
    }

    @Then("I Should verify Premium grid main block")
    public void iShouldVerifyPremiumGridMainBlock() {
        politicsPage.verifyMainBlockCount("//*[@id=\"content\"]/section[2]/div/div/div[1]","article","1");
        BaseUtilities.verifyArticleCount("//*[@id=\"content\"]/section[2]/div/div/div[1]","figure","1");
    }

    @And("I Should verify Premium grid aside block")
    public void iShouldVerifyPremiumGridAsideBlock() {
        politicsPage.verifyAsideBlockCount("//*[@id=\"content\"]/section[2]/div/div/div[2]","article","2");
        BaseUtilities.verifyArticleCount("//*[@id=\"content\"]/section[2]/div/div/div[2]","figure","2");
    }

    @And("I Should verify Premium grid list block")
    public void iShouldVerifyPremiumGridListBlock() {
        BaseUtilities.verifyArticleCount("//*[@id=\"content\"]/section[2]/div/div/div[3]","article","9");
    }

    @Then("I Should verify Comment & Analysis grid")
    public void iShouldVerifyCommentAnalysisGrid() {
        BaseUtilities.verifyArticleCount("//*[@id=\"content\"]/section[4]/div/div[2]/div/div","article","5");
    }

    @Then("I Should verify Scottish politics block")
    public void iShouldVerifyScottishPoliticsBlock() {
        politicsPage.verifyScottishPoliticsText();
        BaseUtilities.verifyArticleCount("//*[@id=\"content\"]/section[5]/div/div[2]/div[1]/div","article","8");
        BaseUtilities.verifyArticleTitle("//*[@id=\"content\"]/section[5]/div/div[2]/div[1]/div","article","SCOTTISH");
    }


    @Then("I Should verify UK politics block")
    public void iShouldVerifyUKPoliticsBlock() {
        politicsPage.verifyUKPoliticsText();
        BaseUtilities.verifyArticleCount("//*[@id=\"content\"]/section[5]/div/div[2]/div[1]/div","article","8");
    }


    @Then("I Should assert Politics papertray block")
    public void iShouldAssertPoliticsPapertrayBlock() {
        politicsPage.verifyAllPoliticsText();
        BaseUtilities.verifyArticleCount("//div[@class='papertray']","article","25");
//      politicsPage.verifyWPCPaperTrayPoliticsCount("/html/body/main/section[6]/div/div[2]/div[1]/div/div/section[1]","a","16");
        BaseUtilities.verifyArticleTitle("//div[@class='papertray']","article", "POLITICS");
    }


}


