package br.com.sensor.temperature.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.sensor.temperature.model.Message;
import br.com.sensor.temperature.model.Temperature;
import br.com.sensor.temperature.utils.Utils;

@Service
public class TemperatureService {

    private static final Logger log = LoggerFactory.getLogger(TemperatureService.class);

    @Value("${api.temperature.url}")
	private String url;
	
    @Async("execSendTemperature")
    public Message sendTemperature() {
    	   	
    	RestTemplate restTemplate = new RestTemplate();

    	Temperature temperature = new Temperature();
    	temperature.setSensor("Temperatura");
    	temperature.setDateCreate(new Date());
    	temperature.setValue(Utils.getRandomDoubleBetweenRange(12.00, 18.00));
    	
    	log.info(temperature.toString());

    	HttpEntity<Temperature> request = new HttpEntity<>(temperature);
    	Message responseEntityMessage = restTemplate.postForObject(url, request, Message.class);

    	return responseEntityMessage;
    }

}
