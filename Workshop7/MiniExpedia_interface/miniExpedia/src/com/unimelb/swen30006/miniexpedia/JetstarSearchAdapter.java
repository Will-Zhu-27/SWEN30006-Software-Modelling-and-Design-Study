package com.unimelb.swen30006.miniexpedia;

import java.util.ArrayList;
import java.util.List;

import com.unimelb.swen30006.Jetstar.JetstarFlight;
import com.unimelb.swen30006.Jetstar.JetstarSearch;
import com.unimelb.swen30006.miniexpedia.interfaceAdapter.IFlightAdapter;
import com.unimelb.swen30006.miniexpedia.interfaceAdapter.IFlightSearchAdapter;

public class JetstarSearchAdapter implements IFlightSearchAdapter {
	private JetstarSearch theJetstarSearch;
	
	public JetstarSearchAdapter() throws Exception {
		theJetstarSearch = new JetstarSearch();
		
	}
	
	@Override
	public ArrayList<IFlightAdapter> flightSearch(FlightSearchRequest request) {
		// TODO Auto-generated method stub
		try {
			theJetstarSearch.setNumPassengers(request.getNumPassengers());
			theJetstarSearch.startInputFlights();
			List<FlightRequestInfo> requestInfoList = request.getFlightRequestListCopy();
			for (FlightRequestInfo requestInfo: requestInfoList) {
				theJetstarSearch.inputFlight(requestInfo.getFrom(), requestInfo.getTo(), requestInfo.getDepartAt());
			}
			theJetstarSearch.endInputFlights();
			int sizeRequest = requestInfoList.size();
			theJetstarSearch.search();
			ArrayList<IFlightAdapter> flightList = new ArrayList<IFlightAdapter>();
			for (int i = 0; i < sizeRequest; i++) {
				for (JetstarFlight flight : theJetstarSearch.getSearchResult(i)) {
					flightList.add(new JetstarFlightAdapter(flight));
				}
			}
			return flightList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}