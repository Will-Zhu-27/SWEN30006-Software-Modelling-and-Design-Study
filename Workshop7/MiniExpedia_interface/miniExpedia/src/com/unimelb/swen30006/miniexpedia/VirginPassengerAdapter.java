package com.unimelb.swen30006.miniexpedia;

import java.time.LocalDateTime;

import com.unimelb.swen30006.Virgin.VirginPassenger;
import com.unimelb.swen30006.miniexpedia.interfaceAdapter.IFlightPassengerAdapter;

public class VirginPassengerAdapter implements IFlightPassengerAdapter {
	public VirginPassenger passenger;
	public VirginPassengerAdapter(String firstName, String lastname, LocalDateTime dateOfBirth) {
		this.passenger = new VirginPassenger(firstName, lastname, dateOfBirth);
	}
}