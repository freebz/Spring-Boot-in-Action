// 코드 6-4 그루비로 작성한 SecurityConfig

package readinglist

import org.springframework.context.annotation.Configuration

import org.springframework.security.config.annotation.authentication.builders.
       AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.
       WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService

@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

    void configure(HttpSecurity http) throws Exception {
	http
	    .authorizeRequests()
	        .antMatchers("/").access("hasRole('READER')")
	        .antMatchers("/**").permitAll()
	    .and()
	    .formLogin()
	        .loginPage("/login")
	        .failureUrl("/login?error=true")
    }

    void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth
	    .userDetailsService(
	        { username -> Reader.findByUsername(username) }    // username으로 독자 검색
	        as UserDetailsService)
    }

}
