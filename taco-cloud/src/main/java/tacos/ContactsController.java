
package tacos;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contacts")
public class ContactsController {
	
	@GetMapping
	public String getContacts(Model model) {
		model.addAttribute("Address", "Lobnya");
		model.addAttribute("Phone", "+79778300448");
		return "contacts";
	}

}

