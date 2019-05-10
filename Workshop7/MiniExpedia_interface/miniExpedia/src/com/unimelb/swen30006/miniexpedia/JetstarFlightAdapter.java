package com.unimelb.swen30006.miniexpedia;

import java.util.ArrayList;

import com.unimelb.swen30006.Jetstar.JetstarFlight;

public class JetstarFlightAdapter implements IFlightAdapter{
	public JetstarFlight flight;
	public JetstarFlightAdapter(JetstarFlight flight) {
		this.flight = flight;
	}
	
	public String flightInfoToString(ArrayList<IFlightAdapter> flightList, FlightRequestInfo requestInfo) {
		System.out.println(requestInfo.toString());
		String ret = new String();
		for (int i = 0; i < flightList.size(); i++) {
			JetstarFlightAdapter flightAdapter = (JetstarFlightAdapter)(flightList.get(i));
			String flightInfo = "Jetstar: form " + flightAdapter.flight.from() + " to " + flightAdapter.flight.to() + " depart at " +
					flightAdapter.flight.departAt() + " arrive at " + flightAdapter.flight.arriveAt() + ", fare is " + flightAdapter.flight.fare() + "\n";
			ret += flightInfo;
		}
		return ret;
	}
}