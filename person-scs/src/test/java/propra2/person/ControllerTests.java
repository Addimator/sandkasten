package propra2.person;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;
import propra2.person.model.Person;
import propra2.person.web.PersonScsController;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTests {

    @Autowired
    private TestRestTemplate webClient;
    @LocalServerPort
    private int port;
    @Autowired
    private PersonScsController controller;

    @Test
    public void contextLoads() throws Exception {
        Assertions.assertThat(controller).isNotNull();
    }

    @Test
    public void endToEnd() {
        HttpEntity<Person> request = new HttpEntity<>(new Person("Jens Bendisposto", 100000, "jens@hhu.de"));
        webClient.postForLocation("http://localhost:" + port + "/personErstellen", request);
        request = new HttpEntity<>(new Person("Christian Meter", 90000, "christian@hhu.de"));
        webClient.postForLocation("/personErstellen", request);
        //In dieser Zeile ist irgendwo der Fehler
        Person[] personen = webClient.getForObject("/", Person[].class);

        Assertions.assertThat(personen[0].getName()).isEqualTo("Jens Bendisposto");
        Assertions.assertThat(personen[1].getName()).isEqualTo("Christian Meter");
    }
}
