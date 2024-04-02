package models;

import data.Estado;

import java.util.ArrayList;
import java.util.Date;

public class User {
    // Atributos
    private int id;
    private String name;
    private String surname;
    private String email;
    private String pass;
    private int phone;
    private String street;
    private int num;
    private String city;
    private String state;
    private int postalCode;
    private ArrayList<Shipment> shipments;

    // Constructor
    public User(int id, String name, String surname, String email, String pass, int phone, String street, int num, String city, String state, int postalCode) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.pass = pass;
        this.phone = phone;
        this.street = street;
        this.num = num;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        shipments = new ArrayList<>();
    }


    // Getters y Setters


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public ArrayList<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(ArrayList<Shipment> shipments) {
        this.shipments = shipments;
    }

    // Otros métodos

    // Este metodo comprueba si el email y contraseña pasados por el usuario corresponden con el objeto,
    // si son iguales devuelve true y si no, devuelve false
    public boolean login(String email, String pass) {
        if (email.equals(getEmail()) && pass.equals(getPass())) return true;
        return false;
    }

    public int numDeliveriesPendingToDeliver() {
        int cont = 0;
        for (Shipment s :
                shipments) {
            if (!s.getStatus().equals(Estado.ENTREGADO)) cont++;
        }
        return cont;
    }

    public void addShipment(Shipment shipment) {
        shipments.add(shipment);
    }

    @Override
    public String toString() {
        return String.format("""
                * =============================================== *
                | Nombre:           %10s \t\t\t\t\t  |
                | Apellidos:        %10s \t\t\t\t\t  |
                | Email:  %20s \t\t\t\t\t  |
                | Telefono:     %14d \t\t\t\t\t  |
                | Estado:           %10s \t\t\t\t\t  |
                | Ciudad:           %10s \t\t\t\t\t  |
                | Codigo Postal:   %11d \t\t\t\t\t  |
                | Calle:  %20s \t\t\t\t\t  |
                | Numero:       %14d \t\t\t\t\t  |
                * =============================================== *""", name, surname, email, phone, state, city, postalCode, street, num);
    }

    public String pintaDatosAdmin(){
        return String.format("""
                * =============================================== *
                | Id:     %20d \t\t\t\t\t  |
                | Nombre:           %10s \t\t\t\t\t  |
                | Apellidos:        %10s \t\t\t\t\t  |
                | Email:  %20s \t\t\t\t\t  |
                | Contraseña:       %10s \t\t\t\t\t  |
                | Telefono:     %14d \t\t\t\t\t  |
                | Estado:           %10s \t\t\t\t\t  |
                | Ciudad:           %10s \t\t\t\t\t  |
                | Codigo Postal:   %11d \t\t\t\t\t  |
                | Calle:  %20s \t\t\t\t\t  |
                | Numero:       %14d \t\t\t\t\t  |
                * =============================================== *""", id, name, surname, email, pass, phone, state, city, postalCode, street, num);    }

    public String getAddress() {
        return street + ", " + num;
    }
}
