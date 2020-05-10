package demo;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	@RequestMapping("/")
	public String index(Model model) {
		LocalDateTime today = LocalDateTime.now();
		model.addAttribute("modelYear", today.getYear());
		model.addAttribute("modelMonth", today.getMonthValue());
		model.addAttribute("modelDay", today.getDayOfMonth());
		model.addAttribute("modelWeek", today.getDayOfWeek());

		return "index";
	}

	@RequestMapping("/confirm")
	public String confirm(@ModelAttribute("msg") String arg,Model model) {
		LocalDateTime today = LocalDateTime.now();

		System.out.println("msg:" + arg);

		int i = Integer.parseInt(arg);

		model.addAttribute("year", today.getYear().plusYears(i));


		model.addAttribute("modelYear", today.getYear());
		model.addAttribute("modelMonth", today.getMonthValue());
		model.addAttribute("modelDay", today.getDayOfMonth());
		model.addAttribute("modelWeek", today.getDayOfWeek());
		return "index";
	}
}