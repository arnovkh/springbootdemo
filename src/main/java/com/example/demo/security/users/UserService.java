package com.example.demo.security.users;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public UserService(UserRepository userRep) {
        this.userRepository = userRep;
    }


    public Boolean IsUserValid(AppUser appUser) {
        try {
            List<AppUser> potentialUsers = this.userRepository.getUsers(
                    new AppUser(
                            appUser.getUsername(), appUser.getPassword())
                        );
            List<AppUser> result = potentialUsers.stream().
                    filter(pass-> encoder.matches(appUser.getPassword(), pass.getPassword())).
                    collect(Collectors.toList());

            return result.size() >0;

        } catch(Exception e) {
            return false;
        }

    }
}
