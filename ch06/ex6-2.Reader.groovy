// 코드 6-2 GORM Reader 엔티티

package readinglist

import grails.persistence.Entity

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity    // 엔티티
class Reader implements UserDetails {

    String username
    String fullname
    String password

    Collection<? extends GrantedAuthority> getAuthorities() {
	Arrays.asList(new SimpleGrantedAuthority("ROLE_READER"))
    }

    boolean isAccountNonExpired() {    // UserDetails 구현
	true
    }

    boolean isAccountNonLocked() {
	true
    }

    boolean isCredentialsNonExpired() {
	true
    }

    boolean isEnabled() {
	true
    }

}
