//package propra2.person.dataaccess;
//
//import com.github.javafaker.Faker;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.servlet.ServletContextInitializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//import propra2.person.SkillTemplate;
//import propra2.person.model.Person;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import java.util.Locale;
//import java.util.stream.IntStream;
//
//    @Component
//    public class DatabaseInitializer implements ServletContextInitializer {
//
//        @Autowired
//        PersonenRepository personenRepo;
//
//        @Override
//        public void onStartup(ServletContext servletContext) throws ServletException {
//            final Person person = new Person("Max Mustermann", 10000, "max.mustermann@gmail.com", "Entwickler");
//            this.personenRepo.save(person);
////            System.out.println("Populating the database");
////            final Faker faker = new Faker(Locale.GERMAN);
////            IntStream.range(0, 30).forEach(value -> {
////                final Person person = new PersonBuilder()
////                        .withName(faker.name().fullName())
////                        .withSalary(faker.number().numberBetween(50000, 100000))
////                        .withContact(faker.pokemon().name())
////                        //.withSkillset(SkillTemplate.DEVELOPER)
////                        .build();
////                this.personenRepo.save(person);
//            };//);
//        }
//   // }
