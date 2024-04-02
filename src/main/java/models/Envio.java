package models;

import java.time.LocalDate;

public class Envio {
    private int numeroSeguimiento;
    private String estado;
    private String localidad;
    private String provincia;
    private LocalDate fechaEnvio;
    private LocalDate fechaEsperada;
    private LocalDate fechaEntrega;
    private String destinatario;

    //Constructor
    public Envio(int numeroSeguimiento, String destinatario, String localidad, String provincia) {
        this.numeroSeguimiento = numeroSeguimiento;
        estado = "En oficina de origen";
        fechaEntrega = null;
        fechaEnvio = null;
        this.localidad = localidad;
        this.provincia = provincia;
        this.destinatario = destinatario;
    }

    //Constructor estado
    public Envio(int numeroSeguimiento, String estado, String destinatario, LocalDate fechaEnvio, String localidad, String provincia) {
        this.numeroSeguimiento = numeroSeguimiento;
        this.estado = estado;
        fechaEntrega = null;
        this.fechaEnvio = fechaEnvio;
        this.localidad = localidad;
        this.provincia = provincia;
        this.destinatario = destinatario;
    }

    public Envio(int numeroSeguimiento, String estado, String destinatario, LocalDate fechaEnvio, String localidad) {
        this.numeroSeguimiento = numeroSeguimiento;
        this.estado = estado;
        fechaEntrega = null;
        this.fechaEnvio = fechaEnvio;
        this.localidad = localidad;
        this.provincia = null;
        this.destinatario = destinatario;
    }

    //Constructor vacío
    public Envio() {
    }

    //Getters y Setters
    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getNumeroSeguimiento() {
        return numeroSeguimiento;
    }

    public void setNumeroSeguimiento(int numeroSeguimiento) {
        this.numeroSeguimiento = numeroSeguimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    //toString
    @Override
    public String toString() {
        return "----" + getNumeroSeguimiento() + " ----\n" +
                "- Estado: " + getEstado() + "\n" +
                "- Destinatario: " + getDestinatario() + "\n" +
                "- Fecha envío: " + getFechaEnvio() + "\n" +
                "- Fecha esperada: " + getFechaEnvio() + "\n" +
                "- Fecha entrega: " + ((getFechaEntrega() == null) ? "Aún no entregado" : getFechaEntrega()) + "\n";
    }


    public String pintaEnviosSinRegistro() {
        String resultado = "";
        if (getEstado().equals("En oficina de origen"))
            resultado += getNumeroSeguimiento() + " - " + getLocalidad() + "(" + getProvincia() + ") - " + getFechaEnvio() + "\n";
        return resultado;
    }

    public String pintaEnviosConRegistro() {
        String resultado = "";
        resultado += getNumeroSeguimiento() + " - " + getLocalidad() + "(" + getProvincia() + ") - " + getFechaEnvio() + "\n";
        return resultado;
    }

    public void fechaEntrega() {
        if (getEstado().equals("Entregado")) setFechaEntrega(LocalDate.now());
    }

    public String pintaEnvioTelegram() {
        return String.format("----%s ----%n" +
                        "- Estado: %s%n" +
                        "- Destinatario: %s%n",
                getNumeroSeguimiento(),
                getEstado(),
                getDestinatario());
    }
}
