package design.parking_lot;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

enum ParkingSoltType {
	LARGE, COMPACT, BIKE, HNADICAPPED;
}

enum VehicleType {
	CAR, BIKE, VAN, ELECTRIC;
}

class Account {
	String id;
	String pass;
	Date lastPasswordResetDate;
}

class Admin extends Account {
	// public void addFloor();
	// public void deleteFloor();
	// public void addSlot();
	// public void deleteSlot();
	// public void addAttedend();
	// public void removeAttended();

}

class Attendent extends Account {
	// public void payTicket(Ticket ticket);
}

class Ticket {
	String Id;
	Date startTime;
	Date EndTime;
	BigDecimal price;
}

class Vehicle {
	VehicleType type;
	Ticket ticket;

	Vehicle(VehicleType type) {
		this.type = type;
	}
}

class Car extends Vehicle {
	Car() {
		super(VehicleType.CAR);
	}
}

class Bike extends Vehicle {
	Bike() {
		super(VehicleType.BIKE);
	}
}

class Slot {
	String id;
	Vehicle vehicle;
	ParkingSoltType type;

	Slot(ParkingSoltType type, Vehicle vehicle) {
		this.type = type;
		this.vehicle = vehicle;
	}

	void freeSlot() {
		vehicle = null;
	}

}

class SlotCar extends Slot {
	SlotCar(Vehicle vehicle) {
		super(ParkingSoltType.LARGE, vehicle);

	}
}

class SlotBike extends Slot {
	SlotBike(Vehicle vehicle) {
		super(ParkingSoltType.BIKE, vehicle);

	}
}

class Board {
	Integer freeLargeSlots;
	Integer freeBikeSlots;

}

class ParkingFloor {
	Map<String, SlotCar> carSlots;
	Map<String, SlotBike> bikeSlots;
	Board board;

	public Slot getFreeSlots(ParkingSoltType parkingSoltType) {
		Slot freeSlot = null;
		switch (parkingSoltType) {
		case LARGE:
			freeSlot = findSlotCar(carSlots);
			break;
		default:
			System.out.println("wrong parkingSlotType");

		}
		return freeSlot;
	}

	private Slot findSlotCar(Map<String, SlotCar> carSlots) {
		for (Map.Entry<String, SlotCar> entry : carSlots.entrySet()) {
			if (entry.getValue().vehicle == null) {
				return entry.getValue();
			}
		}
		return null;
	}

	private Slot findSlotBike(Map<String, SlotBike> bikeSlots) {
		for (Map.Entry<String, SlotBike> entry : bikeSlots.entrySet()) {
			if (entry.getValue().vehicle == null) {
				return entry.getValue();
			}
		}
		return null;
	}

}

public class ParkingLot {
	static ParkingLot parkingLot = null;

	Map<String, ParkingFloor> floors;

	private ParkingLot() {
		// load from DB
		floors = new HashMap<String, ParkingFloor>();

	}

	public static ParkingLot getParkingLot() {
		if (parkingLot == null) {
			return new ParkingLot();
		}
		return parkingLot;

	}

	public synchronized Ticket getTicket(Vehicle vehicle, String floorId) {
		ParkingFloor floor = floors.get(floorId);

		Slot slot = null;
		switch (vehicle.type) {
		case CAR:
			slot = floor.getFreeSlots(ParkingSoltType.LARGE);
			break;
		default:
			System.out.println("un recoganised vehicle");
		}
		Ticket ticket = new Ticket();
		ticket.startTime = new Date();
		vehicle.ticket = ticket;
		slot.vehicle = vehicle;

		// update the board on floor and other information and commit to DB
		// Update(floorId,slot);

		return ticket;

	}

}
