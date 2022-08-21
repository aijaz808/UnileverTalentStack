package com.unilever.authservice.config;

import com.unilever.authservice.filter.JwtTokenAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity( securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public DefaultAuthenticationEventPublisher defaultAuthenticationEventPublisher(){
        return new DefaultAuthenticationEventPublisher();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new MessageDigestPasswordEncoder("MD5");// new BCryptPasswordEncoder();
    }

//	@Bean
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}

    private static final String[] AUTH_WHITELIST = {
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/auth/authenticate",
            "/auth/refreshToken",
            "/profile/isUserNameExist/*",
            "/profile/isEmailExist/*",
            "/profile/isUserPrincipalNameExist/*",
            "/profile/changePassword",
            "/document/downloadFile"
    };

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // We don't need CSRF for this example
        httpSecurity.csrf().disable()
                // dont authenticate this particular request
                .authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll().
                // all other requests need to be authenticated
                        anyRequest().authenticated().and().

//				logout().logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", "GET")).
//				invalidateHttpSession(true)
//				.deleteCookies("JSESSIONID").clearAuthentication(true).logoutSuccessUrl("/auth/login").and().
                // make sure we use stateless session; session won't be used to
                // store user's state.
                        sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Add a filter to validate the tokens with every request
        httpSecurity.addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public JwtTokenAuthFilter tokenAuthenticationFilter() {
        return new JwtTokenAuthFilter();
    }
}