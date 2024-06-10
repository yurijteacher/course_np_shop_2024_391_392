package ua.com.kisitoop202z2023.course_np_shop_2024_391_392.secutiry;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.service.UserService;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final UserService userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf((csrf)->csrf.disable())
                .authorizeHttpRequests((authorize)->
                                 authorize.requestMatchers("/",
                                                 "/category",
                                                 "/registration",
                                                 "/registration/*",
                                                 "/car",
                                                 "/addItemToCart",
                                                 "/updateProductFromCart",
                                                 "/deleteProductFromCart",
                                                 "/deleteAllProductFromCart",
                                                 "/payment",
                                                 "/delivery",
                                                 "/info",
                                                "/category/*",
                                                "/search",
                                         "/static/**"





                                                 )
                                .permitAll()
                                .requestMatchers("/user","/users", "/saveCart",
                                        "/order", "/buy","/thank"
                                        ).hasRole("User")
                                         .requestMatchers( "/category-manager",
                                                 "/product-manager",
                                                 "/order-manager",
                                                 "/manager",
                                                 "/saveNewCategory",
                                                 "/saveNewProduct",
                                                 "/updateCategory",
                                                 "/deleteCategory"

                                         )
                                         .hasRole("Manager")
                                         .requestMatchers("/admin").hasRole("Admin")
                                         .anyRequest().authenticated()
                )
                .formLogin((form)->
                        form.loginPage("/login")
                                .defaultSuccessUrl("/order")
                                .permitAll()
                )
                .logout((logout)->
                        logout.permitAll().logoutSuccessUrl("/")
                        )
                .authenticationProvider(authenticationProvider());


        return http.build();
    }


}
