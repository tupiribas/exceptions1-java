package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("Room number: ");
			int numberRoom = sc.nextInt();
			
			System.out.print("Check-in date (DD/MM/YYYY): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (DD/MM/YYYY): ");
			Date checkOut = sdf.parse(sc.next());
	
			Reservation reserv = new Reservation(numberRoom, checkIn, checkOut);
			System.out.println("Reservation: " + reserv);
	
			System.out.print("\nEnter date to update the reservation: ");
			System.out.print("\nCheck-in date (DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (DD/MM/YYYY	): ");
			checkOut = sdf.parse(sc.next());
	
			reserv.updateDates(checkIn, checkOut);
			System.out.println("Reservation :" + reserv);
		} 
		catch (ParseException ex) {
			System.out.println("Invalid date format.");
		} 
		catch (DomainException ex) {
			System.out.println("Erro in reservation: " + ex.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected erro");
		}
		
		sc.close();

	}

}
