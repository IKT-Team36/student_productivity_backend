package mk.ukim.finki.studentproductivityhelperapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableJpaRepositories(basePackages = "mk.ukim.finki.studentproductivityhelperapp.model")
//@EntityScan
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"mk.ukim.finki.studentproductivityhelperapp.repository","mk.ukim.finki.studentproductivityhelperapp.config"})

@SpringBootApplication
public class StudentProductivityHelperAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentProductivityHelperAppApplication.class, args);
	}


}
