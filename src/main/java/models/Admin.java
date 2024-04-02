package models;

public class Admin {
    // Atributos
    private int id;
    private String name;
    private String pass;
    private String email;


    // Constructor
    public Admin(int id, String name, String pass, String email) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.email = email;
    }


    // Getters y Setters

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

    // Otros métodos

    public boolean login(String email, String pass) {
        if (email.equals(getEmail()) && pass.equals(getPass())) return true;
        return false;
    }

    @Override
    public String toString() {
        return String.format("""
                * =============================================== *
                | Nombre:           %10s \t\t\t\t\t  |
                | Email:  %20s \t\t\t\t\t  |
                * =============================================== *""", name, email);
    }
}
