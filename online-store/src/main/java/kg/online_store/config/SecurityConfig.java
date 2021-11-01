package kg.online_store.config;

import kg.online_store.config.handler.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(@Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/login")
                .successHandler(new LoginSuccessHandler())
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .and()
                .httpBasic();

        http
                .logout()
                .permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout");

        http
                .csrf().disable()
                .authorizeRequests()

                .antMatchers("/stock").permitAll()
                .antMatchers("/main-page").permitAll()
                .antMatchers(HttpMethod.GET, "/stock/**", "/product/**", "/category/**", "/user/users").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.PUT, "/user/updateUser").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.DELETE, "/stock/**", "/product/**", "/category/**", "/user/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/user/register").permitAll()
                .antMatchers(HttpMethod.POST, "/product/**", "/stock/**", "/category/**", "/user/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/product/**", "/category/**", "/user/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/user/**").hasRole("ADMIN")
                .antMatchers("/admin_page").hasRole("ADMIN")
                .antMatchers("/sign_up", "/js/**", "/styles/**").permitAll()
                .antMatchers("/swagger-ui/**").anonymous()
                .anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**");
    }
}
