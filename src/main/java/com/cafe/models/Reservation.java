package com.cafe.models;

import java.time.LocalDateTime;

public final class Reservation {
    private final String reservationId;
    private final Customer customer;
    private final int tableNumber;
    private final LocalDateTime reservationTime;
    private final int durationInMinutes;

    public Reservation(String reservationId, Customer customer, int tableNumber, LocalDateTime reservationTime, int durationInMinutes) {
        this.reservationId = reservationId;
        this.customer = customer;
        this.tableNumber = tableNumber;
        this.reservationTime = reservationTime;
        this.durationInMinutes = durationInMinutes;
    }

    public String getReservationId() {
        return reservationId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId + '\'' +
                ", customer=" + customer +
                ", tableNumber=" + tableNumber +
                ", reservationTime=" + reservationTime +
                ", durationInMinutes=" + durationInMinutes +
                '}';
    }
}
