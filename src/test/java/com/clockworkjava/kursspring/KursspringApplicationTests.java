package com.clockworkjava.kursspring;

import com.clockworkjava.kursspring.domain.repository.InMemoryRepository;
import com.clockworkjava.kursspring.domain.Knight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class KursspringApplicationTests {

	@Autowired
	Knight knight;

	@Autowired
    InMemoryRepository inMemoryRepository;
	@Test
	public void contextLoads() {
	}

	@Test
	public void testCastle(){
		String except = "Znajduje sie tu zamek o nazwie East Watch. Zamieszkaly przez rycerza Rycerz o imieniu Lancelot(29). Zadanie: Uratuj ksiezniczke";
		assertEquals(except, inMemoryRepository.toString());
	}
}
