package context;

public class Gerente extends Persona {
    //Atributos
    private int idG;
    private String codigoGerente;
    private String departamento;
    private String nivelAcceso;
    
    //Constructor Vacío
    public Gerente() {
        super();
    }

    //Constructor Lleno
    public Gerente(int idP, String nombre, String apellido, String cedula, String correo, String contrasena,
            String telefono, String direccion, int idG, String codigoGerente, String departamento,
            String nivelAcceso) {
        
        super(idP, nombre, apellido, cedula, correo, contrasena, telefono, direccion);
        this.idG = idG;
        this.codigoGerente = codigoGerente;
        this.departamento = departamento;
        this.nivelAcceso = nivelAcceso;
    }

    //Getters y Setters
    public int getIdG() {
        return idG;
    }

    public void setIdG(int idG) {
        this.idG = idG;
    }

    public String getCodigoGerente() {
        return codigoGerente;
    }

    public void setCodigoGerente(String codigoGerente) {
        this.codigoGerente = codigoGerente;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(String nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }
}