package com.unimelb.swen30006.miniexpedia;

import java.util.ArrayList;
import java.util.List;

import com.unimelb.swen30006.Qantas.QantasFlight;
import com.unimelb.swen30006.Qantas.QantasSearch;

public class QantasSearchAdapter implements IFlightSearchAdapter {
	private QantasSearch theQantasSearch;
	
	public QantasSearchAdapter() {
		theQantasSearch = new QantasSearch();
	}
	
	@Override
	public ArrayList<IFlightAdapter> flightSearch(FlightSearchRequest request) {
		ArrayList<QantasFlight> flightList = new ArrayList<QantasFlight>();
		List<FlightRequestInfo> requestInfoList = request.getFlightRequestListCopy();
		for(int i = 0; i < requestInfoList.size(); i++) {
			FlightRequestInfo requestInfo = requestInfoList.get(i);			
			flightList.add(new QantasFlight(requestInfo.getFrom(), requestInfo.getTo(), requestInfo.getDepartAt()));
		}
		ArrayList<IFlightAdapter> retList = new ArrayList<IFlightAdapter>();
		for(QantasFlight flight : theQantasSearch.search(flightList, request.getNumPassengers())) {
			retList.add(new QantasFlightAdapter(flight));
		}
		return retList;
	}
}