package context;

import javax.swing.JOptionPane;

public class Banco {
    //Objetos Gestores
    private GestionarPersonas gp;
    private GestionarClientes gc;
    private GestionarEmpleados ge;
    private GestionarGerentes gg;
    
    //Usuario Gerente Principal
    private Gerente g;
    
    //Constructor Vacío
    public Banco() {
        this.gp = new GestionarPersonas();
        this.gc = new GestionarClientes();
        this.ge = new GestionarEmpleados();
        this.gg = new GestionarGerentes();
        cargarDatosIniciales();
    }
    
    //Getters y Setters
    public GestionarPersonas getGp() {
        return gp;
    }

    public void setGp(GestionarPersonas gp) {
        this.gp = gp;
    }

    public GestionarClientes getGc() {
        return gc;
    }

    public void setGc(GestionarClientes gc) {
        this.gc = gc;
    }

    public GestionarEmpleados getGe() {
        return ge;
    }

    public void setGe(GestionarEmpleados ge) {
        this.ge = ge;
    }

    public GestionarGerentes getGg() {
        return gg;
    }

    public void setGg(GestionarGerentes gg) {
        this.gg = gg;
    }

    public Gerente getGerente() {
        return g;
    }

    public void setGerente(Gerente g) {
        this.g = g;
    }
    
    //Cargar Datos Iniciales
    public void cargarDatosIniciales() {
        //Gerente por defecto
        g = new Gerente(
                1,
                "Juan",
                "Eraso",
                "1000000001",
                "gerente@banco.com",
                "1234",
                "3000000001",
                "Pasto",
                1,
                "G001",
                "Administración General",
                "Alto"
        );
        
        //Cliente por defecto
        Cliente c = new Cliente(
                2,
                "Carlos",
                "Gómez",
                "1000000002",
                "cliente@banco.com",
                "1234",
                "3000000002",
                "Pasto",
                1,
                "CTA001",
                "Ahorros",
                500000
        );
        
        //Empleado por defecto
        Empleado e = new Empleado(
                3,
                "Ana",
                "Martínez",
                "1000000003",
                "empleado@banco.com",
                "1234",
                "3000000003",
                "Pasto",
                1,
                "EMP001",
                "Asesor Bancario",
                "Atención al Cliente",
                1800000
        );
        
        gc.getClientes().add(c);
        ge.getEmpleados().add(e);
    }
    
  //Mostrar Usuarios de Prueba
    public void mostrarUsuariosPrueba() {
        JOptionPane.showMessageDialog(null,
                "USUARIOS DE PRUEBA" +
                "\n\nGERENTE" +
                "\nCorreo: gerente@banco.com" +
                "\nContraseña: 1234" +
                "\n\nEMPLEADO" +
                "\nCorreo: empleado@banco.com" +
                "\nContraseña: 1234" +
                "\n\nCLIENTE" +
                "\nCorreo: cliente@banco.com" +
                "\nContraseña: 1234");
    }
    
    //Iniciar Sistema
    public void iniciar() {
        int opcion;
        
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "BANCO APOII" +
                    "\n\n1. Iniciar Sesión" +
                    "\n2. Ver Usuarios de Prueba" +
                    "\n3. Salir" +
                    "\n\nSeleccione una opción:"));
            
            switch (opcion) {
            case 1:
                iniciarSesion();
                break;
                
            case 2:
                mostrarUsuariosPrueba();
                break;
                
            case 3:
                JOptionPane.showMessageDialog(null, "Gracias por utilizar el sistema bancario.");
                break;
                
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida.");
                break;
            }
            
        } while (opcion != 3);
    }
    
    //Iniciar Sesión
    public void iniciarSesion() {
        String correo = JOptionPane.showInputDialog("Ingrese su correo:");
        String contrasena = JOptionPane.showInputDialog("Ingrese su contraseña:");
        
        //Validar Gerente
        if (gp.validarCredenciales(g, correo, contrasena)) {
            JOptionPane.showMessageDialog(null, "Bienvenido gerente " + g.getNombre() + ".");
            menuGerente();
            return;
        }
        
        //Validar Empleados
        for (Empleado e : ge.getEmpleados()) {
            if (gp.validarCredenciales(e, correo, contrasena)) {
                JOptionPane.showMessageDialog(null, "Bienvenido empleado " + e.getNombre() + ".");
                menuEmpleado(e);
                return;
            }
        }
        
        //Validar Clientes
        for (Cliente c : gc.getClientes()) {
            if (gp.validarCredenciales(c, correo, contrasena)) {
                JOptionPane.showMessageDialog(null, "Bienvenido cliente " + c.getNombre() + ".");
                menuCliente(c);
                return;
            }
        }
        
        JOptionPane.showMessageDialog(null, "Correo o contraseña incorrectos.");
    }
    
    //Menú del Cliente
    public void menuCliente(Cliente c) {
        int opcion;
        
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "MENÚ CLIENTE" +
                    "\n\nCliente: " + c.getNombre() + " " + c.getApellido() +
                    "\n\n1. Consultar Saldo" +
                    "\n2. Depositar Dinero" +
                    "\n3. Retirar Dinero" +
                    "\n4. Ver Datos Personales" +
                    "\n5. Modificar Datos Personales" +
                    "\n6. Cerrar Sesión" +
                    "\n\nSeleccione una opción:"));
            
            switch (opcion) {
            case 1:
                gc.consultarSaldoCliente(c);
                break;
                
            case 2:
                gc.depositar(c);
                break;
                
            case 3:
                gc.retirar(c);
                break;
                
            case 4:
                gc.mostrarDatosCliente(c);
                break;
                
            case 5:
                gp.modificarDatosPersonales(c);
                break;
                
            case 6:
                JOptionPane.showMessageDialog(null, "Sesión finalizada.");
                break;
                
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida.");
                break;
            }
            
        } while (opcion != 6);
    }
    
    //Menú del Empleado
    public void menuEmpleado(Empleado e) {
        int opcion;
        
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "MENÚ EMPLEADO" +
                    "\n\nEmpleado: " + e.getNombre() + " " + e.getApellido() +
                    "\n\n1. Gestionar Clientes" +
                    "\n2. Ver Datos Personales" +
                    "\n3. Modificar Datos Personales" +
                    "\n4. Cerrar Sesión" +
                    "\n\nSeleccione una opción:"));
            
            switch (opcion) {
            case 1:
                gc.menuGestionClientes();
                break;
                
            case 2:
                ge.mostrarDatosEmpleado(e);
                break;
                
            case 3:
                gp.modificarDatosPersonales(e);
                break;
                
            case 4:
                JOptionPane.showMessageDialog(null, "Sesión finalizada.");
                break;
                
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida.");
                break;
            }
            
        } while (opcion != 4);
    }
    
    //Menú del Gerente
    public void menuGerente() {
        int opcion;
        
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "MENÚ GERENTE" +
                    "\n\nGerente: " + g.getNombre() + " " + g.getApellido() +
                    "\n\n1. Gestionar Clientes" +
                    "\n2. Gestionar Empleados" +
                    "\n3. Ver Datos Personales" +
                    "\n4. Modificar Datos Personales" +
                    "\n5. Ver Reporte General" +
                    "\n6. Cerrar Sesión" +
                    "\n\nSeleccione una opción:"));
            
            switch (opcion) {
            case 1:
                gc.menuGestionClientes();
                break;
                
            case 2:
                ge.menuGestionEmpleados();
                break;
                
            case 3:
                gg.mostrarDatosGerente(g);
                break;
                
            case 4:
                gp.modificarDatosPersonales(g);
                break;
                
            case 5:
                gg.mostrarReporteGeneral(gc, ge, g);
                break;
                
            case 6:
                JOptionPane.showMessageDialog(null, "Sesión finalizada.");
                break;
                
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida.");
                break;
            }
            
        } while (opcion != 6);
    }
}