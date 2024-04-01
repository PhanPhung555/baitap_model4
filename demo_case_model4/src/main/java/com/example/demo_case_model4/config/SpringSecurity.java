package com.example.demo_case_model4.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Bean
    public static PasswordEncoder passwordEncoder() {
        // Chuỗi hóa mật khẩu ngược lại từ datadatabase
         return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((requests) -> requests.shouldFilterAllDispatcherTypes(true)
//                        Chấp nhận các requets tới đường dẫn login -> premitAll()
                        .requestMatchers("/login/**").permitAll()
//                        Chấp nhận các requets tới đường dẫn user với vai trò là phải User hoẵ Admin -> hasAnyRole("USER","ADMIN")
                        .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
//                        các requet tới đường dãn này phải có vài trò là admin
                        .requestMatchers("/admin/**").hasRole("ADMIN").anyRequest().authenticated())

                .formLogin((form) -> form.loginPage("/login").loginPage("/") // URL của trang đang nhập
                                .loginProcessingUrl("/login") // xử lý đăng nhập tự động
//                                .successHandler((request, response, authentication) -> {
//                                    Collection<? extends GrantedAuthority>
//                                            authorities = authentication.getAuthorities();
//                                    for (GrantedAuthority authority : authorities) {
//                                        if (authority.getAuthority().equals("ROLE_ADMIN")) {
//                                           response.sendRedirect( "/admin"); // Chuyển hướng đến trang admin
//                                        } else if (authority.getAuthority().equals("ROLE_USER")) {
//                                            response.sendRedirect("/user/"); // Chuyển hướng đến trang user
//                                        }
//                                    }
//                                })
                                .defaultSuccessUrl("/user/") // URL mặc định sau khi đăng nhập thành công
                                .permitAll()
                ).logout(LogoutConfigurer::permitAll);

        return httpSecurity.build();
    }
}
