//package propra2.person.dataaccess;
//
//import propra2.person.Skillset;
//import propra2.person.model.Person;
//
//public class PersonBuilder {
//    private String name;
//    private Integer jahreslohn;
//    private String kontaktdaten;
//    private Skillset skills;
//
//    public PersonBuilder withName(String name) {
//        this.name = name;
//
//        return this;
//    }
//
//    public PersonBuilder withSalary(int salary) {
//        this.jahreslohn = salary;
//
//        return this;
//    }
//
//    public PersonBuilder withContact(String mail) {
//        this.kontaktdaten = mail;
//
//        return this;
//    }
//
//    public PersonBuilder withSkillset(Skillset skillset) {
//        this.skills = skillset;
//
//        return this;
//    }
//
//    public Person build() {
//        return new Person(name, jahreslohn, kontaktdaten, skills);
//    }
//}
