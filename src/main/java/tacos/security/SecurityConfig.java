package tacos.security;

//@Configuration
public class SecurityConfig {

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService(UserRepository userRepository) {
//        return username -> {
//            User user = userRepository.findByUsername(username);
//            if (user == null) {
//                throw new UsernameNotFoundException("User: " + username + " is not found.");
//            }
//            return user;
//        };
//    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http.authorizeRequests().antMatchers("/design", "/orders").hasRole("USER")
//                .antMatchers("/", "/**").permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/design",true)
//                .loginProcessingUrl("/authenticate")
//                .failureUrl("/login?error=true")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .and()
//                .build();
//    }
}
