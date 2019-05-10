package com.unimelb.swen30006.miniexpedia;

import java.time.LocalDateTime;

import com.unimelb.swen30006.Jetstar.JetstarPassenger;
import com.unimelb.swen30006.miniexpedia.interfaceAdapter.IFlightPassengerAdapter;

public class JetstarPassengerAdapter implements IFlightPassengerAdapter{
	public JetstarPassenger passenger;
	
	public JetstarPassengerAdapter(String firstName, String lastname, LocalDateTime dateOfBirth) {
		passenger = new JetstarPassenger(firstName, lastname, dateOfBirth);
	}
}