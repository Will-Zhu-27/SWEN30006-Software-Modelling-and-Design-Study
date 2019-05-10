package com.unimelb.swen30006.miniexpedia;

import java.time.LocalDateTime;

public class FlightRequestInfo {
		private String from;
		private String to;
		private LocalDateTime departAt;
		public FlightRequestInfo(String from, String to, LocalDateTime departAt) {
			this.from = from;
			this.to = to;
			this.departAt = departAt;
		}
		
		public String getFrom() {
			return from;
		}
		
		public String getTo() {
			return to;
		}
		
		public LocalDateTime getDepartAt() {
			return departAt;
		}
		
		public String toString() {
			String ret = "Depart at "+ departAt.toString()+ " from " + from + " to " + to;
			return ret;
		}
	}