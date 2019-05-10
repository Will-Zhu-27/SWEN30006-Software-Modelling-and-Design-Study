package com.unimelb.swen30006.miniexpedia;

import java.time.LocalDateTime;

import com.unimelb.swen30006.Qantas.QantasPassenger;
import com.unimelb.swen30006.miniexpedia.interfaceAdapter.IFlightPassengerAdapter;

public class QantasPassengerAdapter implements IFlightPassengerAdapter{
	public QantasPassenger passenger;
	public QantasPassengerAdapter(String firstName, String lastname, LocalDateTime dateOfBirth) {
		this.passenger = new QantasPassenger(firstName, lastname, dateOfBirth);
	}
}