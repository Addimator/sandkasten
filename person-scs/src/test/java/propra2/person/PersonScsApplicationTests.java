package propra2.person;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import propra2.person.dataaccess.PersonenRepository;
import propra2.person.model.Person;

import java.util.List;

import static org.junit.Assert.fail;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)

public class PersonScsApplicationTests {

	@Autowired
	PersonenRepository personenRepo;

	@Test
	public void repoTest_Name() {
		personenRepo.save(new Person("Jens Bendisposto", 100000, "jens@hhu.de"));
		List<Person> personen = personenRepo.findAll();
		Assertions.assertThat(personen.get(0).getName()).isEqualTo("Jens Bendisposto");
	}

	@Test
	public void repoTest_Gehalt() {
		personenRepo.save(new Person("Jens Bendisposto", 100000, "jens@hhu.de"));
		List<Person> personen = personenRepo.findAll();
		Assertions.assertThat(personen.get(0).getJahreslohn()).isEqualTo(100000);
	}

	@Test
	public void repoTest_Kontakt() {
		personenRepo.save(new Person("Jens Bendisposto", 100000, "jens@hhu.de"));
		List<Person> personen = personenRepo.findAll();
		Assertions.assertThat(personen.get(0).getKontaktdaten()).isEqualTo("jens@hhu.de");
	}

}

