package br.com.sensor.temperature.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {

	private String sensor;
	private Double value;
	
	public String getSensor() {
		return sensor;
	}
	public void setSensor(String sensor) {
		this.sensor = sensor;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
        return "Temperature{" +
                "sensor='" + sensor + '\'' +
                ", value=" + value +
                '}';
	}
	
}
