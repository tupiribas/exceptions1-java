package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		super();
		this.roomNumber = roomNumber;
		this.checkIn = checkin;
		this.checkOut = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public Date getCheckin() {
		return checkIn;
	}

	public Date getCheckout() {
		return checkOut;
	}

	public long duration() {
		long diff = getCheckout().getTime() - getCheckin().getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String updateDates(Date checkin, Date checkout) {
		Date date = new Date();
		if (checkin.before(date) || checkout.before(date)) { // data de entrada for antes e se a saida for antes
			return "Erro reservation: Reservation dates for update must be future dates";
		} 
		else if (!checkout.after(checkin)) {
			return "Erro reservation: Check-out date must be after check-in date";
		}
		this.checkIn = checkin;
		this.checkOut = checkout;
		return null;
	}

	@Override
	public String toString() {
		return "Room " + getRoomNumber() + ", checkin: " + SDF.format(getCheckin()) + ", checkout: "
				+ SDF.format(getCheckout()) + ", " + duration() + " night(s)";
	}

}
