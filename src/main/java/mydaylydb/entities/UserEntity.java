package mydaylydb.entities;

public class UserEntity {
    
    private int id;
    private String tipoidentidad_id;
    private String nombreusuario;
    private String apellidousuario;
    private String identidadusuario;
    private String passwordusuario;
    private int estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
    public String getTipoIdentidad_id() {
        return tipoidentidad_id;
    }

    public void setTipoIdentidad_id(String tipoIdentidad_id) {
        this.tipoidentidad_id = tipoIdentidad_id;
    }

    public String getNombreUsuario() {
        return nombreusuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreusuario = nombreUsuario;
    }

    public String getApellidousuario() {
        return apellidousuario;
    }

    public void setApellidousuario(String apellidousuario) {
        this.apellidousuario = apellidousuario;
    }

    public String getIdentidadusuario() {
        return identidadusuario;
    }

    public void setIdentidadusuario(String identidadusuario) {
        this.identidadusuario = identidadusuario;
    }

    public String getPasswordusuario() {
        return passwordusuario;
    }

    public void setPasswordusuario(String passwordusuario) {
        this.passwordusuario = passwordusuario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public UserEntity() {
    }

    public UserEntity(String tipoIdentidad_id, String nombreUsuario, String apellidoUsuario, String identidadUsuario, String passwordUsuario, int estado) {
        this.tipoidentidad_id = tipoIdentidad_id;
        this.nombreusuario = nombreUsuario;
        this.apellidousuario = apellidoUsuario;
        this.identidadusuario = identidadUsuario;
        this.passwordusuario = passwordUsuario;
        this.estado = estado;
    }   
}
