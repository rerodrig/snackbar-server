package br.com.snackbar.serversideapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.snackbar.serversideapp.config.TestConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { TestConfiguration.class })
public class SnackBarServerApplicationTests {

	@Test
	public void contextLoads() {
	}

}
