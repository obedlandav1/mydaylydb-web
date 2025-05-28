package mydaylydb.entities;

import org.json.JSONArray;

public class ContractEntity {

    private int id;
    private int proyectos_id;
    private int tipocontrato_id;
    private int tipomoneda_id;
    private String descripcioncontrato;
    private int plazocontrato;
    private JSONArray formapagocontrato;
    private double exonerado;
    private double imponible;
    private double impuesto;
    private double valortotal;
    private int estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProyectos_id() {
        return proyectos_id;
    }

    public void setProyectos_id(int proyectos_id) {
        this.proyectos_id = proyectos_id;
    }

    public int getTipocontrato_id() {
        return tipocontrato_id;
    }

    public void setTipocontrato_id(int tipocontrato_id) {
        this.tipocontrato_id = tipocontrato_id;
    }

    public String getDescripcioncontrato() {
        return descripcioncontrato;
    }

    public void setDescripcioncontrato(String descripcioncontrato) {
        this.descripcioncontrato = descripcioncontrato;
    }

    public int getPlazocontrato() {
        return plazocontrato;
    }

    public void setPlazocontrato(int plazocontrato) {
        this.plazocontrato = plazocontrato;
    }

    public JSONArray getFormapagocontrato() {
        return formapagocontrato;
    }

    public void setFormapagocontrato(JSONArray formapagocontrato) {
        this.formapagocontrato = formapagocontrato;
    }

    public int getTipomoneda_id() {
        return tipomoneda_id;
    }

    public void setTipomoneda_id(int tipomoneda_id) {
        this.tipomoneda_id = tipomoneda_id;
    }

    public double getExonerado() {
        return exonerado;
    }

    public void setExonerado(double exonerado) {
        this.exonerado = exonerado;
    }

    public double getImponible() {
        return imponible;
    }

    public void setImponible(double imponible) {
        this.imponible = imponible;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public ContractEntity() {
    }

    public ContractEntity(int id, int proyectos_id, int tipocontrato_id, int tipomoneda_id, String descripcioncontrato, int plazocontrato, JSONArray formapagocontrato, double exonerado, double imponible, double impuesto, double valortotal, int estado) {
        this.id = id;
        this.proyectos_id = proyectos_id;
        this.tipocontrato_id = tipocontrato_id;
        this.tipomoneda_id = tipomoneda_id;
        this.descripcioncontrato = descripcioncontrato;
        this.plazocontrato = plazocontrato;
        this.formapagocontrato = formapagocontrato;
        this.exonerado = exonerado;
        this.imponible = imponible;
        this.impuesto = impuesto;
        this.valortotal = valortotal;
        this.estado = estado;
    }
}
