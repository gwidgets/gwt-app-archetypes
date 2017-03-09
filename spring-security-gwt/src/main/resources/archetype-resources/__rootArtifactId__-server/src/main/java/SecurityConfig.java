package ${package};

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//configure your custom authentication method
		auth.inMemoryAuthentication().withUser("username").password("password").roles("ADMIN");
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
		authorizeRequests()
		.antMatchers("/${rootArtifactId}.html", "/${rootArtifactId}/**", "/user").authenticated()
		.and().formLogin().defaultSuccessUrl("/${rootArtifactId}.html")
		.and()
		.logout().logoutUrl("/logout").logoutSuccessUrl("/login")
		.and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	}

}
