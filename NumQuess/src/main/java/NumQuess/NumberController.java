package NumQuess;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import constans.ViewNames;

@Controller
@RequestMapping("/numquess")
public class NumberController {

	final int randomNumber = randomNumber();

	@RequestMapping
	public String greeting(Model model) {
		return ViewNames.WELCOME;
	}

	@RequestMapping(value = "/quess", method = RequestMethod.GET)
	public ModelAndView searchBook(@RequestParam(value = "number", required = false) int number) {
		ModelAndView model = new ModelAndView();
		model.addObject("number", number);
		if (number < randomNumber) {
			model.addObject("message", "Niestety podana liczba jest za mała.");
		} else if (number > randomNumber) {
			model.addObject("message", "Niestety podana liczba jest za duża.");
		} else {
			model.addObject("message", "Brawo! Udało Ci się odgadnąć liczbę!");
		}
		model.setViewName(ViewNames.QUESS);
		return model;

	}

	private int randomNumber() {

		Random generator = new Random();
		int losowaLiczba = generator.nextInt(100);
		return losowaLiczba;

	}

}