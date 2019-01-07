package propra2.person;

import java.util.HashSet;
import java.util.Set;

public class SkillsetBuilder {

    private Set<Skill> skills = new HashSet<>();

    public SkillsetBuilder withSkill(Skill skill) {
        skills.add(skill);

        return this;
    }

    public Skillset build() {
        return new Skillset(skills);
    }
}
