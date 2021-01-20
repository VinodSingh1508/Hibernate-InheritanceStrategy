package org.javafreak.joined;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/*
	Joined strategy means we will have a separate table for every class that we need to persist
	but they will have columns for properties of their own class only. In addition to that,
	the table for child class will have a reference to the parent class for common properties.
	
	In our case say our TwoWheeler class has only one property steeringHandle so the table will have a column 
	for steeringHandle and a reference column to vehicle table for common properties
	
	This strategy generates the most normalized tables.
*/
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Vehicle {
	@Id @GeneratedValue
	private int vehicleId;
	private String vehicleName;
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
}
