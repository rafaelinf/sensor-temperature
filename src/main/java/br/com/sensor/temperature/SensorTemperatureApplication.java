package br.com.sensor.temperature;

import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import br.com.sensor.temperature.service.TemperatureService;

@SpringBootApplication
@EnableAsync
public class SensorTemperatureApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SensorTemperatureApplication.class);
    
    @Autowired
    private TemperatureService temperatureService;
    
	public static void main(String[] args) {
		SpringApplication.run(SensorTemperatureApplication.class, args);
	}

    @Bean(name = "execSendTemperature")
    public Executor asyncExecutor() {
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(3);
        executor.initialize();
        return executor;
    }
    
    @Override
    public void run(String... args) {
    	log.info("EXECUTING : command line runner");
  
    	while(true) {
    		
        	asyncExecutor().execute(new Runnable() {
    			@Override
    			public void run() {
    				temperatureService.sendTemperature();
    			}
    		});
        	
        	
        	try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	
    	}

    }
    
}
