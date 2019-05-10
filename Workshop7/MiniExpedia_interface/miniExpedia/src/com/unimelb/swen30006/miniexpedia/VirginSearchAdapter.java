package com.unimelb.swen30006.miniexpedia;

import java.util.ArrayList;
import com.unimelb.swen30006.Virgin.VirginFlight;
import com.unimelb.swen30006.Virgin.VirginSearch;
import com.unimelb.swen30006.miniexpedia.interfaceAdapter.IFlightAdapter;
import com.unimelb.swen30006.miniexpedia.interfaceAdapter.IFlightSearchAdapter;

public class VirginSearchAdapter implements IFlightSearchAdapter {
	private VirginSearch theVirginSearch;
	
	public VirginSearchAdapter() {
		theVirginSearch = new VirginSearch();
	}
	
	@Override
	public ArrayList<IFlightAdapter> flightSearch(FlightSearchRequest request) {
		ArrayList<VirginFlight> flightList = new ArrayList<VirginFlight>();
		for(FlightRequestInfo requestInfo : request.getFlightRequestListCopy()) {
			flightList.addAll(theVirginSearch.search(requestInfo.getFrom(), requestInfo.getTo(), requestInfo.getDepartAt(), request.getNumPassengers()));
		}
		ArrayList<IFlightAdapter> flightAdapterList = new ArrayList<IFlightAdapter>();
		for(VirginFlight flight : flightList) {
			flightAdapterList.add(new VirginFlightAdapter(flight));
		}
		return flightAdapterList;
	}
}