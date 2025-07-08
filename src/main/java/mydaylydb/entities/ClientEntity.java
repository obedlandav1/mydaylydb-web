package mydaylydb.entities;

public class ClientEntity {

    private int id;
    private String razonsocial_id;
    private String tipodocumento_id;
    private String nombrecliente;
    private String identidadcliente;
    private String direccioncliente;
    private String distritocliente;
    private String ciudadcliente;
    private String telefonocliente;
    private String correocliente;
    private int estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
  
    public String getRazonsocial_id() {
        return razonsocial_id;
    }

    public void setRazonsocial_id(String razonsocial_id) {
        this.razonsocial_id = razonsocial_id;
    }

    public String getTipodocumento_id() {
        return tipodocumento_id;
    }

    public void setTipodocumento_id(String tipodocumento_id) {
        this.tipodocumento_id = tipodocumento_id;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getIdentidadcliente() {
        return identidadcliente;
    }

    public void setIdentidadcliente(String identidadcliente) {
        this.identidadcliente = identidadcliente;
    }

    public String getDireccioncliente() {
        return direccioncliente;
    }

    public void setDireccioncliente(String direccioncliente) {
        this.direccioncliente = direccioncliente;
    }

    public String getDistritocliente() {
        return distritocliente;
    }

    public void setDistritocliente(String distritocliente) {
        this.distritocliente = distritocliente;
    }

    public String getCiudadcliente() {
        return ciudadcliente;
    }

    public void setCiudadcliente(String ciudadcliente) {
        this.ciudadcliente = ciudadcliente;
    }

    public String getTelefonocliente() {
        return telefonocliente;
    }

    public void setTelefonocliente(String telefonocliente) {
        this.telefonocliente = telefonocliente;
    }

    public String getCorreocliente() {
        return correocliente;
    }

    public void setCorreocliente(String correocliente) {
        this.correocliente = correocliente;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public ClientEntity() {
    }

    public ClientEntity(int id, String razonsocial_id, String tipodocumento_id, String nombrecliente, String identidadcliente, String direccioncliente, String distritocliente, String ciudadcliente, String telefonocliente, String correocliente, int estado) {
        this.id = id;
        this.razonsocial_id = razonsocial_id;
        this.tipodocumento_id = tipodocumento_id;
        this.nombrecliente = nombrecliente;
        this.identidadcliente = identidadcliente;
        this.direccioncliente = direccioncliente;
        this.distritocliente = distritocliente;
        this.ciudadcliente = ciudadcliente;
        this.telefonocliente = telefonocliente;
        this.correocliente = correocliente;
        this.estado = estado;
    }

}
