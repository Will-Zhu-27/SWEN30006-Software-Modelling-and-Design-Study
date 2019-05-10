package com.unimelb.swen30006.miniexpedia;

import java.util.ArrayList;

public interface IFlightSearchAdapter {
	public ArrayList<IFlightAdapter> flightSearch(FlightSearchRequest request);
}