package com.unimelb.swen30006.miniexpedia;

import java.util.ArrayList;
import com.unimelb.swen30006.Virgin.VirginBook;
import com.unimelb.swen30006.Virgin.VirginFlight;
import com.unimelb.swen30006.Virgin.VirginPassenger;
import com.unimelb.swen30006.miniexpedia.interfaceAdapter.IFlightAdapter;
import com.unimelb.swen30006.miniexpedia.interfaceAdapter.IFlightBookAdapter;
import com.unimelb.swen30006.miniexpedia.interfaceAdapter.IFlightPassengerAdapter;

public class VirginBookAdapter implements IFlightBookAdapter {
	public VirginBook book;
	
	public VirginBookAdapter() {
		this.book = new VirginBook();
	}
	
	@Override
	public String book(ArrayList<IFlightAdapter> flightAdapterList,
			ArrayList<IFlightPassengerAdapter> passengerAdapterList) {
		// TODO Auto-generated method stub
		ArrayList<VirginPassenger> passengerList = new ArrayList<VirginPassenger>();
		ArrayList<VirginFlight> flightList = new ArrayList<VirginFlight>();
		for(IFlightAdapter flightAdapter : flightAdapterList) {
			flightList.add(((VirginFlightAdapter)(flightAdapter)).flight);
		}
		for(IFlightPassengerAdapter passengerAdapter : passengerAdapterList) {
			passengerList.add(((VirginPassengerAdapter)(passengerAdapter)).passenger);	
		}
		return book.book(flightList, passengerList);
	}
	
}