package stqa.mantis.tests;

import org.junit.jupiter.api.Test;
import stqa.mantis.common.CommonFunction;
import stqa.mantis.model.IssueData;

public class IssueCreationTests extends TestBase{

    @Test
    void canCreateIssue() {
        app.rest().createIssue(new IssueData()
                .withSummary(CommonFunction.randomString(10))
                .withDescription(CommonFunction.randomString(50))
                .withProject(1L));
    }
}