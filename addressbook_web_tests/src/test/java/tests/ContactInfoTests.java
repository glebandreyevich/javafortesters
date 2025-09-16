package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase {
    @Test
    void testPhones(){
        var contact = app.hbm().getContactList();
        var coontact = contact.get(0);
        var phones = app.contact().getPhones(coontact);
        var expected = Stream.of(coontact.home(), coontact.mobile(), coontact.work(), coontact.phone2())
                .filter(s->s != null && ! "".equals(s))
                .collect(Collectors.joining("\n"));
        Assertions.assertEquals(expected, phones);


    }
}
