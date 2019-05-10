package com.unimelb.swen30006.miniexpedia;

import java.util.ArrayList;

import com.unimelb.swen30006.Qantas.QantasFlight;

public class QantasFlightAdapter implements IFlightAdapter {
	public QantasFlight flight;
	public QantasFlightAdapter(QantasFlight flight) {
		this.flight = flight;
	}
	@Override
	public String flightInfoToString(ArrayList<IFlightAdapter> flightList, FlightRequestInfo requestInfo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}