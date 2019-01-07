package propra2.person;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import propra2.person.dataaccess.PersonenRepository;
import propra2.person.model.Person;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.fail;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest

public class PersonControllerTests {

    @Autowired
    MockMvc mvc;

    @MockBean
    PersonenRepository repo;

    @Test
    public void retrieve() throws Exception {
        mvc.perform(get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("person"));
    }

//    @Test
//    public void retrieveList() throws Exception {
//        Mockito.when(repo.findAll()).thenReturn(Arrays.asList(new Person("Jens Bendisposto", 100000, "jens@hhu.de")));
//        mvc.perform(MockMvcRequestBuilders.get("/"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value("Jens Bendisposto"));
//    }
//

    @Test
    public void newTest() throws Exception {
        Person jens = new Person("Jens Bendisposto", 100000, "jens@hhu.de");
        Person christian = new Person("Christian Meter", 90000, "christian@hhu.de");
        Mockito.when(repo.findAll()).thenReturn(Arrays.asList(jens, christian));
        mvc.perform(get("/"))
                .andExpect(MockMvcResultMatchers.model().attribute("personen", hasItem(
                        allOf(hasProperty("name", is("Jens Bendisposto"))))))
                .andExpect(MockMvcResultMatchers.model().attribute("personen", hasItem(
                        allOf(hasProperty("name", is("Jens Bendisposto")))
                )));
    }

    @Test
    public void personHinzufuegen() {
        try {
            Person adrian = new Person();
            Mockito.when(repo.save(adrian)).thenReturn(adrian);
            mvc.perform(MockMvcRequestBuilders.post("/personErstellen")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .param("name", "Adrian Prinz")
                    .param("Jahreslohn", "234235")
                    .param("kontaktdaten", "addi@web.de")
                    .param("Skills", "Hacker, Boss")
                    .requestAttr("adrian", new Person()))
                    .andExpect(MockMvcResultMatchers.view().name("redirect:/"))
                    .andExpect(MockMvcResultMatchers.model().attribute("person", hasProperty("name", is("Adrian Prinz"))));
        } catch (Exception e) {
            // TODO: handle exception
            fail(e.getMessage());
        }
    }

    @Test
    public void personAnzeigen() throws Exception {
        Person christopher = new Person(2L, "Christopher Orlowicz", 100000, "chris@gmx.de");
        // Warum muss man hier nicht .when benutzen?
//         Mockito.when(repo.findById(1L)).thenReturn(christopher);
        mvc.perform(get("/personBearbeiten/{id}", 2L))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/"))
                .andExpect(MockMvcResultMatchers.model().attribute("person", hasProperty("name", is("Christopher Orlowicz"))));
    }

    @Test
    public void personBearbeiten() {
        try {
            Person team = new Person(1L, "Bozz Team", 99999, "boss@web.de");
            Mockito.when(repo.save(team)).thenReturn(team);
            mvc.perform(MockMvcRequestBuilders.post("/personBearbeiten/{id}", 1L)
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .param("name", "Boss Team")
                    .requestAttr("team", new Person()))
                    //    .andExpect(MockMvcResultMatchers.view().name("redirect:/"))
                    .andExpect(MockMvcResultMatchers.model().attribute("person", hasProperty("name", is("Boss Team"))));
        } catch (Exception e) {
            // TODO: handle exception
            fail(e.getMessage());
        }
    }
}
