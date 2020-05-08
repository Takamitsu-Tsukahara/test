package demo.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.request.RequestData;


@Controller
public class DataContoroller {

	@RequestMapping("/index")
	public String pageIndex(Model model) {
		LocalDateTime today = LocalDateTime.now();
		model.addAttribute("GOGO", today);
		return "index";
	}

	@RequestMapping("/")
	public String pageAdd(Model model) {
		LocalDateTime today = LocalDateTime.now();
		model.addAttribute("modelYear", today.getYear());
		model.addAttribute("modelMonth", today.getMonthValue());
		model.addAttribute("modelDay", today.getDayOfMonth());
		model.addAttribute("modelWeek", today.getDayOfWeek());

		model.addAttribute("Request", new RequestData());

		return "add";
	}

	@RequestMapping("/add{userYear}{userMonth}{userDay}")

	public String pageCreate(@PathVariable ("userYear") Integer Year,@PathVariable("userMonth") Integer Month,@PathVariable ("userDay") Integer Day, Model model) {

		LocalDateTime dayData = LocalDateTime.now().plusYears(Year).plusMonths(Month).plusDays(Day);

		model.addAttribute("modelYear", dayData.getYear());
		model.addAttribute("modelMonth", dayData.getMonthValue());
		model.addAttribute("modelDay", dayData.getDayOfMonth());
		model.addAttribute("modelWeek", dayData.getDayOfWeek());

		model.addAttribute("Request", new RequestData());

		return "redirect:";
	}
}
