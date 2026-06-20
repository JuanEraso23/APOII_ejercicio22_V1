package context;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GestionarClientes {
    //Listas y Objetos
    private ArrayList<Cliente> clientes;
    private GestionarPersonas gp;
    
    //Constructor Vacío
    public GestionarClientes() {
        this.clientes = new ArrayList<Cliente>();
        this.gp = new GestionarPersonas();
    }

    // Constructor Lleno
    public GestionarClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
        this.gp = new GestionarPersonas();
    }
    
    // Getter y Setter de la Lista
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    //Registrar Cliente
    public void registrarCliente() {
        int idP = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de persona:"));
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido:");
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula:");
        String correo = JOptionPane.showInputDialog("Ingrese el correo:");
        String contrasena = JOptionPane.showInputDialog("Ingrese la contraseña:");
        String telefono = JOptionPane.showInputDialog("Ingrese el teléfono:");
        String direccion = JOptionPane.showInputDialog("Ingrese la dirección:");
        
        int idC = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de cliente:"));
        String numeroCuenta = JOptionPane.showInputDialog("Ingrese el número de cuenta:");
        String tipoCuenta = JOptionPane.showInputDialog("Ingrese el tipo de cuenta:");
        double saldo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el saldo inicial:"));
        
        Cliente c = new Cliente(idP, nombre, apellido, cedula, correo, contrasena, telefono, direccion,
                idC, numeroCuenta, tipoCuenta, saldo);
        
        clientes.add(c);
        
        JOptionPane.showMessageDialog(null, "Cliente registrado correctamente.");
    }
    
  //Modificar Cliente
    public void modificarCliente() {
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados.");
            return;
        }
        
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del cliente que desea modificar:");
        Cliente c = getClientePorCedula(cedula);
        
        if (c == null) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con esa cédula.");
            return;
        }
        
        int opcion;
        
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "MODIFICAR CLIENTE" +
                    "\n\nCliente: " + c.getNombre() + " " + c.getApellido() +
                    "\n\n1. Modificar datos personales" +
                    "\n2. Modificar número de cuenta" +
                    "\n3. Modificar tipo de cuenta" +
                    "\n4. Ver datos del cliente" +
                    "\n5. Volver" +
                    "\n\nSeleccione una opción:"));
            
            switch (opcion) {
            case 1:
                gp.modificarDatosPersonales(c);
                break;
                
            case 2:
                c.setNumeroCuenta(JOptionPane.showInputDialog("Ingrese el nuevo número de cuenta:"));
                JOptionPane.showMessageDialog(null, "Número de cuenta actualizado correctamente.");
                break;
                
            case 3:
                c.setTipoCuenta(JOptionPane.showInputDialog("Ingrese el nuevo tipo de cuenta:"));
                JOptionPane.showMessageDialog(null, "Tipo de cuenta actualizado correctamente.");
                break;
                
            case 4:
                mostrarDatosCliente(c);
                break;
                
            case 5:
                JOptionPane.showMessageDialog(null, "Regresando al menú anterior...");
                break;
                
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida.");
                break;
            }
            
        } while (opcion != 5);
    }
    
    //Eliminar cliente
    public void eliminarCliente() {
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados.");
            return;
        }
        
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del cliente que desea eliminar:");
        Cliente c = getClientePorCedula(cedula);
        
        if (c == null) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con esa cédula.");
            return;
        }
        
        int confirmacion = JOptionPane.showConfirmDialog(null,
                "¿Está seguro de eliminar al cliente " + c.getNombre() + " " + c.getApellido() + "?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);
        
        if (confirmacion == JOptionPane.YES_OPTION) {
        	clientes.remove(c);
            JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Eliminación cancelada.");
        }
    }
    
    //Mostrar Datos Completos del Cliente
    public void mostrarDatosCliente(Cliente c) {
        JOptionPane.showMessageDialog(null,
                "DATOS DEL CLIENTE" +
                "\n\nID Persona: " + c.getIdP() +
                "\nID Cliente: " + c.getIdC() +
                "\nNombre: " + c.getNombre() +
                "\nApellido: " + c.getApellido() +
                "\nCédula: " + c.getCedula() +
                "\nCorreo: " + c.getCorreo() +
                "\nTeléfono: " + c.getTelefono() +
                "\nDirección: " + c.getDireccion() +
                "\nNúmero de cuenta: " + c.getNumeroCuenta() +
                "\nTipo de cuenta: " + c.getTipoCuenta() +
                "\nSaldo: $" + c.getSaldo());
    }
    
    //Buscar Cliente
    public void getCliente() {
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados.");
            return;
        }
        
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del cliente que desea buscar:");
        Cliente c = getClientePorCedula(cedula);
        
        if (c != null) {
            mostrarDatosCliente(c);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con esa cédula.");
        }
    }
    
    //Buscar Cliente por Cédula
    public Cliente getClientePorCedula(String cedula) {
        for (Cliente c : clientes) {
            if (c.getCedula().equals(cedula)) {
                return c;
            }
        }
        
        return null;
    }
    
    //Listar Clientes
    public void getTotalClientes() {
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados.");
            return;
        }
        
        String mensaje = "LISTA DE CLIENTES\n\n";
        
        for (Cliente c : clientes) {
            mensaje += "ID Cliente: " + c.getIdC() +
                    "\nNombre: " + c.getNombre() + " " + c.getApellido() +
                    "\nCédula: " + c.getCedula() +
                    "\nCorreo: " + c.getCorreo() +
                    "\nNúmero de cuenta: " + c.getNumeroCuenta() +
                    "\nTipo de cuenta: " + c.getTipoCuenta() +
                    "\nSaldo: $" + c.getSaldo() +
                    "\n-----------------------------\n";
        }
        
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    //Operación Propia del Cliente: Consultar Saldo
    public void consultarSaldoCliente(Cliente c) {
        JOptionPane.showMessageDialog(null,
                "CONSULTA DE SALDO" +
                "\n\nCliente: " + c.getNombre() + " " + c.getApellido() +
                "\nNúmero de cuenta: " + c.getNumeroCuenta() +
                "\nSaldo actual: $" + c.getSaldo());
    }
    
    //Operación Propia del Cliente: Depositar
    public void depositar(Cliente c) {
        double monto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto que desea depositar:"));
        
        if (monto > 0) {
            c.setSaldo(c.getSaldo() + monto);
            JOptionPane.showMessageDialog(null, "Depósito realizado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "El monto debe ser mayor que cero.");
        }
    }
    
    //Operación Propia del Cliente: Retirar
    public void retirar(Cliente c) {
        double monto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto que desea retirar:"));
        
        if (monto <= 0) {
            JOptionPane.showMessageDialog(null, "El monto debe ser mayor que cero.");
        } else if (monto > c.getSaldo()) {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
        } else {
            c.setSaldo(c.getSaldo() - monto);
            JOptionPane.showMessageDialog(null, "Retiro realizado correctamente.");
        }
    }
    
    //Menú General del CRUD de Clientes
    public void menuGestionClientes() {
        int opcion;
        
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "GESTIÓN DE CLIENTES" +
                    "\n\n1. Registrar cliente" +
                    "\n2. Modificar cliente" +
                    "\n3. Eliminar cliente" +
                    "\n4. Buscar cliente" +
                    "\n5. Listar clientes" +
                    "\n6. Volver" +
                    "\n\nSeleccione una opción:"));
            
            switch (opcion) {
            case 1:
                registrarCliente();
                break;
                
            case 2:
            	modificarCliente();
                break;
                
            case 3:
            	eliminarCliente();
                break;
                
            case 4:
                getCliente();
                break;
                
            case 5:
                getTotalClientes();
                break;
                
            case 6:
                JOptionPane.showMessageDialog(null, "Regresando al menú anterior...");
                break;
                
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida.");
                break;
            }
            
        } while (opcion != 6);
    } 
}