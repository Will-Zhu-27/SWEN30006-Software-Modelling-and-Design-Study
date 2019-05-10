/**
 * This class is created for Workshop's exercises in the subject SWEN30006 Software Design and Modelling at The University of Melbourne .
 * @author 	Patanamon Thongtanunam
 * @version 1.0
 * @since 	2019-04-20
 *
 */

package com.unimelb.swen30006.miniexpedia;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class miniExpedia {
	
	public static void main(String[] args) throws ParseException {
		
		Scanner in = new Scanner(System.in);
		boolean stopInput = false;
		String[] airlines = {"Jetstar","Qantas","Virgin"};
		

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd&HH:mm");
		System.out.print("Number of Passengers: ");
		int numPassengers = in.nextInt();
		FlightSearchRequest flightSearchRequest = new FlightSearchRequest(numPassengers);
		
		while(!stopInput) {
			System.out.print("Date & Time (ex. 2019-04-29&10:00): ");
			String dateStr = in.next();

			LocalDateTime date = null;
			//Check date
			try {
				date = LocalDateTime.parse(dateStr,formatter);
			}catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Wrong Date & Time Format.");
				continue;
			}
			
			System.out.print("Departure airport: ");
			String departure = in.next();
			System.out.print("Destination airport: ");
			String destination = in.next();
			flightSearchRequest.addFlightRequestInfo(departure, destination, date);

			System.out.print("More flight? (y/n): ");
			String input = in.next();
			input = input.toLowerCase();
			stopInput = input.equals("n");
			System.out.println(stopInput);
		}
		
		System.out.print("Preferred airline? (0: All, 1: Jetstar, 2: Qantas, 3: Virgin)");
		int airlineIndex = in.nextInt();
		in.close();
		
	}
	

	
}
