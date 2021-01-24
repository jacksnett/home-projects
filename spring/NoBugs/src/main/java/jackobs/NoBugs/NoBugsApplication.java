package jackobs.NoBugs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class NoBugsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoBugsApplication.class, args);
	}

}
