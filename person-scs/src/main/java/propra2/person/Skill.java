package propra2.person;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Skill {
    @Id
    @GeneratedValue
    private Long id;

    private String skill;

    public Skill(String skill) {
        this.skill = skill;
    }
}
