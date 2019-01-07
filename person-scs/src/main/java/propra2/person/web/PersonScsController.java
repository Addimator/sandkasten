package propra2.person.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import propra2.person.dataaccess.PersonenRepository;
import propra2.person.model.Person;

import java.util.List;
import java.util.Optional;

@Controller

public class PersonScsController {

    @Autowired
    PersonenRepository personenRepo;

    @GetMapping("/")
    public String person(final Model model) {
        List<Person> personen = personenRepo.findAll();
        model.addAttribute("personen", personen);
        return "person";
    }

    @GetMapping("/personErstellen")
    public String showPersonErstellen() {
        return "personErstellen";
    }

    @PostMapping("/personErstellen")
    public String erstellen(final Person person) {
        personenRepo.save(person);
        return "redirect:http://localhost:8080/person";
    }

    @GetMapping("/personBearbeiten/{id}")
    public String personAnzeigen(final Model model, @PathVariable final Long id) {
        Optional<Person> person = personenRepo.findById(id);

        if (!person.isPresent()) {
            throw new PersonNichtVorhanden();
        }

        model.addAttribute("person", person.get());

        return "personBearbeiten";
    }

    @RequestMapping(value="/personBearbeiten/{id}", method=RequestMethod.POST, params="action=edit")
    public String personBearbeiten(@PathVariable final Long id, final Person person) {
        personenRepo.save(person);
        return "redirect:http://localhost:8080/person";
    }

    @RequestMapping(value="/personBearbeiten/{id}", method=RequestMethod.POST, params="action=delete")
    public String personLoeschen(@PathVariable final Long id, final Person person) {
        personenRepo.delete(person);
        return "redirect:http://localhost:8080/person";
    }



    @GetMapping("/projekt/{id}")
    public String projekt(@PathVariable final String id, final Model model) {

        return "projekt";
    }

}