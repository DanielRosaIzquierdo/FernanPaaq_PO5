package models;

import data.Estado;

import java.nio.channels.UnresolvedAddressException;
import java.time.LocalDate;

public class Shipment {
    // Atributos
    private int id;
    private LocalDate createDate;
    private LocalDate expectDate;
    private LocalDate deliveryDate;
    private boolean notifications;
    private String address;
    private int postalCode;
    private String status;
    private double cost;
    private String emailUserNoRegister;
    private int idSender;
    private int idReceiver;
    private String nameUserNoRegister;
    private String city;

    // Constructor
    public Shipment(int id, User sender, User receiver, boolean notifications) {
        this.id = id;
        createDate = LocalDate.now();
        expectDate = null;
        deliveryDate = null;
        this.notifications = notifications;
        address = receiver.getAddress();
        postalCode = receiver.getPostalCode();
        status = Estado.EN_ALMACEN;
        cost = calculaCoste();
        emailUserNoRegister = "";
        idSender = sender.getId();
        idReceiver = receiver.getId();
        nameUserNoRegister = "";
        city = receiver.getCity();
    }

    public Shipment(int id, User sender, String emailUserNoRegister, String nameUserNoRegister, boolean notifications, String address, int postalCode, String city) {
        this.id = id;
        createDate = LocalDate.now();
        expectDate = null;
        deliveryDate = null;
        this.notifications = notifications;
        this.address = address;
        this.postalCode = postalCode;
        status = Estado.EN_ALMACEN;
        cost = calculaCoste();
        this.emailUserNoRegister = emailUserNoRegister;
        idSender = sender.getId();
        this.nameUserNoRegister = nameUserNoRegister;
        this.city = city;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getExpectDate() {
        return expectDate;
    }

    public void setExpectDate(LocalDate expectDate) {
        this.expectDate = expectDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public boolean isNotifications() {
        return notifications;
    }

    public void setNotifications(boolean notifications) {
        this.notifications = notifications;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getEmailUserNoRegister() {
        return emailUserNoRegister;
    }

    public void setEmailUserNoRegister(String emailUserNoRegister) {
        this.emailUserNoRegister = emailUserNoRegister;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNameUserNoRegister() {
        return nameUserNoRegister;
    }

    public void setNameUserNoRegister(String nameUserNoRegister) {
        this.nameUserNoRegister = nameUserNoRegister;
    }

    // Otros métodos
    private double calculaCoste() {
        return Math.random() * 1001;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "id=" + id + "\n" +
                ", createDate=" + createDate + "\n" +
                ", expectDate=" + expectDate + "\n" +
                ", deliveryDate=" + deliveryDate + "\n" +
                ", notifications=" + notifications + "\n" +
                ", address='" + address + '\'' + "\n" +
                ", postalCode=" + postalCode + "\n" +
                ", status='" + status + '\'' + "\n" +
                ", cost=" + cost + "\n" +
                ", emailUserNoRegister='" + emailUserNoRegister + '\'' + "\n" +
                ", idSender='" + idSender + '\'' + "\n" +
                ", nameUserNoRegister='" + nameUserNoRegister + '\'' + "\n" +
                '}' + "\n";
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public int getIdSender() {
        return idSender;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }

    public int getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(int idReceiver) {
        this.idReceiver = idReceiver;
    }
}
