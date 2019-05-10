package com.unimelb.swen30006.miniexpedia;

import java.time.LocalDateTime;

import com.unimelb.swen30006.miniexpedia.interfaceAdapter.IFlightAdapter;
import com.unimelb.swen30006.miniexpedia.interfaceAdapter.IFlightBookAdapter;
import com.unimelb.swen30006.miniexpedia.interfaceAdapter.IFlightPassengerAdapter;
import com.unimelb.swen30006.miniexpedia.interfaceAdapter.IFlightSearchAdapter;

public class miniExpediaFactory{
	private IFlightAdapter flightAdapter = null;
	private IFlightBookAdapter flightBookAdapter = null;
	private IFlightPassengerAdapter flightPassengerAdapter = null;
	private IFlightSearchAdapter flightSearchAdapter = null;
	public IFlightSearchAdapter getFlightSearchAdapter(int i) {
		if(i == 1) {
			try {
				flightSearchAdapter = (IFlightSearchAdapter) new JetstarSearchAdapter();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (i == 2) {
			flightSearchAdapter = (IFlightSearchAdapter) new QantasSearchAdapter();
		} else if (i == 3) {
			flightSearchAdapter = (IFlightSearchAdapter) new VirginSearchAdapter();
		} else {
			flightSearchAdapter = null;
		}
		return flightSearchAdapter;
	}
	
	public IFlightBookAdapter getFlightBookAdapter(int i) {
		if(i == 1) {
			try {
				flightBookAdapter = (IFlightBookAdapter) new JetstarBookAdapter();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (i == 2) {
			flightBookAdapter = (IFlightBookAdapter) new QantasBookAdapter();
		} else if (i == 3) {
			flightBookAdapter = (IFlightBookAdapter) new VirginBookAdapter();
		} else {
			flightBookAdapter = null;
		}
		return flightBookAdapter;
	}
	
	public IFlightPassengerAdapter getFlightPassenger(int i, String firstName, String lastname, LocalDateTime dateOfBirth) {
		if(i == 1) {
			try {
				flightPassengerAdapter = (IFlightPassengerAdapter) new JetstarPassengerAdapter(firstName, lastname, dateOfBirth);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (i == 2) {
			flightPassengerAdapter = (IFlightPassengerAdapter) new QantasPassengerAdapter(firstName, lastname, dateOfBirth);
		} else if (i == 3) {
			flightPassengerAdapter = (IFlightPassengerAdapter) new VirginPassengerAdapter(firstName, lastname, dateOfBirth);
		} else {
			flightPassengerAdapter = null;
		}
		return flightPassengerAdapter;
	}
}