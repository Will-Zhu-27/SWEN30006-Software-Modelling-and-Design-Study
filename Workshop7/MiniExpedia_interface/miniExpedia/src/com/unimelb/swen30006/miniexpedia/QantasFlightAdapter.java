package com.unimelb.swen30006.miniexpedia;

import java.util.ArrayList;

import com.unimelb.swen30006.Qantas.QantasFlight;
import com.unimelb.swen30006.miniexpedia.interfaceAdapter.IFlightAdapter;

public class QantasFlightAdapter implements IFlightAdapter {
	public QantasFlight flight;
	public QantasFlightAdapter(QantasFlight flight) {
		this.flight = flight;
	}
	@Override
	public String flightInfoToString(ArrayList<IFlightAdapter> flightList, FlightRequestInfo requestInfo) {
		String ret = requestInfo.toString();
		for (int i = 0; i < flightList.size(); i++) {
			QantasFlightAdapter flightAdapter = (QantasFlightAdapter)(flightList.get(i));
			String flightInfo = "Jetstar: form " + flightAdapter.flight.from() + " to " + flightAdapter.flight.to() + " depart at " +
					flightAdapter.flight.departAt() + " arrive at " + flightAdapter.flight.arriveAt() + ", fare is " + flightAdapter.flight.fare() + "\n";
			ret += flightInfo;
		}
		return ret;
	}
	
}