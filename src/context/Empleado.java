package context;

public class Empleado extends Persona {
    //Atributos
    private int idE;
    private String codigoEmpleado;
    private String cargo;
    private String areaTrabajo;
    private double salario;
    
    //Constructor Vacío
    public Empleado() {
        super();
    }

    //Constructor Lleno
    public Empleado(int idP, String nombre, String apellido, String cedula, String correo, String contrasena,
            String telefono, String direccion, int idE, String codigoEmpleado, String cargo, String areaTrabajo,
            double salario) {
        
        super(idP, nombre, apellido, cedula, correo, contrasena, telefono, direccion);
        this.idE = idE;
        this.codigoEmpleado = codigoEmpleado;
        this.cargo = cargo;
        this.areaTrabajo = areaTrabajo;
        this.salario = salario;
    }

    //Getters y Setters
    public int getIdE() {
        return idE;
    }

    public void setIdE(int idE) {
        this.idE = idE;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getAreaTrabajo() {
        return areaTrabajo;
    }

    public void setAreaTrabajo(String areaTrabajo) {
        this.areaTrabajo = areaTrabajo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}