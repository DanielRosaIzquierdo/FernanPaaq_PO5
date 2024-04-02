package models;

import java.time.LocalDate;

public class InfoShipmentDataClass {
    private int id;
    private LocalDate createDate;
    private LocalDate expectDate;
    private LocalDate deliveryDate;
    private int postalCode;
    private String status;
    private String sender;
    private String receiver;
    private String address;
    private String city;

    public InfoShipmentDataClass(int id, LocalDate createDate, LocalDate expectDate, LocalDate deliveryDate, int postalCode, String status, String sender, String receiver, String address, String city) {
        this.id = id;
        this.createDate = createDate;
        this.expectDate = expectDate;
        this.deliveryDate = deliveryDate;
        this.postalCode = postalCode;
        this.status = status;
        this.sender = sender;
        this.receiver = receiver;
        this.address = address;
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("""
                 * =============================================== *
                | Id:%46d|
                | Fecha de creación:%31s|
                | Fecha estimada:%34s|
                | Fecha de entrega:%32s|
                | Código postal:%35s|
                | Estado:%42s|
                | Remitente:%39s|
                | Destinatario:%36s|
                | Dirección:%39s|
                | Ciudad:%42s|
                * ================================================ *
                """, id, createDate, expectDate, deliveryDate, postalCode, status, sender, receiver, address, city);
    }
}
