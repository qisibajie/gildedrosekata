package ir4.arp.parklot.boy;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import ir4.arp.parklot.Car;
import ir4.arp.parklot.ParkingLot;
import ir4.arp.parklot.ParkingTicket;
import ir4.arp.parklot.behavior.ParkingAble;
import ir4.arp.parklot.exception.ParkingTicketInValidException;

public abstract class BaseParkingBoy implements ParkingAble {
	
	protected Map<String, ParkingLot> parkingLots = new TreeMap<String, ParkingLot>(new Comparator<String>() {
		public int compare(String firstStr, String secondKey) {
			return firstStr.compareTo(secondKey);
		}
	});


	public void addParkingLot(ParkingLot parkingLot) {
		parkingLots.put(parkingLot.getParkingLotName(), parkingLot);
	}

	public Car pickUpCar(ParkingTicket parkingTicket) {
		if (parkingTicket == null) {
			throw new ParkingTicketInValidException("Ticket is inviald");
		}
		ParkingLot parkingLot = parkingLots.get(parkingTicket.getParkingLotName());
		return parkingLot.pickUpCar(parkingTicket);
	}

	public boolean hasAvailableSpaces() {
		for(ParkingLot parkingLot: parkingLots.values()){
			if(parkingLot.getAvailableParkingSpaces() > 0){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean hasSuchCar(ParkingTicket parkingTicket) {
		for(ParkingLot parkingLot: parkingLots.values()){
			if(parkingLot.hasSuchCar(parkingTicket)){
				return true;
			}
		}
		return false;
	}

	@Override
	public int getAllParkingSpaces(){
		int allSpaces = 0;
		for(ParkingLot parkingLot: parkingLots.values()){
			allSpaces += parkingLot.getAllParkingSpaces();
		}
		return allSpaces;
	}

	@Override
	public int getNumOfParkedCars(){
		int parkedCars = 0;
		for(ParkingLot parkingLot: parkingLots.values()){
			parkedCars += parkingLot.getNumOfParkedCars();
		}
		return parkedCars;
	}

	public ParkingLot getParkingLotByTicket(ParkingTicket parkingTicket){
		return parkingLots.get(parkingTicket.getParkingLotName());
	}
	
	public abstract ParkingTicket parkCar(Car car);
}
