package com.unimelb.swen30006.miniexpedia.interfaceAdapter;

import java.util.ArrayList;

public interface IFlightBookAdapter {
	public String book(ArrayList<IFlightAdapter> flightAdapterList, ArrayList<IFlightPassengerAdapter> passengerAdapterList);
}
