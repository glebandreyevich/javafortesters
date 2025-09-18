package stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import stqa.mantis.common.CommonFunction;

import java.time.Duration;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class UserRegistrationTests extends TestBase{
    public static Stream<String> randomUserName() {
        return Stream.of(CommonFunction.randomString(10));
    }

    @ParameterizedTest
    @MethodSource("randomUserName")
    void canRegisterUser(String username){
        var email = String.format("%s@localhost",username);
        app.jamesApi().addUser(email,"password");
        app.rest().addUser(username,email);
        var messages = app.mail().receive(email,"password", Duration.ofSeconds(10));
        var text = messages.getFirst().content();
        var pattern  = Pattern.compile("http://\\S*");
        var matcher = pattern.matcher(text);
        var link = "";
        if (matcher.find()){
              link =  text.substring(matcher.start(), matcher.end());
        }
        app.ui().openLink(username,link,"password");
        app.http().login(username,"password");
        Assertions.assertTrue(app.http().isLoggedIn());
    }
}
