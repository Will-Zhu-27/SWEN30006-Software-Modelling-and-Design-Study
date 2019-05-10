package com.unimelb.swen30006.miniexpedia;

public class FlightSearchFactory {
	private IFlightSearchAdapter flightSearchAdapter = null;
	public IFlightSearchAdapter getFlightSearchAdapter();
}