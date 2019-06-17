// 코드 7-15 인메모리 ADMIN 인증 사용자 추가

...
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    ...

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(new UserDetailsService() {    // Reader 인증
	    @Override
	    public UserDetails loadUserByUsername(String username)
		throws UsernameNotFoundException {
		UserDetails user = readerRepository.findOne(username);
		if (user != null) {
		    return user;
		}
		throw new UsernameNotFoundException("User '" + username + "' not found.");
	    }
	})
	.and()
	.inMemoryAuthentication()
	    .withUser("admin").password("s3cr3t")
	    .roles("ADMIN", "READER");    // ADMIN 인증
    }

}
