package ru.yan0kom.quadeq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.yan0kom.quadeq.dto.EvalHistoryDto;
import ru.yan0kom.quadeq.dto.QuadraticEquationCoefficientsDto;
import ru.yan0kom.quadeq.service.QuadraticEquationService;

@Controller
public class QuadraticEquationController {
	@Autowired
	private QuadraticEquationService quadraticEquationService;

	@RequestMapping(method = RequestMethod.HEAD, value = "/")
	@ResponseBody
	public String ping() {
		return "pong";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String root(Model model) {
		model.addAttribute("coeffs", new QuadraticEquationCoefficientsDto(1, 0, 0));
		return "input";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/", consumes = "application/x-www-form-urlencoded")
	public String input(QuadraticEquationCoefficientsDto coeffs, Model model) {
		model.addAttribute("coeffs", coeffs);
		return "input";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/eval", consumes = "application/x-www-form-urlencoded")
	public String eval(QuadraticEquationCoefficientsDto coeffs, Model model) {
		model.addAttribute("quadEq", quadraticEquationService.evaluate(coeffs, true));
		return "result";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/history", produces = "application/json")
	@ResponseBody
	public EvalHistoryDto history() {
		return quadraticEquationService.getEvalHistory(); }
	}
