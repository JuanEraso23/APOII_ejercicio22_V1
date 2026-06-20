package context;

public class Cliente extends Persona {
    //Atributos
    private int idC;
    private String numeroCuenta;
    private String tipoCuenta;
    private double saldo;
    
    //Constructor Vacío
    public Cliente() {
        super();
    }

    // Constructor Lleno
    public Cliente(int idP, String nombre, String apellido, String cedula, String correo, String contrasena,
            String telefono, String direccion, int idC, String numeroCuenta, String tipoCuenta, double saldo) {
        
        super(idP, nombre, apellido, cedula, correo, contrasena, telefono, direccion);
        this.idC = idC;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
    }

    //Getters y Setters
    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}