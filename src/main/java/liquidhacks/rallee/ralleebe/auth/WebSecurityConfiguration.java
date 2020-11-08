package liquidhacks.rallee.ralleebe.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private UserDetailsService userDetailsService;
	private static final String[] AUTH_WHITELIST = {
			"/v2/api-docs",
			"/swagger-resources",
			"/swagger-resources/**",
			"/configuration/ui",
			"/configuration/security",
			"/swagger-ui.html",
			"/webjars/**"
	};

	public WebSecurityConfiguration(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder)    {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userDetailsService = userDetailsService;
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/v2/api-docs",
				"/configuration/ui",
				"/swagger-resources/**",
				"/configuration/security",
				"/swagger-ui.html",
				"/webjars/**",
				"/signup",
				"/login/",
				"/player");
	}

	protected void configure(HttpSecurity httpSecurity) throws Exception    {
		httpSecurity.cors().and().csrf().disable().authorizeRequests()
		.antMatchers(AUTH_WHITELIST).permitAll()
		.antMatchers(HttpMethod.POST, "/signup").permitAll()
		.antMatchers(HttpMethod.GET, "/swagger-ui.html").permitAll()
		.anyRequest().authenticated()
		.and().addFilter(new AuthenticationFilter(authenticationManager()))
		.addFilter(new AuthorizationFilter(authenticationManager()))
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		httpSecurity.authorizeRequests().and().formLogin()//
        // Submit URL of login page.
        .loginPage("/login").usernameParameter("email").passwordParameter("password").permitAll()
        .loginProcessingUrl("/doLogin")
        .successForwardUrl("/postLogin")
        .defaultSuccessUrl("/swagger-ui.html")//
        .failureUrl("/loginFailed")//
        // Config for Logout Page
        .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful").permitAll()
        .and().csrf().disable();
		
	}
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception    {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource()    {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**",new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
}