package org.nioun.essentials.mog.security.config;

import org.nioun.essentials.mog.service.UserDetailsServiceImpl;
import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.BeanIds;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.Customizer;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class SecurityConfig {

    private static final String [] AUTH_WHITELIST= {
        //SWAGGER UI ...
                 
    };

         @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                .csrf(csrf -> csrf.disable()) // Example: Disable CSRF
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers(
                "/public/**", "/static/**", "/resources/**", "/jsps/**","/templates/**",
                "/webjars/**","/assets/**","/customer-photos/**","/product-photos/**",
    			
    			"/images/**", "/js/**","/css/**","*/png" ,"*/gif",
    			
    			"/login/** ","/login","/",
    			
				"/index","/products","/products-form","/products-list",
				
				"/bebe","/visage","/corps","/footer","/parfum",
				
				"/navbar").permitAll() // Example: Allow public access
                .anyRequest().authenticated())
                .cors(Customizer.withDefaults())
                .httpBasic();                
            return http.build();
        }

        @Bean
        public UserDetailsService userDetailsService(PasswordEncoder encoder){

            //InMemory user\DetailsManager set up with three users
            UserDetails admin = User.withUsername("Amina")
                                    .password(encoder.encode("123"))
                                    .roles("ADMIN" , "USER")
                                    .build();
            UserDetails user = User.withUsername("Matar")
                                    .password(encoder.encode("456"))
                                    .roles("USER")
                                    .build();

            return new InMemoryUserDetailsManager(admin,user);

        }

        //password encoding
        @Bean
        public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }
        

	}