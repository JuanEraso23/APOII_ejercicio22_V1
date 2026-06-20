package context;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GestionarEmpleados {
    //Listas y Objetos
    private ArrayList<Empleado> empleados;
    private GestionarPersonas gp;
    
    //Constructor Vacío
    public GestionarEmpleados() {
        this.empleados = new ArrayList<Empleado>();
        this.gp = new GestionarPersonas();
    }

    //Constructor Lleno
    public GestionarEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
        this.gp = new GestionarPersonas();
    }
    
    //Getter y Setter de la Lista
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    //Registrar Empleado
    public void registrarEmpleado() {
        int idP = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de persona:"));
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido:");
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula:");
        String correo = JOptionPane.showInputDialog("Ingrese el correo:");
        String contrasena = JOptionPane.showInputDialog("Ingrese la contraseña:");
        String telefono = JOptionPane.showInputDialog("Ingrese el teléfono:");
        String direccion = JOptionPane.showInputDialog("Ingrese la dirección:");
        
        int idE = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de empleado:"));
        String codigoEmpleado = JOptionPane.showInputDialog("Ingrese el código del empleado:");
        String cargo = JOptionPane.showInputDialog("Ingrese el cargo:");
        String areaTrabajo = JOptionPane.showInputDialog("Ingrese el área de trabajo:");
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario:"));
        
        Empleado e = new Empleado(idP, nombre, apellido, cedula, correo, contrasena, telefono, direccion,
                idE, codigoEmpleado, cargo, areaTrabajo, salario);
        
        empleados.add(e);
        
        JOptionPane.showMessageDialog(null, "Empleado registrado correctamente.");
    }
    
    //Modificar Empleado
    public void modificarEmpleado() {
        if (empleados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados.");
            return;
        }
        
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del empleado que desea modificar:");
        Empleado e = getEmpleadoPorCedula(cedula);
        
        if (e == null) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún empleado con esa cédula.");
            return;
        }
        
        int opcion;
        
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "MODIFICAR EMPLEADO" +
                    "\n\nEmpleado: " + e.getNombre() + " " + e.getApellido() +
                    "\n\n1. Modificar datos personales" +
                    "\n2. Modificar código de empleado" +
                    "\n3. Modificar cargo" +
                    "\n4. Modificar área de trabajo" +
                    "\n5. Modificar salario" +
                    "\n6. Ver datos del empleado" +
                    "\n7. Volver" +
                    "\n\nSeleccione una opción:"));
            
            switch (opcion) {
            case 1:
                gp.modificarDatosPersonales(e);
                break;
                
            case 2:
                e.setCodigoEmpleado(JOptionPane.showInputDialog("Ingrese el nuevo código de empleado:"));
                JOptionPane.showMessageDialog(null, "Código de empleado actualizado correctamente.");
                break;
                
            case 3:
                e.setCargo(JOptionPane.showInputDialog("Ingrese el nuevo cargo:"));
                JOptionPane.showMessageDialog(null, "Cargo actualizado correctamente.");
                break;
                
            case 4:
                e.setAreaTrabajo(JOptionPane.showInputDialog("Ingrese la nueva área de trabajo:"));
                JOptionPane.showMessageDialog(null, "Área de trabajo actualizada correctamente.");
                break;
                
            case 5:
                double salario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo salario:"));
                
                if (salario > 0) {
                    e.setSalario(salario);
                    JOptionPane.showMessageDialog(null, "Salario actualizado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "El salario debe ser mayor que cero.");
                }
                break;
                
            case 6:
                mostrarDatosEmpleado(e);
                break;
                
            case 7:
                JOptionPane.showMessageDialog(null, "Regresando al menú anterior...");
                break;
                
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida.");
                break;
            }
            
        } while (opcion != 7);
    }
    
    //Eliminar Empleado
    public void eliminarEmpleado() {
        if (empleados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados.");
            return;
        }
        
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del empleado que desea eliminar:");
        Empleado e = getEmpleadoPorCedula(cedula);
        
        if (e == null) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún empleado con esa cédula.");
            return;
        }
        
        int confirmacion = JOptionPane.showConfirmDialog(null,
                "¿Está seguro de eliminar al empleado " + e.getNombre() + " " + e.getApellido() + "?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);
        
        if (confirmacion == JOptionPane.YES_OPTION) {
            empleados.remove(e);
            JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Eliminación cancelada.");
        }
    }
    
    // Mostrar Datos Completos del Empleado
    public void mostrarDatosEmpleado(Empleado e) {
        JOptionPane.showMessageDialog(null,
                "DATOS DEL EMPLEADO" +
                "\n\nID Persona: " + e.getIdP() +
                "\nID Empleado: " + e.getIdE() +
                "\nNombre: " + e.getNombre() +
                "\nApellido: " + e.getApellido() +
                "\nCédula: " + e.getCedula() +
                "\nCorreo: " + e.getCorreo() +
                "\nTeléfono: " + e.getTelefono() +
                "\nDirección: " + e.getDireccion() +
                "\nCódigo empleado: " + e.getCodigoEmpleado() +
                "\nCargo: " + e.getCargo() +
                "\nÁrea de trabajo: " + e.getAreaTrabajo() +
                "\nSalario: $" + e.getSalario());
    }
    
    // Buscar Empleado
    public void getEmpleado() {
        if (empleados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados.");
            return;
        }
        
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del empleado que desea buscar:");
        Empleado e = getEmpleadoPorCedula(cedula);
        
        if (e != null) {
            mostrarDatosEmpleado(e);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún empleado con esa cédula.");
        }
    }
    
    //Buscar Empleado por Cédula
    public Empleado getEmpleadoPorCedula(String cedula) {
        for (Empleado e : empleados) {
            if (e.getCedula().equals(cedula)) {
                return e;
            }
        }
        
        return null;
    }
    
    //Listar Empleados
    public void getTotalEmpleados() {
        if (empleados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados.");
            return;
        }
        
        String mensaje = "LISTA DE EMPLEADOS\n\n";
        
        for (Empleado e : empleados) {
            mensaje += "ID Empleado: " + e.getIdE() +
                    "\nNombre: " + e.getNombre() + " " + e.getApellido() +
                    "\nCédula: " + e.getCedula() +
                    "\nCorreo: " + e.getCorreo() +
                    "\nCódigo empleado: " + e.getCodigoEmpleado() +
                    "\nCargo: " + e.getCargo() +
                    "\nÁrea de trabajo: " + e.getAreaTrabajo() +
                    "\nSalario: $" + e.getSalario() +
                    "\n-----------------------------\n";
        }
        
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    //Menú General del CRUD de Empleados
    public void menuGestionEmpleados() {
        int opcion;
        
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "GESTIÓN DE EMPLEADOS" +
                    "\n\n1. Registrar empleado" +
                    "\n2. Modificar empleado" +
                    "\n3. Eliminar empleado" +
                    "\n4. Buscar empleado" +
                    "\n5. Listar empleados" +
                    "\n6. Volver" +
                    "\n\nSeleccione una opción:"));
            
            switch (opcion) {
            case 1:
                registrarEmpleado();
                break;
                
            case 2:
                modificarEmpleado();
                break;
                
            case 3:
                eliminarEmpleado();
                break;
                
            case 4:
                getEmpleado();
                break;
                
            case 5:
                getTotalEmpleados();
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