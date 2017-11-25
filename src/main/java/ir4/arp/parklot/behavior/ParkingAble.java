package ir4.arp.parklot.behavior;

import ir4.arp.parklot.Car;
import ir4.arp.parklot.ParkingTicket;

/**
 * Created by on 10/26/2017.
 */
public interface ParkingAble {
    public ParkingTicket parkCar(Car car);

    public Car pickUpCar(ParkingTicket parkingTicket);

    public boolean hasAvailableSpaces();

    public boolean hasSuchCar(ParkingTicket parkingTicket);

    public int getAllParkingSpaces();

    public int getNumOfParkedCars();
}
