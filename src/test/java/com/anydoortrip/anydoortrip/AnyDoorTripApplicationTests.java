package com.anydoortrip.anydoortrip;

import com.anydoortrip.anydoortrip.apps.user.entity.User;
import com.anydoortrip.anydoortrip.apps.user.service.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class AnyDoorTripApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
        Optional<User> user = userRepository.findByMobilePhone("15913200845");
        user.ifPresent(value -> System.out.println(value.getUsername()));
    }
}
