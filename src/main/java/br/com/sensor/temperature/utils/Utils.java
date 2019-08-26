package br.com.sensor.temperature.utils;

public class Utils {

	public static double getRandomDoubleBetweenRange(double min, double max){
	    double x = (Math.random()*((max-min)+1))+min;
	    return x;
	}
	
}
