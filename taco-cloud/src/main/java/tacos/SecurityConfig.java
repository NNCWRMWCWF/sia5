package tacos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
//	DataSource dataSource;
	
	@Bean
	public PasswordEncoder encoder() {
		return new StandardPasswordEncoder("53cr3t");
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//in memory authentication
//		auth.inMemoryAuthentication()
//		.withUser("frol")
//		.password("dirol")
//		.authorities("ROLE_USER");
		
		//jdbc-authentication
//		auth.jdbcAuthentication().dataSource(dataSource)
//		.usersByUsernameQuery("select username, password, enabled from Users where username=?")
//		.authoritiesByUsernameQuery("select username, authority from UserAuthorities where username=?");
		
		//jpa-authentication
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(encoder());
	}

	
}
