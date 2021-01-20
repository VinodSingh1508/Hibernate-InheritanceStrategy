package org.javafreak.singleTable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/*
	SingleTable Strategy is the default strategy for inheritance mapping in Hibernate
	SingleTable strategy means all the data from parent and all the child classes will be stored in a single table
	i.e. Irrespective of the inheritance hierarchy, hibernate will create 1 common table for the base class
	and all the data from the base class as well as child class will be persisted in this table only
	The data will be segregated based on a column DTYPE(discriminator type) which by default holds the class name
	This strategy is hard to maintain when we have deep inheritance and big classes and also the data is not normalized
	
	Annotations -
		@Inheritance - (Optional) - to specify the inheritance strategy - default is SINGLE_TABLE
		@DiscriminatorColumn - (Optional) - to override the defaults of discriminator type column
			name - column name for discriminator type - default is DTYPE
			discriminatorType - Datatype of discriminator type column - default is String
		@DiscriminatorValue - (Optional) - to override the default discriminator value - default is ClassName
*/
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="VEHICLE_TYPE", 
	discriminatorType=DiscriminatorType.STRING
)
@DiscriminatorValue(value = "Veh")
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
