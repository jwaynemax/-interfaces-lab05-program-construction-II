package edu.westga.cs6312.climate.model;

import java.util.ArrayList;

import edu.westga.cs6312.climate.interfaces.Sensor;

/**
 * Represents a Single Weather Station
 * @author justinmaxwell
 * @version 2/10/23
 *
 */

public class WeatherStation {
	private  int dangerouslyHotTemperature = 50;
	private String name;
	private ArrayList<DailySummary> summaries;
	private ArrayList<Sensor> sensors;

	/**
	 * Constructor for WeatherStation
	 * 
	 * @precondition stationName != null && !stationName.isBlank/isEmpty
	 * @postCondition this.name == stationName && summaries.length() == 0
	 * 
	 * @param stationName
	 */
	public WeatherStation(String stationName) {
		if (stationName == null || stationName.isBlank()) {
			throw new IllegalArgumentException("station name is null, empty, or just white space");
		}

		this.name = stationName;
		this.summaries = new ArrayList<DailySummary>();	
		
		Sensor wind1 = new WindSensor("Wind Sensor 1", "Wind");
		Sensor wind2 = new WindSensor("Wind Sensor 2", "Wind");
		Sensor wind3 = new WindSensor("Wind Sensor 3", "Wind");
		
		Sensor temp1 = new TemperatureSensor("Temp Sensor 1", "Temp");
		Sensor temp2 = new TemperatureSensor("Temp Sensor 2", "Temp");
		Sensor temp3 = new TemperatureSensor("Temp Sensor 3", "Temp");
		
		Sensor precip1 = new PrecipitationSensor("Precip Sensor 1", "Precip");
		Sensor precip2 = new PrecipitationSensor("Precip Sensor 2", "Precip");
		Sensor precip3 = new PrecipitationSensor("Precip Sensor 3", "Precip");
		
		this.sensors.add(wind1);
		this.sensors.add(wind2);
		this.sensors.add(wind3);
		
		this.sensors.add(temp1);
		this.sensors.add(temp2);
		this.sensors.add(temp3);
		
		this.sensors.add(precip1);
		this.sensors.add(precip2);
		this.sensors.add(precip3);
	}

	/**
	 * Getter for this.name
	 * @return this.name value
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Getter for this.summaries
	 * @return this.summaries value
	 */
	public ArrayList<DailySummary> getSummaries() {
		return this.summaries;
	}

	/**
	 * Add a new summary to the WeatherStation
	 * 
	 * @precondition newSummary != null && !this.summaries.contains(newSummary.date)
	 * 
	 * @param newSummary
	 */
	public void addNewSummary(DailySummary newSummary) {
		if (newSummary == null) {
			throw new IllegalArgumentException("the summary being added cannot be null");
		}
		if (this.getSummaries().size() > 0) {
			Boolean sameDate = false;

			for (DailySummary currentSummary : this.getSummaries()) {			
				if (currentSummary.getDate().equals(newSummary.getDate())) {
					sameDate = true;
					break;
				}
			}
			if (sameDate) {
				throw new IllegalArgumentException("the new summary being added cannot have the same date as an existing summary");
			}
		}

		this.summaries.add(newSummary);	
	}

	/**
	 * Find the hottest day recorded within the summaries
	 * 
	 * @return DailySummary with the highest temperature recorded or null if no summaries
	 */
	public DailySummary findHottestday() {
		if (this.getSummaries().size() == 0) {
			return null;
		}

		DailySummary hottestDay = this.getSummaries().get(0);

		for (DailySummary currentSummary : this.getSummaries()) {
			if (currentSummary.findHiTempInF() > hottestDay.findHiTempInF()) {
				hottestDay = currentSummary;
			}		
		}	
		return hottestDay;
	}

	/**
	 * Counts and returns the total number of days who's temperature exceeded DANGEROUSLY_HOT_TEMPERATURE
	 * @return the count of the number of days 
	 */
	public int countDaysOver50F() {
		int totalDays = 0;

		if (this.getSummaries().size() == 0) {
			return totalDays;
		}

		for (DailySummary currentSummary : this.getSummaries()) {
			if (currentSummary.findHiTempInF() > this.getDangerouslyHotTemperature()) {
				totalDays += 1;
			}
		}

		return totalDays;
	}

	/**
	 * Get the average wind speed measured from all hourly measurement points
	 * @return the average
	 */
	public int getAverageWindSpeed() {
		int totalWindSpeed = 0;
		int totalMeasurementPoints = 0;

		if (this.getSummaries().size() == 0) {
			return 0;
		}

		for (DailySummary currentSummary : this.getSummaries()) {
			if (currentSummary.getHourlyMeasurements().size() == 0) {
				continue;
			}

			for (HourlyMeasurement currentMeasurement : currentSummary.getHourlyMeasurements()) {
				totalWindSpeed += currentMeasurement.getMeasuredWindSpeed();
				totalMeasurementPoints += 1;
			}
		}
		if (totalMeasurementPoints == 0) {
			return 0;
		}

		return totalWindSpeed / totalMeasurementPoints;
	}

	/**
	 * Get the average wind speed measured from all hourly measurement points below -25
	 * @return the average
	 */
	public int getAverageWindSpeedWhenTempBelow25() {
		int totalWindSpeed = 0;
		int totalMeasurementPoints = 0;

		if (this.getSummaries().size() == 0) {
			return 0;
		}

		for (DailySummary currentSummary : this.getSummaries()) {
			if (currentSummary.getHourlyMeasurements().size() == 0) {
				continue;
			}

			for (HourlyMeasurement currentMeasurement : currentSummary.getHourlyMeasurements()) {
				if (currentMeasurement.getTempInF() < -25) {
					totalWindSpeed += currentMeasurement.getMeasuredWindSpeed();
					totalMeasurementPoints += 1;
				}	
			}
		}

		if (totalMeasurementPoints == 0) {
			return 0;
		}

		return totalWindSpeed / totalMeasurementPoints;
	}
	
	/**
	 * Getter 
	 * @return the dangerouslyHotTemperature
	 */
	public int getDangerouslyHotTemperature() {
		return this.dangerouslyHotTemperature;
	}

	/**
	 * Setter
	 * @param dangerouslyHotTemperature the dangerouslyHotTemperature to set
	 */
	public void setDangerouslyHotTemperature(int dangerouslyHotTemperature) {
		this.dangerouslyHotTemperature = dangerouslyHotTemperature;
	}
}