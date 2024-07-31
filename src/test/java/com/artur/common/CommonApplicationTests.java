package com.artur.common;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;



@DataMongoTest
class CommonApplicationTests {

	@Test
	void contextLoads() {
	}

	@SpringBootApplication
	static class TestApplication{ }
}
