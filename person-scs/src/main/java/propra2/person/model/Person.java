package propra2.person.model;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Integer jahreslohn;
    private String kontaktdaten;
    @ElementCollection
    private List<String> skills;


    public Person() {
    }
    public Person(Long id, String name, Integer jahreslohn, String kontaktdaten) {
        this.id = id;
        this.name = name;
        this.jahreslohn = jahreslohn;
        this.kontaktdaten = kontaktdaten;
    }

    public Person(String name, Integer jahreslohn, String kontaktdaten) {
        this.name = name;
        this.jahreslohn = jahreslohn;
        this.kontaktdaten = kontaktdaten;
    }

    public void setSkills(String skills) {
        this.skills = new ArrayList(Arrays.asList(skills.split(",")));
    }

    public String getProjektId() {
        return "";
    }


}