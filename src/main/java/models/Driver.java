package models;

import comunicaciones.Telegram;
import data.Estado;

import java.util.ArrayList;

public class Driver {
    // Atributos
    private int id;
    private String name;
    private String pass;
    private String email;
    private ArrayList<Integer> deliveryZones;
    private ArrayList<Shipment> shipments;


    // Constructor

    public Driver(int id, String name, String pass, String email, int deliveryZone) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.email = email;
        deliveryZones = new ArrayList<>();
        shipments = new ArrayList<>();
        deliveryZones.add(deliveryZone);
    }

    // Getters y Setters
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public ArrayList<Integer> getDeliveryZones() {
        return deliveryZones;
    }

    public void setDeliveryZones(ArrayList<Integer> deliveryZones) {
        this.deliveryZones = deliveryZones;
    }

    public ArrayList<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(ArrayList<Shipment> shipments) {
        this.shipments = shipments;
    }

    // Otros métodos
    public boolean login(String email, String pass) {
        if (email.equals(getEmail()) && pass.equals(getPass())) return true;
        return false;
    }

    public int numShipmentsPending() {
        int cont = 0;
        for (Shipment s :
                shipments) {
            if (!s.getStatus().equals(Estado.ENTREGADO)) cont++;
        }
        return cont;
    }

    public void addShipments(Shipment shipment) {
        shipments.add(shipment);
        Telegram.enviaMensajeTelegram("Se te asigno un paquete " + name);
    }

    @Override
    public String toString() {
        return String.format("""
                * =============================================== *
                | Nombre:           %10s \t\t\t\t\t  |
                | Email:  %20s \t\t\t\t\t  |
                * =============================================== *""", name, email);
    }

    public String pintaDatosAdmin() {
        return String.format("""
                * =============================================== *
                | Id:     %20d \t\t\t\t\t  |
                | Nombre:           %10s \t\t\t\t\t  |
                | Email:  %20s \t\t\t\t\t  |
                | Contraseña:       %10s \t\t\t\t\t  |
                * =============================================== *""",id, name, email, pass);
    }

    public String pintaZonasEnvio() {
        String resultado = "";
        for (Integer d :
                getDeliveryZones()) {
            resultado += d + "\n";
        }
        return resultado;
    }

    public boolean envioExiste(int id) {
        for (Shipment s :
                shipments) {
            if (id == s.getId()) return true;
        }
        return false;
    }
}
