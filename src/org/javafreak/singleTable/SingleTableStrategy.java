package org.javafreak.singleTable;

import org.hibernate.Session;

//This package project covers vedio no 19 & 20

public class SingleTableStrategy {

	public static void main(String[] args) {
		Session session=DBUtil.createSessionAndOpenTransaction();
		
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleName("My Vehicle");
		
		TwoWheeler twoWheeler=new TwoWheeler();
		twoWheeler.setVehicleName("Bike");
		twoWheeler.setSteeringHandle("Yamaha");
		
		FourWheeler fourWheeler=new FourWheeler();
		fourWheeler.setVehicleName("Car");
		fourWheeler.setSteeringWheel("Rolls Royace");
		
		
		session.save(vehicle);
		session.save(twoWheeler);
		session.save(fourWheeler);
		
		DBUtil.commitCloseTransactionCloseSession(session);
	}

}