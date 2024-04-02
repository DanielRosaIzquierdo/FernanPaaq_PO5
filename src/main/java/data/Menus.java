package data;

public class Menus {
    // Menús
    public static final String LOGO = "    ________________  _   _____    _   ______  ___    ___   ____ \n" +
            "   / ____/ ____/ __ \\/ | / /   |  / | / / __ \\/   |  /   | / __ \\\n" +
            "  / /_  / __/ / /_/ /  |/ / /| | /  |/ / /_/ / /| | / /| |/ / / /\n" +
            " / __/ / /___/ _, _/ /|  / ___ |/ /|  / ____/ ___ |/ ___ / /_/ / \n" +
            "/_/   /_____/_/ |_/_/ |_/_/  |_/_/ |_/_/   /_/  |_/_/  |_\\___\\_\\ \n" +
            "                                                                 ";
    public static final String LOGIN_MENU = """           
             * ====================================================================================== *
             |         __  __                        _        _       _      _      \s                 |
             |        |  \\/  |                      | |      (_)     (_)    (_)     \s                 |
             |        | \\  / | ___ _ __  _   _    __| | ___   _ _ __  _  ___ _  ___ \s                 |
             |        | |\\/| |/ _ \\ '_ \\| | | |  / _` |/ _ \\ | | '_ \\| |/ __| |/ _ \\\s                 |
             |        | |  | |  __/ | | | |_| | | (_| |  __/ | | | | | | (__| | (_) |                 |
             |        |_|  |_|\\___|_| |_|\\__,_|  \\__,_|\\___| |_|_| |_|_|\\___|_|\\___/\s                 |
             |                                                                      \s                 |
             |                                                                      \s                 |                     
             | \t\t 1. Login                                                                        |
             | \t\t 2. Registro                                                                     |
             | \t\t 3. Sigue un envio con el numero de seguimiento                                  |
             * ====================================================================================== *
          
              Introduce la opcion deseada:""";

    public static String userMenu(String name, int shipmentsNumber) {
        return String.format("""
                * =============================================================================================== *
                |   \t\t\t ____ _____ ______ _   ___      ________ _   _ _____ _____   ____ \s\t\t\t      |
                |   \t\t\t|  _ \\_   _|  ____| \\ | \\ \\    / /  ____| \\ | |_   _|  __ \\ / __ \\\s \t\t\t  |
                |   \t\t\t| |_) || | | |__  |  \\| |\\ \\  / /| |__  |  \\| | | | | |  | | |  | |  \t\t\t  |
                |   \t\t\t|  _ < | | |  __| | . ` | \\ \\/ / |  __| | . ` | | | | |  | | |  | |  \t\t\t  |
                |   \t\t\t| |_) || |_| |____| |\\  |  \\  /  | |____| |\\  |_| |_| |__| | |__| |  \t\t\t  |
                |   \t\t\t|____/_____|______|_| \\_|   \\/   |______|_| \\_|_____|_____/ \\____/\s  \t\t\t  |
                |                                                                     \s  \t\t\t   \t\t\t  |
                |                                                                     \s  \t\t\t   \t\t\t  |
                |=================================================================================================|
                |                                                                                                 |
                |   \t\t\t  \t\t\t   %20S         \t\t\t   \t\t\t   \t\t\t  |
                |   \t\t\t\t\t\t\tTIENES:%3d ENVÍOS PENDIENTES DE ENTREGA \t\t\t\t\t\t  |
                |                                                                                                 |
                |                                                                                                 |                                                                                              
                |   \t\t\tMENU DE OPERACIONES:        \t\t\t\t\t\t\t\t\t\t\t\t\t  |
                |   \t\t\t1. Realizar un envio        \t\t\t\t\t\t\t\t\t\t\t\t\t  |
                |   \t\t\t2. Muestra informacion sobre los envios que me han realizado        \t\t\t  |
                |   \t\t\t3. Modificar mis datos de entrega para un envio        \t\t\t\t\t\t\t  |
                |   \t\t\t4. Muestra informacion de los envios que yo he realizado        \t\t\t\t  |
                |   \t\t\t5. Ver mi perfil        \t\t\t\t\t\t\t\t\t\t\t\t\t\t  |
                |   \t\t\t6. Modificar mis datos     \t\t\t\t\t\t\t\t\t\t\t\t\t\t  |
                |   \t\t\t7. Cerrar sesion        \t\t\t\t\t\t\t\t\t\t\t\t\t\t  |
                * =============================================================================================== *
                
                 Introduce la opcion deseada:""", name, shipmentsNumber);
    }

    public static String driverMenu(String name, int shipmentsNumber) {
        return String.format("""
                * =============================================================================================== *
                |   \t\t\t ____ _____ ______ _   ___      ________ _   _ _____ _____   ____ \s\t\t\t      |
                |   \t\t\t|  _ \\_   _|  ____| \\ | \\ \\    / /  ____| \\ | |_   _|  __ \\ / __ \\\s \t\t\t  |
                |   \t\t\t| |_) || | | |__  |  \\| |\\ \\  / /| |__  |  \\| | | | | |  | | |  | |  \t\t\t  |
                |   \t\t\t|  _ < | | |  __| | . ` | \\ \\/ / |  __| | . ` | | | | |  | | |  | |  \t\t\t  |
                |   \t\t\t| |_) || |_| |____| |\\  |  \\  /  | |____| |\\  |_| |_| |__| | |__| |  \t\t\t  |
                |   \t\t\t|____/_____|______|_| \\_|   \\/   |______|_| \\_|_____|_____/ \\____/\s  \t\t\t  |
                |                                                                     \s  \t\t\t   \t\t\t  |
                |                                                                     \s  \t\t\t   \t\t\t  |
                |=================================================================================================|
                |                                                                                                 |
                |   \t\t\t  \t\t\t   %20S         \t\t\t   \t\t\t   \t\t\t  |
                |   \t\t\t\t\t\tTIENES %3d PAQUETES PENDIENTES DE ENTREGA        \t\t\t\t\t  |
                |                                                                                                 |
                |                                                                                                 |                                                                                              
                |   \t\t\tMENU DE OPERACIONES:        \t\t\t\t\t\t\t\t\t\t\t\t\t  |
                |   \t\t\t1. Ver la información de los envíos que debo entregar        \t\t\t\t\t  |
                |   \t\t\t2. Cambia el estado de un envío        \t\t\t\t\t\t\t\t\t\t\t  |
                |   \t\t\t3. Ver el histórico de mis paquetes entregados\t\t\t\t\t\t\t\t\t  |
                |   \t\t\t4. Añade una zona de entrega a mi perfil        \t\t\t\t\t\t\t\t  |
                |   \t\t\t5. Ver mi perfil        \t\t\t\t\t\t\t\t\t\t\t\t\t\t  |
                |   \t\t\t6. Modificar mis datos     \t\t\t\t\t\t\t\t\t\t\t\t\t\t  |
                |   \t\t\t7. Cerrar sesion        \t\t\t\t\t\t\t\t\t\t\t\t\t\t  |
                * =============================================================================================== *
                
                 Introduce la opcion deseada:""", name, shipmentsNumber);
    }

    public static final String adminMenu(String name, int numUser, int numDrivers, int numShipmentNoDeliver,
                                         int numShipmentNoDriver, int numShipmentUserNoRegister, double mediaDays) {

        return String.format("""
                * =============================================================================================== *
                |   \t\t\t ____ _____ ______ _   ___      ________ _   _ _____ _____   ____ \s\t\t\t      |
                |   \t\t\t|  _ \\_   _|  ____| \\ | \\ \\    / /  ____| \\ | |_   _|  __ \\ / __ \\\s \t\t\t  |
                |   \t\t\t| |_) || | | |__  |  \\| |\\ \\  / /| |__  |  \\| | | | | |  | | |  | |  \t\t\t  |
                |   \t\t\t|  _ < | | |  __| | . ` | \\ \\/ / |  __| | . ` | | | | |  | | |  | |  \t\t\t  |
                |   \t\t\t| |_) || |_| |____| |\\  |  \\  /  | |____| |\\  |_| |_| |__| | |__| |  \t\t\t  |
                |   \t\t\t|____/_____|______|_| \\_|   \\/   |______|_| \\_|_____|_____/ \\____/\s  \t\t\t  |
                |                                                                     \s  \t\t\t   \t\t\t  |
                |                                                                     \s  \t\t\t   \t\t\t  |
                |=================================================================================================|
                |                                                                                                 |
                |   \t\t\t   %20S USTED ES ADMINISTRADOR        \t\t\t   \t\t\t   \t  |
                |                                                                                                 |
                |=================================================================================================|
                |   \t\t\tESTADISTICAS DE LA APP:        \t\t\t\t\t\t\t\t\t\t\t\t\t  |
                |   \t\t\tNUMERO DE USUARIOS:                                %10d                     |
                |   \t\t\tNUMERO DE CONDUCTORES:                             %10d                     | 
                |   \t\t\tNUMERO DE ENVIOS PENDIENTE DE ENTREGA:             %10d                     |
                |   \t\t\tNUMERO DE ENVIOS SIN CONDUCTOR:                    %10d                     |
                |   \t\t\tNUMERO DE ENVIOS A USUARIOS NO REGISTRADOS:        %10d                     |
                |   \t\t\tPROMEDIO DE DIAS QUE TARDAMOS EN ENTRGAR UN ENVIO: %10f                     |
                |=================================================================================================|
                |                                                                                                 |
                |                                                                                                 |                                                                                              
                |   \t\t\tMENU DE OPERACIONES:        \t\t\t\t\t\t\t\t\t\t\t\t\t  |
                |   \t\t\t1. Ver los envios sin asignar        \t\t\t\t\t\t\t\t\t\t\t  |
                |   \t\t\t2. Asignar un envio a un conductor        \t\t\t\t\t\t\t\t\t\t  |
                |   \t\t\t3. Ver un resumen de los usuarios registrados        \t\t\t\t\t\t\t  |
                |   \t\t\t4. Ver un resumen de los conductores registrados        \t\t\t\t\t\t  |
                |   \t\t\t5. Ver mi perfil        \t\t\t\t\t\t\t\t\t\t\t\t\t\t  |
                |   \t\t\t6. Modificar mis datos     \t\t\t\t\t\t\t\t\t\t\t\t\t\t  |
                |   \t\t\t7. Añadir un conductor     \t\t\t\t\t\t\t\t\t\t\t\t\t\t  |
                |   \t\t\t8. Cerrar sesion        \t\t\t\t\t\t\t\t\t\t\t\t\t\t  |
                * =============================================================================================== *
                
                 Introduce la opcion deseada:""", name, numUser, numDrivers, numShipmentNoDeliver, numShipmentNoDriver, numShipmentUserNoRegister, mediaDays);
    }
}
