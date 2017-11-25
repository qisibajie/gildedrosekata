package ir4.arp.parklot;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import ir4.arp.parklot.behavior.ParkingAble;
import ir4.arp.parklot.exception.NoAvaliableParkingSpacesException;
import ir4.arp.parklot.exception.ParkingTicketInValidException;

public class ParkingLot implements ParkingAble{

    private Map<ParkingTicket, Car> mapCarsTickets = new HashMap<ParkingTicket, Car>();
    private int totalCapacity = 100;
    private String parkingLotName;

    public BigDecimal getAvailablePercentSpaces() {
        return new BigDecimal(getAvailableParkingSpaces()).divide(new BigDecimal(this.totalCapacity));
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public ParkingLot(String name, int count) {
        totalCapacity = count;
        parkingLotName = name;
    }

    public int getAvailableParkingSpaces() {
        return totalCapacity - mapCarsTickets.size();
    }

    public ParkingTicket parkCar(Car car) {
        if (getAvailableParkingSpaces() <= 0) {
            throw new NoAvaliableParkingSpacesException("There is no available parking space");
        }
        ParkingTicket parkingTicket = new ParkingTicket(this.parkingLotName, car.getPlateNum());
        mapCarsTickets.put(parkingTicket, car);
        return parkingTicket;
    }

    public Car pickUpCar(ParkingTicket parkingTicket) {
        ParkingTicket ticket = getParkingTicket(parkingTicket);
        if (ticket == null) {
            throw new ParkingTicketInValidException("Parking Ticket is invalid");
        }
        return mapCarsTickets.remove(ticket);
    }

    public boolean hasAvailableSpaces() {
        return getAvailableParkingSpaces() > 0;
    }

    @Override
    public boolean hasSuchCar(ParkingTicket parkingTicket) {
        ParkingTicket ticket = getParkingTicket(parkingTicket);
        if (ticket == null) {
            return false;
        }
        return true;
    }

    @Override
    public int getAllParkingSpaces() {
        return this.totalCapacity;
    }

    @Override
    public int getNumOfParkedCars() {
        return mapCarsTickets.size();
    }

    private ParkingTicket getParkingTicket(ParkingTicket parkingTicket) {
        for (ParkingTicket ticket : mapCarsTickets.keySet()) {
            if (ticket.toString().equals(parkingTicket.toString())) {
                return ticket;
            }
        }
        return null;
    }
}
