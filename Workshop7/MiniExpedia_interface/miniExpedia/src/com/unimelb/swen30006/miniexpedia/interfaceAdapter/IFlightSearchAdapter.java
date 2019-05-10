package com.unimelb.swen30006.miniexpedia.interfaceAdapter;

import java.util.ArrayList;

import com.unimelb.swen30006.miniexpedia.FlightSearchRequest;

public interface IFlightSearchAdapter {
	public ArrayList<IFlightAdapter> flightSearch(FlightSearchRequest request);
}