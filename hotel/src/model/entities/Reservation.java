package model.entities;

import model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Integer roomNumber;
    private LocalDate checkin;
    private LocalDate checkout;

    public Reservation() {}

    public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) throws DomainException {
        if (!checkout.isAfter(checkin)) {
            throw new DomainException("Check-out date must be after check-in date");
        }

        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public long duration() {
        return checkout.getDayOfYear() - checkin.getDayOfYear();
    }

    public void updateDates(LocalDate checkin, LocalDate checkout) throws DomainException {
        if (checkin.isBefore(LocalDate.now()) || checkout.isBefore(LocalDate.now())) {
            throw new DomainException("Reservation dates for update must be future dates");
        }

        if (!checkout.isAfter(checkin)) {
            throw new DomainException("Check-out date must be after check-in date");
        }

        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "Reservation: Room "
                + getRoomNumber()
                + ", check-in: "
                + getCheckin().format(formatter)
                + ", check-out: "
                + getCheckout().format(formatter)
                + ", "
                + duration()
                + " nights";
    }
}
