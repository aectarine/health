package com.ksd.health.encoding;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class PwdEncodeTest {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void 패스워드_인코딩() {
        String pwd = "1z2s4d!!";
        String encodedPwd = passwordEncoder.encode(pwd);
        System.out.println(pwd + " = " + encodedPwd);
        if(passwordEncoder.matches(pwd, encodedPwd)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

}
