package com.unimelb.swen30006.miniexpedia;

import com.unimelb.swen30006.Qantas.QantasPassenger;
import com.unimelb.swen30006.miniexpedia.interfaceAdapter.IFlightPassengerAdapter;

public class QantasPassengerAdapter implements IFlightPassengerAdapter{
	public QantasPassenger passenger;
	public QantasPassengerAdapter(QantasPassenger passenger) {
		this.passenger = passenger;
	}
}