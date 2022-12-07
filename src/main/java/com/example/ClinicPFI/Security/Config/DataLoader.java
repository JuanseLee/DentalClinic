

package com.example.ClinicPFI.Security.Config;

        import com.example.ClinicPFI.Model.Entities.AppUser;
        import com.example.ClinicPFI.Model.Entities.AppUserRole;
        import com.example.ClinicPFI.Repositories.IUserRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.ApplicationArguments;
        import org.springframework.boot.ApplicationRunner;
        import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
        import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private IUserRepository userRepository;

    @Autowired
    public DataLoader(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password");
        userRepository.save(new AppUser("User", "user@test.com", "user@test.com", password, AppUserRole.USER));
    }
}
