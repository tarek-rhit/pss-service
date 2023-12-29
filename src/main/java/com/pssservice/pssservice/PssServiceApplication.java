package com.pssservice.pssservice;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class PssServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PssServiceApplication.class, args);
    }
    @Bean
    public ModelMapper modelMaper() {
        return new ModelMapper();
    }
/*
     @Bean
     PasswordEncoder passwordEncoder() {
          return new BCryptPasswordEncoder();
     }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200")); //or add * to allow all origins
        configuration.setAllowCredentials(true);
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")); //to set allowed http methods
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        configuration.setExposedHeaders(Arrays.asList("custom-header1", "custom-header2"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    CommandLineRunner go(AppUserService appUserService) {
        return args -> {
            appUserService.saveAppRole(new AppRole(null, "ADMIN"));
            appUserService.saveAppRole(new AppRole(null, "MANAGER"));
            appUserService.saveAppRole(new AppRole(null, "USER"));
            appUserService.saveAppRole(new AppRole(null, "SUPER_ADMIN"));

            appUserService.saveAppUser(new AppUser(null, "Jhon Travolta", "jhon", "1234", new ArrayList<>()));
            appUserService.saveAppUser(new AppUser(null, "Will Smith", "will", "1234", new ArrayList<>()));
            appUserService.saveAppUser(new AppUser(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
            appUserService.saveAppUser(new AppUser(null, "Arnold Schwarzeineger", "arnold", "1234", new ArrayList<>()));

            appUserService.addRoleToUser("jhon","USER");
            appUserService.addRoleToUser("jhon","MANAGER");
            appUserService.addRoleToUser("will","MANAGER");
            appUserService.addRoleToUser("jim","ADMIN");
            appUserService.addRoleToUser("arnold","SUPER_ADMIN");
            appUserService.addRoleToUser("arnold","ADMIN");
            appUserService.addRoleToUser("arnold","USER");


        };
    }*/
}