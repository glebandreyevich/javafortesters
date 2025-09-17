package stqa.mantis.tests;

import org.junit.jupiter.api.Test;
import stqa.mantis.common.CommonFunction;

public class JamesTests extends TestBase {
    @Test
    void canCreateUser(){
        app.jamescli().addUser(String.format("%s@localhost", CommonFunction.randomString(8)),"password");

    }
}
