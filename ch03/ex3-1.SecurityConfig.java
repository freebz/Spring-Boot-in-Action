// 코드 3-1 자동 구성된 보안을 오버라이드하는 명시적 구성

package readinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.
    AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.
    WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ReaderRepository readerRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http
	    .authorizeRequests()
	        .antMatchers("/").access("hasRole('REDER')")    // READER 권한 필요
	        .antMatchers("/**").permitAll()

	    .and()

	    .formLogin()
	        .loginPage("/login")    // 로그인 폼 경로 설정
	        .failureUrl("/login?error=true");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(new UserDetailsService() {    // 사용자 정의 UserDetailService
	    @Override
	    public UserDetails loadUserByUsername(String username)
		    throws UsernameNotFoundException {
		return readerRepository.findOne(username);
	    }
	});
    }

}
