// 코드 7-14 /shutdown 엔드포인트에 보안 적용

...

@Override
protected void configure(HttpSecurity http) throws Exception {
    http
	.authorizeRequests()
	    .antMatchers("/").access("hasRole('READER')")
	    .antMatchers("/shutdown").access("hasRole('ADMIN')")    // ADMIN 권한 필요
	    .antMatchers("/**").permitAll()
	.and()
	.formLogin()
	    .login("/login")
	    .failureUrl("/login?error=true");
}

...
