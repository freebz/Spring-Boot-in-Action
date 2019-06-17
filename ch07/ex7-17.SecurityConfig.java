// 코드 7-17 컨텍스트 경로를 /mgmt로 수정한 SecurityConfig

...
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    ...

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http
	    .authorizeRequests()
	        .antMatchers("/").access("hasRole('READER')")
	        .antMatchers("/mgmt/**").access("hasRole('ADMIN')")
	        .antMatchers("/**").permitAll()

	    .and()

	    .formLigin()
	        .loginPage("/login")
	        .failureUrl("/login?error=true");
    }
