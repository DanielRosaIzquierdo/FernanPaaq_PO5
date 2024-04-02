package models;

import comunicaciones.Comunicaciones;
import data.Estado;
import data.PlantillasEmail;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


public class AppController {
    // Atributos
    private ArrayList<User> users;
    private ArrayList<Driver> drivers;
    private ArrayList<Admin> admins;
    private ArrayList<Shipment> shipmentsToAssign;
    private ArrayList<Shipment> shipmentsToNoRegisterUsers;

    // Constructor

    public AppController() {
        users = new ArrayList<>();
        drivers = new ArrayList<>();
        admins = new ArrayList<>();
        shipmentsToAssign = new ArrayList<>();
        shipmentsToNoRegisterUsers = new ArrayList<>();
    }

    // Getters y Setters

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(ArrayList<Driver> drivers) {
        this.drivers = drivers;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<Admin> admins) {
        this.admins = admins;
    }

    public ArrayList<Shipment> getShipmentsToAssign() {
        return shipmentsToAssign;
    }

    public void setShipmentsToAssign(ArrayList<Shipment> shipmentsToAssign) {
        this.shipmentsToAssign = shipmentsToAssign;
    }

    public ArrayList<Shipment> getShipmentsToNoRegisterUsers() {
        return shipmentsToNoRegisterUsers;
    }

    public void setShipmentsToNoRegisterUsers(ArrayList<Shipment> shipmentsToNoRegisterUsers) {
        this.shipmentsToNoRegisterUsers = shipmentsToNoRegisterUsers;
    }

    // Otros métodos

    public void mock() {
        users.add(new User(123, "Pepe", "López", "pepe@dev.com", "123", 600000000,
                "Av Madrid", 1, "Martos", "Andalucía", 23600));
        users.add(new User(125, "Adrian", "Marchal", "javimasus@gmail.com", "123", 600000000,
                "Av Madrid", 1, "Martos", "Andalucía", 23700));
        users.add(new User(124, "Miguel", "López", "miguel@dev.com", "123", 600000001,
                "Av Madrid", 1, "Jaén", "Andalucía", 23700));

        drivers.add(new Driver(456, "Paco", "123", "paco@driver.com", 23700));

        admins.add(new Admin(789, "admin", "123", "admin@admin.com"));

        Shipment shipment = addShipment(123, 124, false);
        Shipment shipment4 = addShipment(123, 125, true);

        // Poner 2 correos reales
        Shipment shipment2 = addShipmentToNoRegisterUsers(123, "javimasus@gmail.com", "Francisco", false, 13000, "Av Cádiz", "Cádiz");
        //Shipment shipment3 = addShipmentToNoRegisterUsers(123, "prueba", "prueba", false, 23, "Av Prueba", "Jaén");
    }


    // Este método busca un usuario por su id, nos devuelve el objeto usuario si lo encuentra, si no, devuelve null
    public User searchUserById(int id) {
        for (User u :
                users) {
            if (u.getId() == id) return u;
        }
        return null;
    }

    // Este método busca un usuario por su email, nos devuelve el objeto usuario si lo encuentra, si no, devuelve null
    public User searchUserByEmail(String email) {
        for (User u :
                users) {
            if (u.getEmail().equalsIgnoreCase(email)) return u;
        }
        return null;
    }

    // Este método busca un conductor por su id, nos devuelve el objeto usuario si lo encuentra, si no, devuelve null
    public Driver searchDriverById(int id) {
        for (Driver d :
                drivers) {
            if (d.getId() == id) return d;
        }
        return null;
    }

    // Este método busca un conductor por su email, nos devuelve el objeto usuario si lo encuentra, si no, devuelve null
    public Driver searchDriverByEmail(String email) {
        for (Driver d :
                drivers) {
            if (d.getEmail().equals(email)) return d;
        }
        return null;
    }

    // Este método añade un nuevo usuario
    public boolean addUser(String name, String surname, String email, int phone, String pass, String street,
                           int num, String city, String state, int postalCode) {
        if (searchUserByEmail(email) != null) return false;
        users.add(new User(uniqueUserId(), name, surname, email, pass, phone, street, num, city, state, postalCode));
        return true;
    }

    // Crea un id de usuario único
    private int uniqueUserId() {
        int id;
        do {
            id = (int) (Math.random() * 100000);
        } while (searchUserById(id) != null);
        return id;
    }

    // Crea un id de conductor único
    private int uniqueDriverId() {
        int id;
        do {
            id = (int) (Math.random() * 100000);
        } while (searchDriverById(id) != null);
        return id;
    }

    // Busca un envío según su id
    public Shipment searchShipmentById(int id) {
        for (Shipment s :
                shipmentsToAssign) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public Shipment searchShipmentByIdToNoRegisterUsers(int id) {
        for (Shipment s :
                shipmentsToNoRegisterUsers) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public Shipment searchShipmentByIdGlobal(int id){
        Shipment s;
        s = searchShipmentById(id);
        if (s != null) return s;
        s = searchShipmentByIdToNoRegisterUsers(id);
        if (s != null) return s;

        for (Driver d:
        drivers){
            for (Shipment shipment:
            d.getShipments()){
                if (shipment.getId() == id) return shipment;
            }
        }
        return null;
    }

    // Crea un id único de envío
    private int uniqueShipmentId() {
        int id;
        do {
            id = (int) (Math.random() * 100000);
        } while (searchShipmentById(id) != null);
        return id;
    }

    // Este método añade un nuevo conductor
    public boolean addDriver(String name, String email, String pass, int deliveryZone) {
        if (searchDriverByEmail(email) != null) return false;
        drivers.add(new Driver(uniqueDriverId(), name, pass, email, deliveryZone));
        return true;
    }

    // Busca un envío de usuario no registrado según su id
    public Shipment searchShipmentByIdNoLogin(int id) {
        for (Shipment s :
                shipmentsToAssign) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    // Este método permite logearse, recibe un email y contraseña,
    // comprueba todos los objetos de las listas de las diferentes clases
    // devuelve el objeto con el que se ha logeado y si no lo encuentra devuelve null
    public Object login(String email, String pass) {
        for (User u :
                users) {
            if (u.login(email, pass)) return u;
        }

        for (Driver d :
                drivers) {
            if (d.login(email, pass)) return d;
        }

        for (Admin a :
                admins) {
            if (a.login(email, pass)) return a;
        }
        return null;
    }

    // Este método busca un conductor por su teléfono, nos devuelve el objeto usuario si lo encuentra, si no, devuelve null
    public User searchUserByPhone(int phone) {
        for (User u :
                users) {
            if (u.getPhone() == phone) return u;
        }
        return null;
    }


    public Driver searchBestDriverByPostalCode(int postalCode) {
        for (Driver d :
                drivers) {
            for (Integer postalCodeDriver :
                    d.getDeliveryZones()) {
                if (postalCode == postalCodeDriver) return d;
            }
        }
        return null;
    }

    public Shipment addShipment(int idUser, int idReceiver, boolean notifications) {
        Shipment shipment = new Shipment(uniqueShipmentId(), searchUserById(idUser), searchUserById(idReceiver),
                notifications);

        User userSender = searchUserById(idUser);
        User userReceiver = searchUserById(idReceiver);
        Driver driver = searchBestDriverByPostalCode(userReceiver.getPostalCode());

        if (driver == null) {
            shipmentsToAssign.add(shipment);
            userReceiver.addShipment(shipment);
            userSender.addShipment(shipment);
            shipment.setExpectDate(shipment.getCreateDate().plusDays(4));
            sendMailNewEnvio(shipment);
        } else {
            driver.addShipments(shipment);
            userReceiver.addShipment(shipment);
            userSender.addShipment(shipment);
            shipment.setExpectDate(shipment.getCreateDate().plusDays(2));
            sendMailNewEnvio(shipment);
        }
        return shipment;
    }

    public Shipment addShipmentToNoRegisterUsers(int idUser, String email, String name, boolean notifications, int postalCode, String address, String city) {
        Shipment shipment = new Shipment(uniqueShipmentId(), searchUserById(idUser), email, name,
                notifications, address, postalCode, city);

        User userSender = searchUserById(idUser);
        Driver driver = searchBestDriverByPostalCode(postalCode);

        if (driver == null) {
            shipmentsToAssign.add(shipment);
            userSender.addShipment(shipment);
            shipmentsToNoRegisterUsers.add(shipment);
            shipment.setExpectDate(shipment.getCreateDate().plusDays(4));
            sendMailNewEnvioNoRegister(shipment,email,name,city);
        } else {
            driver.addShipments(shipment);
            userSender.addShipment(shipment);
            shipmentsToNoRegisterUsers.add(shipment);
            shipment.setExpectDate(shipment.getCreateDate().plusDays(2));
            sendMailNewEnvioNoRegister(shipment,email,name,city);
        }
        return shipment;
    }

    private void sendMailNewEnvioNoRegister(Shipment shipment, String email, String name, String city) {
        Envio e = new Envio(shipment.getId(),shipment.getStatus(),name,shipment.getCreateDate(),city);
        Comunicaciones.enviarMensaje(email, "Entrega de paquete en curso", PlantillasEmail.plantillaEmailPaquete(name,e));
    }

    public Admin searchAdminByEmail(String email) {
        for (Admin a :
                admins) {
            if (a.getEmail().equals(email)) return a;
        }
        return null;
    }

    public int numUsers() {
        return users.size();
    }

    public int numDrivers() {
        return drivers.size();
    }

    public int numShipmentsPending() {
        int cont = 0;
        for (Driver d :
                drivers) {
            for (Shipment s :
                    d.getShipments()) {
                if (!s.getStatus().equals(Estado.ENTREGADO)) cont++;
            }
        }
        return cont;
    }

    public int numShipmentsNoDriver() {
        return shipmentsToAssign.size();
    }

    public int numShipmentsUserNoRegister() {
        int cont = 0;
        for (Shipment s :
                shipmentsToNoRegisterUsers) {
            if (!s.getStatus().equals(Estado.ENTREGADO)) cont++;
        }
        return cont;
    }

    public double mediaDays() {
        int contEnvios = 0;
        long dias = 0;
        double media;
        for (Driver d :
                drivers) {
            for (Shipment s :
                    d.getShipments()) {
                if (s.getStatus().equals(Estado.ENTREGADO)) {
                    dias += ChronoUnit.DAYS.between(s.getCreateDate(), s.getDeliveryDate());
                    contEnvios++;
                }
            }
        }

        if (contEnvios != 0) {
            media = (double) (dias / contEnvios);
            return media;
        } else return -1;
    }

    public String pintaEnviosUsuarios() {
        String resultado = "";
        for (User u :
                users) {
            for (Shipment s :
                    u.getShipments()) {
                resultado += s;
            }
        }
        return resultado;
    }

    public boolean modificaDatos(int op, String dato, User user) {
        if (op > 10) return false;
        if (op == 1) user.setName(dato);
        if (op == 2) user.setSurname(dato);
        if (op == 3) user.setEmail(dato);
        if (op == 4) user.setPass(dato);
        if (op == 5) user.setPhone(Integer.parseInt(dato));
        if (op == 6) user.setStreet(dato);
        if (op == 7) user.setNum(Integer.parseInt(dato));
        if (op == 8) user.setCity(dato);
        if (op == 9) user.setState(dato);
        if (op == 10) user.setPostalCode(Integer.parseInt(dato));
        return true;
    }

    public void modificaDatosEnvios(User user, int op, String newAddress) {
        user.getShipments().get((op - 1)).setAddress(newAddress);
    }

    public String pintaEnviosUsuariosAddress(User user) {
        String resultado = "";
        int cont = 1;
        for (Shipment s :
                user.getShipments()) {
            resultado += cont + ". " + s.getAddress() + "\n";
            cont++;
        }
        return resultado;
    }

    public boolean modificaDatosDriver(int op, String dato, Driver driver) {
        if (op > 3) return false;
        if (op == 1) driver.setName(dato);
        if (op == 2) driver.setPass(dato);
        if (op == 3) driver.setEmail(dato);
        return true;
    }

    public boolean modificaDatosAdmin(int op, String dato, Admin admin) {
        if (op > 3) return false;
        if (op == 1) admin.setName(dato);
        if (op == 2) admin.setPass(dato);
        if (op == 3) admin.setEmail(dato);
        return true;
    }

    public String pintaEnviosDriverNoEntregados(Driver driver) {
        String resultado = "";
        for (Shipment s :
                driver.getShipments()) {
            if (!s.getStatus().equals(Estado.ENTREGADO)) {
                if (s.getEmailUserNoRegister().equals("")) {
                    InfoShipmentDataClass dataClass = new InfoShipmentDataClass(s.getId(), s.getCreateDate(), s.getExpectDate(),
                            s.getDeliveryDate(), s.getPostalCode(), s.getStatus(), searchUserById(s.getIdSender()).getName(),
                            searchUserById(s.getIdReceiver()).getName(), s.getAddress(), s.getCity());
                    resultado += dataClass + "\n";
                } else {
                    InfoShipmentDataClass dataClass = new InfoShipmentDataClass(s.getId(), s.getCreateDate(), s.getExpectDate(),
                            s.getDeliveryDate(), s.getPostalCode(), s.getStatus(), searchUserById(s.getIdSender()).getName(),
                            s.getEmailUserNoRegister(), s.getAddress(), s.getCity());
                    resultado += dataClass + "\n";
                }
            }
        }
        return resultado;
    }

    public String pintaEnviosLista(Driver driver) {
        String resultado = "";
        int cont = 1;
        for (Shipment s :
                driver.getShipments()) {
            if (!s.getStatus().equals(Estado.ENTREGADO)) {
                resultado += cont + ". " + s.getId() + "\n";
                cont++;
            }
        }
        return resultado;
    }

    public boolean modificaEstadoEnvios(Driver driver, int id, String estado) {
        if (estado.equals("") || !driver.envioExiste(id)) return false;
        for (Shipment s :
                driver.getShipments()) {
            if (s.getId() == id){
                s.setStatus(estado);
                if (s.isNotifications())sendMail(s);
                return true;
            }

        }
        return false;
    }

    private void sendMail(Shipment s) {
        User u = searchUserById(s.getIdReceiver());
        Envio e = new Envio(s.getId(),s.getStatus(),u.getName(),s.getCreateDate(),u.getCity(),u.getState());
        Comunicaciones.enviarMensaje(u.getEmail(), "Cambio de estado del envío", PlantillasEmail.plantillaEmailPaquete(u.getName(),e));
    }
    private void sendMailNewEnvio(Shipment s) {
        User u = searchUserById(s.getIdReceiver());
        Envio e = new Envio(s.getId(),s.getStatus(),u.getName(),s.getCreateDate(),u.getCity(),u.getState());
        Comunicaciones.enviarMensaje(u.getEmail(), "Entrega de paquete en curso", PlantillasEmail.plantillaEmailPaquete(u.getName(),e));
    }



    public boolean entregaEnvio(Driver driver, int id, String estado) {
        if (estado.isEmpty() || !driver.envioExiste(id)) return false;
        for (Shipment s :
                driver.getShipments()) {
            if (s.getId() == id) {
                s.setStatus(estado);
                s.setDeliveryDate(LocalDate.now());
                sendMail(s);
                return true;
            }
        }
        return false;
    }

    public String historicoPaquetes(Driver driver) {
        String resultado = "";
        for (Shipment s :
                driver.getShipments()) {
            if (s.getStatus().equals(Estado.ENTREGADO)) {
                if (s.getEmailUserNoRegister().equals("")) {
                    InfoShipmentDataClass dataClass = new InfoShipmentDataClass(s.getId(), s.getCreateDate(), s.getExpectDate(),
                            s.getDeliveryDate(), s.getPostalCode(), s.getStatus(), searchUserById(s.getIdSender()).getName(),
                            searchUserById(s.getIdReceiver()).getName(), s.getAddress(), s.getCity());
                    resultado += dataClass + "\n";
                } else {
                    InfoShipmentDataClass dataClass = new InfoShipmentDataClass(s.getId(), s.getCreateDate(), s.getExpectDate(),
                            s.getDeliveryDate(), s.getPostalCode(), s.getStatus(), searchUserById(s.getIdSender()).getName(),
                            s.getEmailUserNoRegister(), s.getAddress(), s.getCity());
                    resultado += dataClass + "\n";
                }
            }
        }
        return resultado;
    }

    public boolean addZonaEntrega(Driver driver, int zona) {
        for (Integer z :
                driver.getDeliveryZones()) {
            if (z == zona) return false;
        }

        driver.getDeliveryZones().add(zona);
        return true;
    }

    public String pintaEnviosPorAsignar() {
        String resultado = "";
        int cont = 1;
        for (Shipment s :
                shipmentsToAssign) {
            resultado += cont + ". " + s.getId() + "\n";
            cont++;
        }

        return resultado;
    }

    public String pintaConductores() {
        String resultado = "";
        int cont = 1;
        for (Driver d :
                drivers) {
            resultado += cont + ". " + d.getName() + "\n";
            cont++;
        }

        return resultado;
    }

    public boolean asignaEnvioConductor(int opEnvio, int opDriver) {
        if ((opEnvio - 1) < shipmentsToAssign.size() && (opDriver - 1) < drivers.size()) {
            drivers.get(opDriver - 1).getShipments().add(shipmentsToAssign.get(opEnvio - 1));
            shipmentsToAssign.remove(opEnvio - 1);
            return true;
        }
        return false;
    }

    public String resumenUsers() {
        String resultado = "";
        for (User u :
                users) {
            resultado += u.pintaDatosAdmin() + "\n";
        }
        return resultado;
    }

    public String resumenDrivers() {
        String resultado = "";
        for (Driver d :
                drivers) {
            resultado += d.pintaDatosAdmin() + "\n";
        }
        return resultado;
    }

    public String pintaEnviosSinAsignar() {
        String resultado = "";

        if (shipmentsToAssign.isEmpty()) resultado = "No hay envíos";
        else {
            for (Shipment s :
                    shipmentsToAssign) {
                if (s.getEmailUserNoRegister().equals("")) {
                    InfoShipmentDataClass dataClass = new InfoShipmentDataClass(s.getId(), s.getCreateDate(), s.getExpectDate(),
                            s.getDeliveryDate(), s.getPostalCode(), s.getStatus(), searchUserById(s.getIdSender()).getName(),
                            searchUserById(s.getIdReceiver()).getName(), s.getAddress(), s.getCity());
                    resultado += dataClass + "\n";
                } else {
                    InfoShipmentDataClass dataClass = new InfoShipmentDataClass(s.getId(), s.getCreateDate(), s.getExpectDate(),
                            s.getDeliveryDate(), s.getPostalCode(), s.getStatus(), searchUserById(s.getIdSender()).getName(),
                            s.getEmailUserNoRegister(), s.getAddress(), s.getCity());
                    resultado += dataClass + "\n";
                }
            }
        }
        return resultado;
    }

    public String enviosSender(User user) {
        String resultado = "";
        for (Shipment s :
                user.getShipments()) {
            if (s.getEmailUserNoRegister().equals("") && user.getId() == s.getIdSender()) {
                InfoShipmentDataClass dataClass = new InfoShipmentDataClass(s.getId(), s.getCreateDate(), s.getExpectDate(),
                        s.getDeliveryDate(), s.getPostalCode(), s.getStatus(), searchUserById(s.getIdSender()).getName(),
                        searchUserById(s.getIdReceiver()).getName(), s.getAddress(), s.getCity());
                resultado += dataClass + "\n";
            } else if (user.getId() == s.getIdSender()) {
                InfoShipmentDataClass dataClass = new InfoShipmentDataClass(s.getId(), s.getCreateDate(), s.getExpectDate(),
                        s.getDeliveryDate(), s.getPostalCode(), s.getStatus(), searchUserById(s.getIdSender()).getName(),
                        s.getEmailUserNoRegister(), s.getAddress(), s.getCity());
                resultado += dataClass + "\n";
            }
        }
        return resultado;
    }

    public String enviosReceiver(User user) {
        String resultado = "";
        for (Shipment s :
                user.getShipments()) {
            if (s.getEmailUserNoRegister().equals("") && user.getId() == s.getIdReceiver()) {
                InfoShipmentDataClass dataClass = new InfoShipmentDataClass(s.getId(), s.getCreateDate(), s.getExpectDate(),
                        s.getDeliveryDate(), s.getPostalCode(), s.getStatus(), searchUserById(s.getIdSender()).getName(),
                        searchUserById(s.getIdReceiver()).getName(), s.getAddress(), s.getCity());
                resultado += dataClass + "\n";
            } else if (user.getId() == s.getIdReceiver()) {
                InfoShipmentDataClass dataClass = new InfoShipmentDataClass(s.getId(), s.getCreateDate(), s.getExpectDate(),
                        s.getDeliveryDate(), s.getPostalCode(), s.getStatus(), searchUserById(s.getIdSender()).getName(),
                        s.getEmailUserNoRegister(), s.getAddress(), s.getCity());
                resultado += dataClass + "\n";
            }
        }
        return resultado;
    }
}
