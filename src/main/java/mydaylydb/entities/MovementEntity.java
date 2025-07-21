package mydaylydb.entities;

public class MovementEntity {

    private int id;
    private int cuenta_id;
    private String cuenta;
    private int tipooperacion_id;
    private String tipooperacion;
    private String fechaemision;
    private String fechaoperacion;
    private String periodooperacion;
    private String numerooperacion;
    private String descripcionoperacion;
    private String beneficiariooperacion;
    private String glosaoperacion;
    private Double montooperacion1;
    private Double tipocambio;
    private Double montooperacion2;
    private int estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCuenta_id() {
        return cuenta_id;
    }

    public void setCuenta_id(int cuenta_id) {
        this.cuenta_id = cuenta_id;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public int getTipooperacion_id() {
        return tipooperacion_id;
    }

    public void setTipooperacion_id(int tipooperacion_id) {
        this.tipooperacion_id = tipooperacion_id;
    }

    public String getTipooperacion() {
        return tipooperacion;
    }

    public void setTipooperacion(String tipooperacion) {
        this.tipooperacion = tipooperacion;
    }

    public String getFechaemision() {
        return fechaemision;
    }

    public void setFechaemision(String fechaemision) {
        this.fechaemision = fechaemision;
    }

    public String getFechaoperacion() {
        return fechaoperacion;
    }

    public void setFechaoperacion(String fechaoperacion) {
        this.fechaoperacion = fechaoperacion;
    }

    public String getPeriodooperacion() {
        return periodooperacion;
    }

    public void setPeriodooperacion(String periodooperacion) {
        this.periodooperacion = periodooperacion;
    }

    public String getNumerooperacion() {
        return numerooperacion;
    }

    public void setNumerooperacion(String numerooperacion) {
        this.numerooperacion = numerooperacion;
    }

    public String getDescripcionoperacion() {
        return descripcionoperacion;
    }

    public void setDescripcionoperacion(String descripcionoperacion) {
        this.descripcionoperacion = descripcionoperacion;
    }

    public String getBeneficiariooperacion() {
        return beneficiariooperacion;
    }

    public void setBeneficiariooperacion(String beneficiariooperacion) {
        this.beneficiariooperacion = beneficiariooperacion;
    }

    public String getGlosaoperacion() {
        return glosaoperacion;
    }

    public void setGlosaoperacion(String glosaoperacion) {
        this.glosaoperacion = glosaoperacion;
    }

    public Double getMontooperacion1() {
        return montooperacion1;
    }

    public void setMontooperacion1(Double montooperacion1) {
        this.montooperacion1 = montooperacion1;
    }

    public Double getTipocambio() {
        return tipocambio;
    }

    public void setTipocambio(Double tipocambio) {
        this.tipocambio = tipocambio;
    }

    public Double getMontooperacion2() {
        return montooperacion2;
    }

    public void setMontooperacion2(Double montooperacion2) {
        this.montooperacion2 = montooperacion2;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }


}
