package propra2.person.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Person nicht gefunden")
public class PersonNichtVorhanden extends RuntimeException {

}
