package liquidhacks.rallee.ralleebe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Properties;

@SpringBootApplication
@EnableSwagger2
public class RalleeBeApplication {
	static final String SPRING_PROFILE_PROPERTY = "spring.profiles.active";

	public static void main(String[] args) {

		SpringApplication application = new SpringApplication(RalleeBeApplication.class)  ;

		String tomcatEnv = System.getenv("TOMCATENV");
		// if a TOMCATENV was set, then get it's value and set the appropriate Spring profile
		if(tomcatEnv != null) {
			Properties properties = new Properties();
			switch (tomcatEnv) {
			case "DEV":
				properties.put(SPRING_PROFILE_PROPERTY,"dev");
				break;
			case "INT":
				properties.put(SPRING_PROFILE_PROPERTY,"int");
				break;
			case "PROD":
				properties.put(SPRING_PROFILE_PROPERTY,"prod");
				break;
			}

			application.setDefaultProperties(properties);
		}

		application.run(args);
	}
}