package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainException {
		if (!checkout.after(checkin)) { // Defensive programming
			throw new DomainException("Check-out date must be after check-in date.");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkin;
		this.checkOut = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = getCheckOut().getTime() - getCheckIn().getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkin, Date checkout) throws DomainException {
		Date date = new Date();

		if (checkin.before(date) || checkout.before(date)) {
			throw new DomainException("Erro reservation: Reservation dates for update must be future dates");
		} 
		else if (!checkout.after(checkin)) {
			throw new DomainException("Erro reservation: Check-out date must be after check-in date");
		}

		this.checkIn = checkin;
		this.checkOut = checkout;
	}

	@Override
	public String toString() {
		return "Room " + getRoomNumber() + ", checkin: " + SDF.format(getCheckIn()) + ", checkout: "
				+ SDF.format(getCheckOut()) + ", " + duration() + " night(s)";
	}

}
