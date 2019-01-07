package propra2.person;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import propra2.person.model.Person;

public class PersonTest {

    @Test
    public void createPerson(){
        Person jens = new Person("Jens Bendisposto", 100000, "jens@hhu.de");
        Assertions.assertThat(jens.getName()).isEqualTo("Jens Bendisposto");
    }

}
