package ppori;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestController1 {

	@GetMapping(path="/hello1")
	public String webtail() throws IOException {
		if(File.separator.equals("\\")) {
			PrintWriter pw = new PrintWriter(new FileWriter("c:/tmp/tmp.log", true));
			pw.println("### controller: Hello");
			pw.close();
		}
		return "200 ok";
	}
	
}
