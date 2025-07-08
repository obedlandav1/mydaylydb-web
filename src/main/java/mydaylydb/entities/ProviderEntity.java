package mydaylydb.entities;

public class ProviderEntity {

    private int id;
    private String tipodocumento_id;
    private String nombreproveedor;
    private String identidadproveedor;
    private String direccionproveedor;
    private String distritoproveedor;
    private String ciudadproveedor;
    private String bancoproveedor;
    private String cuentaproveedor;
    private String cciproveedor;
    private String telefonoproveedor;
    private String correoproveedor;
    private int estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipodocumento_id() {
        return tipodocumento_id;
    }

    public void setTipodocumento_id(String tipodocumento_id) {
        this.tipodocumento_id = tipodocumento_id;
    }

    public String getNombreproveedor() {
        return nombreproveedor;
    }

    public void setNombreproveedor(String nombreproveedor) {
        this.nombreproveedor = nombreproveedor;
    }

    public String getIdentidadproveedor() {
        return identidadproveedor;
    }

    public void setIdentidadproveedor(String identidadproveedor) {
        this.identidadproveedor = identidadproveedor;
    }

    public String getDireccionproveedor() {
        return direccionproveedor;
    }

    public void setDireccionproveedor(String direccionproveedor) {
        this.direccionproveedor = direccionproveedor;
    }

    public String getDistritoproveedor() {
        return distritoproveedor;
    }

    public void setDistritoproveedor(String distritoproveedor) {
        this.distritoproveedor = distritoproveedor;
    }

    public String getCiudadproveedor() {
        return ciudadproveedor;
    }

    public void setCiudadproveedor(String ciudadproveedor) {
        this.ciudadproveedor = ciudadproveedor;
    }

    public String getBancoproveedor() {
        return bancoproveedor;
    }

    public void setBancoproveedor(String bancoproveedor) {
        this.bancoproveedor = bancoproveedor;
    }

    public String getCuentaproveedor() {
        return cuentaproveedor;
    }

    public void setCuentaproveedor(String cuentaproveedor) {
        this.cuentaproveedor = cuentaproveedor;
    }

    public String getCciproveedor() {
        return cciproveedor;
    }

    public void setCciproveedor(String cciproveedor) {
        this.cciproveedor = cciproveedor;
    }

    public String getTelefonoproveedor() {
        return telefonoproveedor;
    }

    public void setTelefonoproveedor(String telefonoproveedor) {
        this.telefonoproveedor = telefonoproveedor;
    }

    public String getCorreoproveedor() {
        return correoproveedor;
    }

    public void setCorreoproveedor(String correoproveedor) {
        this.correoproveedor = correoproveedor;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public ProviderEntity() {
    }

    public ProviderEntity(int id, String tipodocumento_id, String nombreproveedor, String identidadproveedor, String direccionproveedor, String distritoproveedor, String ciudadproveedor, String bancoproveedor, String cuentaproveedor, String cciproveedor, String telefonoproveedor, String correoproveedor, int estado) {
        this.id = id;
        this.tipodocumento_id = tipodocumento_id;
        this.nombreproveedor = nombreproveedor;
        this.identidadproveedor = identidadproveedor;
        this.direccionproveedor = direccionproveedor;
        this.distritoproveedor = distritoproveedor;
        this.ciudadproveedor = ciudadproveedor;
        this.bancoproveedor = bancoproveedor;
        this.cuentaproveedor = cuentaproveedor;
        this.cciproveedor = cciproveedor;
        this.telefonoproveedor = telefonoproveedor;
        this.correoproveedor = correoproveedor;
        this.estado = estado;
    }
}
