package com.unimelb.swen30006.miniexpedia;

import com.unimelb.swen30006.Virgin.VirginPassenger;
import com.unimelb.swen30006.miniexpedia.interfaceAdapter.IFlightPassengerAdapter;

public class VirginPassengerAdapter implements IFlightPassengerAdapter {
	public VirginPassenger passenger;
	public VirginPassengerAdapter(VirginPassenger passenger) {
		this.passenger = passenger;
	}
}