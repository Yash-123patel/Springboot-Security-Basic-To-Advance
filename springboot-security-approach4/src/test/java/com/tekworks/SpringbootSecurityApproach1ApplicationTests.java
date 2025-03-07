package com.tekworks;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SpringbootSecurityApproach1ApplicationTests {

	@Test
	void contextLoads() {
		System.out.print("Password is: "+new BCryptPasswordEncoder().encode("patel")+"  End");
	}

}
