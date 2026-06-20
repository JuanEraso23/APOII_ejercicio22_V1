package context;

import javax.swing.JOptionPane;

public class GestionarGerentes {
    
    //Mostrar Datos del Gerente
    public void mostrarDatosGerente(Gerente g) {
        JOptionPane.showMessageDialog(null,
                "DATOS DEL GERENTE" +
                "\n\nID Persona: " + g.getIdP() +
                "\nID Gerente: " + g.getIdG() +
                "\nNombre: " + g.getNombre() +
                "\nApellido: " + g.getApellido() +
                "\nCédula: " + g.getCedula() +
                "\nCorreo: " + g.getCorreo() +
                "\nTeléfono: " + g.getTelefono() +
                "\nDirección: " + g.getDireccion() +
                "\nCódigo gerente: " + g.getCodigoGerente() +
                "\nDepartamento: " + g.getDepartamento() +
                "\nNivel de acceso: " + g.getNivelAcceso());
    }
    
    //Mostrar Reporte General
    public void mostrarReporteGeneral(GestionarClientes gc, GestionarEmpleados ge, Gerente g) {
        JOptionPane.showMessageDialog(null,
                "REPORTE GENERAL DEL BANCO" +
                "\n\nTotal de Clientes Registrados: " + gc.getClientes().size() +
                "\nTotal de Empleados Registrados: " + ge.getEmpleados().size() +
                "\nGerente principal: " + g.getNombre() + " " + g.getApellido());
    }
}
