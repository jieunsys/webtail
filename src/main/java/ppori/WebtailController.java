package ppori;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class WebtailController {

	@GetMapping(path="/a2")
	public String webtail(Model model) {
		log.info("#### SET webtail.url = " + Environments.getWebSocketUrl());
		model.addAttribute("webtailurl", Environments.getWebSocketUrl());
		return "webtail";
	}
	
}
