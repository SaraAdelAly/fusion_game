package Epic.fusiongames.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.util.StringTokenizer;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {


//    @Autowired
//    public final ConfigBasicAuthentication configBasicAuthentication;

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
            configureBasicAuthentication(httpSecurity);
            return httpSecurity.build();
    }

//    public static void configureEnfPoint (HttpSecurity httpSecurity) throws Exception{
//        httpSecurity.authorizeHttpRequests(r -> r.
////                requestMatchers("/create").hasAuthority("create").
//                anyRequest().authenticated());
//    }

    private static void configureBasicAuthentication(HttpSecurity httpSecurity)throws Exception {
        httpSecurity.httpBasic(c->c.realmName("game"));
    }
}
