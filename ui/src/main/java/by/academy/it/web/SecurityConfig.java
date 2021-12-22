package by.academy.it.web;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    @Autowired
    DataSource dataSource;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Bean
    protected DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/login").not().fullyAuthenticated()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/friends/**", "/edit/**", "/login/**", "/profile").hasRole("USER")
                .antMatchers("/", "/profile/**","/home").permitAll()
                .anyRequest()
                .authenticated()
                .and().formLogin().loginPage("/sign")
                .defaultSuccessUrl("/profile/{url}")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/");
        //.cors().and()
        //.csrf().disable()
        //.httpBasic().and()
        //.authorizeRequests()
        //.antMatchers("/login*", "/profile*", "/friends/**")
        //.permitAll()
        //.antMatchers("/admin/**").hasRole("ADMIN")
        //.and()
        //.logout()
        //.logoutUrl("/profile/logout")
        //.logoutSuccessUrl("/")
        //.logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK))
        //.invalidateHttpSession(true)
        //.clearAuthentication(true)
        //.addLogoutHandler(new HeaderWriterLogoutHandler(new ClearSiteDataHeaderWriter(ClearSiteDataHeaderWriter.Directive.ALL)))
        //.permitAll();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .withDefaultSchema()
                .withUser("user").password(passwordEncoder.encode("password")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder.encode("password")).roles("USER", "ADMIN");
    }


    @Override
    public void configure(WebSecurity web) {
        // Новый брандмауэр вынужден перезаписать исходный
        web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
    }

    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        DefaultHttpFirewall firewall = new DefaultHttpFirewall();
        firewall.setAllowUrlEncodedSlash(true);
        return firewall;
    }
}
//
//@EnableWebSecurity
//@EnableJdbcHttpSession
//@RequiredArgsConstructor
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final UserDetailsService userDetailsService;
//    private final PasswordEncoder passwordEncoder;
//    private final AuthenticationFailureHandler securityErrorHandler;
//    private final ConcurrentSessionStrategy concurrentSessionStrategy;
//    private final SessionRegistry sessionRegistry;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .cors().and()
//                //для защиты о csrf атак
//                .csrf().and()
//                .httpBasic().and()
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated().and()
//                //Логаут
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/api/logout"))
//                //Возвращаем при логауте 200(по умолчанию возвращается 203)
//                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK))
//                //Инвалидируем сессию при логауте
//                .invalidateHttpSession(true)
//                .clearAuthentication(true)
//                //Удаляем всю информацию с фронта при логауте(т.е. чистим куки, хидеры и т.д.)
//                .addLogoutHandler(new HeaderWriterLogoutHandler(new ClearSiteDataHeaderWriter(ClearSiteDataHeaderWriter.Directive.ALL)))
//                .permitAll().and()
//                //Включаем менеджер сессий(для контроля количества сессий)
//                .sessionManagement()
//                //Указываем макимальное возможное количество сессий(тут указано не 1, т.к. мы будем пользоваться своей кастомной стратегией, объяснение будет ниже)
//                .maximumSessions(3)
//                //При превышение количества активных сессий(3) выбрасывается исключение  SessionAuthenticationException
//                .maxSessionsPreventsLogin(true)
//                //Указываем как будут регестрироваться наши сессии(тогда во всем приложение будем использовать именно этот бин)
//                .sessionRegistry(sessionRegistry).and()
//                //Добавляем нашу кастомную стратегию для проверки кличества сессий
//                .sessionAuthenticationStrategy(concurrentSessionStrategy)
//                //Добавляем перехватчик для исключений
//                .sessionAuthenticationFailureHandler(securityErrorHandler);
//    }
//
//    //для инвалидации сессий при логауте
//    @Bean
//    public static ServletListenerRegistrationBean httpSessionEventPublisher() {
//        return new ServletListenerRegistrationBean(new HttpSessionEventPublisher());
//    }
//
//    @Bean
//    public static SessionRegistry sessionRegistry(JdbcIndexedSessionRepository sessionRepository) {
//        return new SpringSessionBackedSessionRegistry(sessionRepository);
//    }
//
