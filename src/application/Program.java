package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		System.out.print("Room number: ");
		int numberRoom = sc.nextInt();
		System.out.print("Check-in date (DD/MM/YYYY): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (DD/MM/YYYY): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Erro reservation: Check-out date must be after check-in date");
		} else {
			Date date = new Date();
			Reservation reserv = new Reservation(numberRoom, checkIn, checkOut);
			System.out.println("Reservation: " + reserv);
			
			System.out.print("\nEnter date to update the reservation: ");
			System.out.print("\nCheck-in date (DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (DD/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());
			
			System.out.println(date);

			if (checkIn.before(date) || checkOut.before(date)) { // data de entrada for antes e se a saida for antes
				System.out.println("Erro reservation: Reservation dates for update must be future dates");
			} 
			else if (!checkOut.after(checkIn)){
				System.out.println("Erro reservation: Check-out date must be after check-in date");
			} 
			else {
				reserv.updateDates(checkIn, checkOut); 
				System.out.println("Reservation: " + reserv);
			}
			
		}

		sc.close();

	}

}
