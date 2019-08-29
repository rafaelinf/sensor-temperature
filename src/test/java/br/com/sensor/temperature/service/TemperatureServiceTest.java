package br.com.sensor.temperature.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Equals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import br.com.sensor.temperature.model.Message;
import br.com.sensor.temperature.model.Temperature;
import br.com.sensor.temperature.utils.Utils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TemperatureServiceTest {
	
	@BeforeClass
	public static void runBeforeAllTestMethods() {

	}
}
