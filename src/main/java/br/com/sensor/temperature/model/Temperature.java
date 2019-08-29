package br.com.sensor.temperature.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {

	private String sensor;
	private Double value;
	private Date dateCreate;

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

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	@Override
	public String toString() {
		return "Temperature{" + "sensor='" + sensor + '\'' + ", value=" + value + ", dateCreate=" + dateCreate + '}';
	}

}
