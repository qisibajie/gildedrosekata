package ir4.arp.parklot.boy;

import ir4.arp.parklot.Car;
import ir4.arp.parklot.ParkingTicket;
import ir4.arp.parklot.behavior.ParkingAble;
import ir4.arp.parklot.exception.NoAvaliableParkingSpacesException;
import ir4.arp.parklot.exception.ParkingTicketInValidException;

import java.util.*;

public class ParkingManager {

    private List<ParkingAble> parkingAbles = new ArrayList<>();

    public void addParkingAble(ParkingAble parkingAble) {
        parkingAbles.add(parkingAble);
    }

    public ParkingTicket parkCar(Car car) {
        for (ParkingAble parkingAble : parkingAbles) {
            if (parkingAble.hasAvailableSpaces()) {
                return parkingAble.parkCar(car);
            }
        }
        throw new NoAvaliableParkingSpacesException("There is no available parking space");
    }

    public Car pickUpCar(ParkingTicket parkingTicket) {
        for (ParkingAble parkingAble : parkingAbles) {
            if(parkingAble.hasSuchCar(parkingTicket)){
                return parkingAble.pickUpCar(parkingTicket);
            }
        }
        throw new ParkingTicketInValidException("This Ticket is invalid");
    }

    public List<ParkingAble> getParkingAbles(){
        return parkingAbles;
    }

    public int getParkingSpaces(){
        int totalSpaces = 0;

        for(ParkingAble parkingAble : parkingAbles){
            totalSpaces += parkingAble.getAllParkingSpaces();
        }

        return totalSpaces;
    }


    public int getNumOfParkedCars(){
        int parkedCars = 0;
        for(ParkingAble parkingAble : parkingAbles){
            parkedCars += parkingAble.getNumOfParkedCars();
        }
        return parkedCars;
    }

}
