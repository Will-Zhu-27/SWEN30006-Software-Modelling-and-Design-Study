package com.unimelb.swen30006.miniexpedia;

import java.util.ArrayList;

import com.unimelb.swen30006.Qantas.QantasBook;
import com.unimelb.swen30006.Qantas.QantasFlight;
import com.unimelb.swen30006.Qantas.QantasPassenger;

public class QantasBookAdapter implements IFlightBookAdapter {
	public QantasBook book;
	
	public QantasBookAdapter() {
		this.book = new QantasBook();
	}
	
	@Override
	public String book(ArrayList<IFlightAdapter> flightAdapterList,
			ArrayList<IFlightPassengerAdapter> passengerAdapterList) {
		// TODO Auto-generated method stub
		ArrayList<QantasPassenger> passengerList = new ArrayList<QantasPassenger>();
		ArrayList<QantasFlight> flightList = new ArrayList<QantasFlight>();
		for(IFlightAdapter flightAdapter : flightAdapterList) {
			flightList.add(((QantasFlightAdapter)(flightAdapter)).flight);
		}
		for(IFlightPassengerAdapter passengerAdapter : passengerAdapterList) {
			passengerList.add(((QantasPassengerAdapter)(passengerAdapter)).passenger);	
		}
		return book.book(flightList, passengerList);
	}
	
}