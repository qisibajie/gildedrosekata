package ir4.arp.parklot.boy;

import ir4.arp.parklot.Car;
import ir4.arp.parklot.ParkingLot;
import ir4.arp.parklot.ParkingTicket;
import ir4.arp.parklot.exception.NoAvaliableParkingSpacesException;
import ir4.arp.parklot.exception.NoParkingLotException;

public class SmartParkingBoy extends BaseParkingBoy {
    
	@Override
	public ParkingTicket parkCar(Car car) {
		ParkingLot parkingLot = getMaxAvailableMarkLot();
		if(parkingLot.getAvailableParkingSpaces() == 0){
			throw new NoAvaliableParkingSpacesException("No Available Parking Spaces.");
		}else{
			return parkingLot.parkCar(car);
		}
	}
	

	private ParkingLot getMaxAvailableMarkLot() {
		
		if(parkingLots.size() == 0){
			throw new NoParkingLotException("There is no available parking lot");
		}
		ParkingLot maxAvailableParkingSpacesParkingLot = (ParkingLot) parkingLots.values().toArray()[0];
		for(ParkingLot parkingLot: parkingLots.values()){
			if(parkingLot.getAvailableParkingSpaces() > maxAvailableParkingSpacesParkingLot.getAvailableParkingSpaces()){
				maxAvailableParkingSpacesParkingLot = parkingLot;
			}
		}
		return maxAvailableParkingSpacesParkingLot;
	}
}
