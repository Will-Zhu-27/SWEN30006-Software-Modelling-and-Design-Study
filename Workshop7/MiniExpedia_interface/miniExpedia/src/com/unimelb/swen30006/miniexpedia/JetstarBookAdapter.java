package com.unimelb.swen30006.miniexpedia;

import java.util.ArrayList;

import com.unimelb.swen30006.Jetstar.JetstarBook;
import com.unimelb.swen30006.Jetstar.JetstarFlight;
import com.unimelb.swen30006.Jetstar.JetstarPassenger;

public class JetstarBookAdapter implements IFlightBookAdapter {
	private JetstarBook book;
	public JetstarBookAdapter() {
		book = new JetstarBook();
	}
	
	public String book(ArrayList<IFlightAdapter> flightAdapterList, ArrayList<IFlightPassengerAdapter> passengerAdapterList) {
		String ret= new String ();
		ArrayList<JetstarFlight> jetstarFlightList = new ArrayList<JetstarFlight>();
		for(int i = 0; i < flightAdapterList.size(); i++) {
			JetstarFlight flight = ((JetstarFlightAdapter)(flightAdapterList.get(i))).flight;
			jetstarFlightList.add(flight);
		}
		ArrayList<JetstarPassenger> passengerList = new ArrayList<JetstarPassenger>();
		for (int i = 0; i < passengerAdapterList.size(); i++) {
			JetstarPassenger passenger = ((JetstarPassengerAdapter)(passengerAdapterList.get(i))).passenger;
			passengerList.add(passenger);
		}
		
		try {
			ret = book.requestBooking(jetstarFlightList, passengerList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
}