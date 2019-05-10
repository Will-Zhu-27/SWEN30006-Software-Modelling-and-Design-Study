package com.unimelb.swen30006.miniexpedia.interfaceAdapter;

import java.util.ArrayList;

import com.unimelb.swen30006.miniexpedia.FlightRequestInfo;

public interface IFlightAdapter {
	public String flightInfoToString(ArrayList<IFlightAdapter> flightList, FlightRequestInfo requestInfo);
}
