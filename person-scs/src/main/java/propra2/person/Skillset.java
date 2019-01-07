package propra2.person;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
public class Skillset {

    private Set<Skill> skills;

    public Skillset(Set<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Teststring";
    }
}
