package org.javafreak.tablePerClass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/*
	TablePerClas strategy means we will have a separate independent table for every class that we need to persist
	All the data from the all classes, parent and all the child, will be persisted in its respective table
	
	The table for child class will have columns for properties from both parent class as well as its own properties
	and will be independent, it will have no reference to parent class table
	In our case say our TwoWheeler class has only one property steeringHandle but the table will have three 
	columns vehicleid & vehiclename from parent class Vehicle and steeringhandle from TwoWheeler
	
	This makes reading data easy but the tables are not normalized and have redundent data.
*/
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
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
