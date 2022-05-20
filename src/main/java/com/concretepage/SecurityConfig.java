package com.concretepage;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		   .antMatchers("/**").access("hasRole('USER')")
		   .and().formLogin();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("ram")
		.password("{noop}ram123") //ram123
		.roles("USER")
		.and()
		.withUser("lakhan")
		.password("{bcrypt}$2a$10$q5pHs1fyVDbQSnBu3Il/meAONlMYFT1RhGlT2OC6IXX5.bp2JBZU6") //lakhan123
		.roles("USER")
		.and() 
		.withUser("bharat")
		.password("{pbkdf2}77a366e9ba2d6830b64d1b86eb7462996f3102d2b76562de3e56e5f13543a02486e1ee553cef18de") //bharat123
		.roles("USER")
		.and()
		.withUser("shatru")
		.password("{scrypt}$e0801$VoXA+5ot9fXbuLaOj5izqgd3JrOtBjvsqpbwssgHIA3omPpNB8t+FYtnsVpxx5DJjAvFtrA/klDstepB320TSw==$CLsjnAxzzNof2jkDrSBeoCTvuxO8qi67FRDY0vrCZwY=") //shatru123
		.roles("USER")
		.and()
		.withUser("bali")
		.password("{sha256}25ff1da3db4fc9bfab27acfc47625ac607a076450762fed1d53003ebeb73239e70529567767eee51") //bali123
		.roles("USER");		
	}
} 