package springRest;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springRest.model.Person;


public class PersonController {
	
	@GET
	@Path("listofbook")
	@Produces("application/xml")	
	//@RequestMapping(value = "/person", method = RequestMethod.GET)
	public List<Person> getPerson(@RequestParam("id") int id) {
		List<Person> pe = Arrays.asList(
				new Person(1,"Dhiraj","Kumar"),
				new Person(2,"Neeraj","Kumar")
				);		
		return Arrays.asList(pe.get(id-1));
	}

}
