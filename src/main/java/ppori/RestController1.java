package ppori;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RestController1 {

	@GetMapping(path="/hello1")
	public String webtail() {
		log.info("hello world");
		return "200 ok";
	}
	
}
