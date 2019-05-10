package com.unimelb.swen30006.miniexpedia;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightSearchRequest {
	private int numPassengers;
	private ArrayList<FlightRequestInfo> flightRequestList;
	public FlightSearchRequest(int numPassengers) {
		this.numPassengers = numPassengers;
		flightRequestList = new ArrayList<FlightRequestInfo>();
	}
	
	public void addFlightRequestInfo(String from, String to, LocalDateTime departAt) {
		FlightRequestInfo flightRequestInfo = new FlightRequestInfo(from, to, departAt);
		flightRequestList.add(flightRequestInfo);
	}
	
	public int getNumPassengers() {
		return numPassengers;
	}
	
	public ArrayList<FlightRequestInfo> getFlightRequestListCopy() {
		return new ArrayList<FlightRequestInfo>(flightRequestList);
	}
}