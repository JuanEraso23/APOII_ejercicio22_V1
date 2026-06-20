package context;

import javax.swing.JOptionPane;

public class GestionarPersonas {
    
    //Modificar Datos Personales
    public void modificarDatosPersonales(Persona p) {
        int opcion;
        
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "MODIFICAR DATOS PERSONALES" +
                    "\n\n1. Nombre" +
                    "\n2. Apellido" +
                    "\n3. Cédula" +
                    "\n4. Correo" +
                    "\n5. Contraseña" +
                    "\n6. Teléfono" +
                    "\n7. Dirección" +
                    "\n8. Volver" +
                    "\n\nSeleccione una opción:"));
            
            switch (opcion) {
            case 1:
                p.setNombre(JOptionPane.showInputDialog("Ingrese el nuevo nombre:"));
                break;
                
            case 2:
                p.setApellido(JOptionPane.showInputDialog("Ingrese el nuevo apellido:"));
                break;
                
            case 3:
                p.setCedula(JOptionPane.showInputDialog("Ingrese la nueva cédula:"));
                break;
                
            case 4:
                p.setCorreo(JOptionPane.showInputDialog("Ingrese el nuevo correo:"));
                break;
                
            case 5:
                p.setContrasena(JOptionPane.showInputDialog("Ingrese la nueva contraseña:"));
                break;
                
            case 6:
                p.setTelefono(JOptionPane.showInputDialog("Ingrese el nuevo teléfono:"));
                break;
                
            case 7:
                p.setDireccion(JOptionPane.showInputDialog("Ingrese la nueva dirección:"));
                break;
                
            case 8:
                JOptionPane.showMessageDialog(null, "Regresando al menú anterior...");
                break;
                
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida.");
                break;
            }
            
        } while (opcion != 8);
    }
    
    //Validar Credenciales
    public boolean validarCredenciales(Persona p, String correo, String contrasena) {
        return p.getCorreo().equals(correo) && p.getContrasena().equals(contrasena);
    }
}