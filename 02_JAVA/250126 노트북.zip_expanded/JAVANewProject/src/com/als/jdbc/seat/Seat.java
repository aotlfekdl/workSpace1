package com.als.jdbc.seat;

public class Seat {
	private int seatNo;
	private String seatRow;
	private int seatNumber;
	private String reservation;
	public Seat(int seatNo, String seatRow, int seatNumber, String reservation) {
		super();
		this.seatNo = seatNo;
		this.seatRow = seatRow;
		this.seatNumber = seatNumber;
		this.reservation = reservation;
	}
	public Seat() {
		super();
	}
	public Seat(String seatRow, int seatNumber,String reservation) {
		super();
		this.seatRow = seatRow;
		this.seatNumber = seatNumber;
		this.reservation = reservation;
	}
	public String getReservation() {
		return reservation;
	}
	public void setReservation(String reservation) {
		this.reservation = reservation;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public String getSeatRow() {
		return seatRow;
	}
	public void setSeatRow(String seatRow) {
		this.seatRow = seatRow;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	@Override
	public String toString() {
		return "["+seatRow + seatNumber + ","+ reservation + "]";
	}


}

