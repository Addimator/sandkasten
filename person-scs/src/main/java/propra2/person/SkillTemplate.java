package propra2.person;

public class SkillTemplate {

    public static final Skillset Entwickler = new SkillsetBuilder()
            .withSkill(new Skill("Java"))
            .withSkill(new Skill("Spring Boot"))
            .withSkill(new Skill("Maven"))
            .withSkill(new Skill("PHP"))
            .build();

    public static final Skillset Architekt = new SkillsetBuilder()
            .withSkill(new Skill("Arc42"))
            .withSkill(new Skill("AsciiDoc"))
            .withSkill(new Skill("Java"))
            .build();

    public static final Skillset Designer = new SkillsetBuilder()
            .withSkill(new Skill("CSS"))
            .withSkill(new Skill("Thymeleaf"))
            .withSkill(new Skill("HTML"))
            .build();
}
