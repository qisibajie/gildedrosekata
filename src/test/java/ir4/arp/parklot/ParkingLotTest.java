package ir4.arp.parklot;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ir4.arp.parklot.exception.NoAvaliableParkingSpacesException;
import ir4.arp.parklot.exception.ParkingTicketInValidException;

public class ParkingLotTest {

	@Test
	public void should_return_100_when_given_100_parking_spaces_0_car() {
		ParkingLot parkingLot = new ParkingLot("A1", 100);
		assertEquals(100, parkingLot.getAvailableParkingSpaces());
	}

	@Test
	public void should_return_80_when_given_100_parking_spaces_20_car() {
		ParkingLot parkingLot = new ParkingLot("A1", 100);
		for (int i = 0; i < 20; i++) {
			Car car = new Car("B " + i);
			parkingLot.parkCar(car);
		}
		assertEquals(80, parkingLot.getAvailableParkingSpaces());
	}

	@Test
	public void should_return_69_when_park_1_car_given_100_parking_spaces_with_parking_30_cars() {
		ParkingLot parkingLot = new ParkingLot("A1", 100);
		for (int i = 0; i < 30; i++) {
			Car car = new Car("B " + i);
			parkingLot.parkCar(car);
		}
		parkingLot.parkCar(new Car("B30"));
		assertEquals(69, parkingLot.getAvailableParkingSpaces());
	}

	@Test(expected = NoAvaliableParkingSpacesException.class)
	public void should_return_exception_when_park_1_car_given_100_parking_spaces_with_parking_100_cars() {
		ParkingLot parkingLot = new ParkingLot("A1", 100);
		for (int i = 0; i < 100; i++) {
			Car car = new Car("B " + i);
			parkingLot.parkCar(car);
		}
		parkingLot.parkCar(new Car("B100"));
	}

	@Test
	public void should_return_T2_when_park_1_car_given_100_parking_spaces_with_parking_1_car_ticket_T1() {
		ParkingLot parkingLot = new ParkingLot("A1", 100);
		String plateNum = "B086729";
		Car car = new Car(plateNum);
		ParkingTicket parkingTicket = parkingLot.parkCar(car);

		assertEquals("A1-TB086729", parkingTicket.getTicketNo());
	}

	@Test
	public void should_return_T2_when_park_1_car_given_100_parking_spaces_with_parking_99_car_tickets() {
		ParkingLot parkingLot = new ParkingLot("A1", 100);
		List<ParkingTicket> parkingTickets = new ArrayList<ParkingTicket>();
		for (int i = 0; i < 99; i++) {
			Car car = new Car("B" + i);
			parkingTickets.add(parkingLot.parkCar(car));
		}
		ParkingTicket parkingTicket = parkingLot.parkCar(new Car("B" + 99));
		for (int i = 0; i < 99; i++) {
			assertFalse(parkingTicket.equals(parkingTickets.get(i)));
		}
	}

	@Test
	public void should_return_91_when_pick_up_1_car_given_100_parking_spaces_with_parking_10_cars_tickets_TB0_TB9() {
		ParkingLot parkingLot = new ParkingLot("A1", 100);
		List<ParkingTicket> parkingTickets = new ArrayList<ParkingTicket>();
		List<Car> cars = new ArrayList<Car>();
		for (int i = 0; i < 10; i++) {
			Car car = new Car("B" + i);
			cars.add(car);
			parkingTickets.add(parkingLot.parkCar(car));
		}
		Car car = parkingLot.pickUpCar(parkingTickets.get(1));
		assertSame(cars.get(1), car);
	}

	@Test(expected = ParkingTicketInValidException.class)
	public void should_return_exception_when_pick_up_1_car_given_100_parking_spaces_with_parking_10_cars_tickets_TB0_TB9() {
		ParkingLot parkingLot = new ParkingLot("A1", 100);
		List<ParkingTicket> parkingTickets = new ArrayList<ParkingTicket>();
		for (int i = 0; i < 10; i++) {
			Car car = new Car("B" + i);
			parkingTickets.add(parkingLot.parkCar(car));
		}
		parkingLot.pickUpCar(new ParkingTicket("TB11"));
	}

	@Test
	public void should_return_exception_when_pick_up_1_car_given_100_parking_spaces_with_parking_1_cars_tickets_TB1() {
		ParkingLot parkingLot = new ParkingLot("A1", 100);
		Car expected = new Car("B" + 1);
		ParkingTicket parkingTicket = parkingLot.parkCar(expected);
		Car actual = parkingLot.pickUpCar(parkingTicket);
		assertSame(expected, actual);
	}
	
	@Test(expected = ParkingTicketInValidException.class)
	public void should_return_exception_when_pick_up_1_car_given_100_parking_spaces_with_pickup_same_car_twice() {
		ParkingLot parkingLot = new ParkingLot("A1", 100);
		Car expected = new Car("B" + 1);
		ParkingTicket parkingTicket = parkingLot.parkCar(expected);
		parkingLot.pickUpCar(parkingTicket);
		parkingLot.pickUpCar(parkingTicket);
	}

}
