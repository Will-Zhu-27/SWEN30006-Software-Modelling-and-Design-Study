package com.unimelb.swen30006.miniexpedia;

import java.util.ArrayList;
import com.unimelb.swen30006.Virgin.VirginFlight;
import com.unimelb.swen30006.miniexpedia.interfaceAdapter.IFlightAdapter;

public class VirginFlightAdapter implements IFlightAdapter {
	public VirginFlight flight;
	public VirginFlightAdapter(VirginFlight flight) {
		this.flight = flight;
	}
	
	@Override
	public String flightInfoToString(ArrayList<IFlightAdapter> flightList, FlightRequestInfo requestInfo) {
		String ret = requestInfo.toString();
		for (int i = 0; i < flightList.size(); i++) {
			VirginFlightAdapter flightAdapter = (VirginFlightAdapter)(flightList.get(i));
			String flightInfo = "Jetstar: form " + flightAdapter.flight.getDeparture() + " to " + flightAdapter.flight.getDestination() + " depart at " +
					flightAdapter.flight.getDepartureTime() + " arrive at " + flightAdapter.flight.getArrivalTime() + ", fare is " + flightAdapter.flight.getAirfare() + "\n";
			ret += flightInfo;
		}
		return ret;
	}
	
}