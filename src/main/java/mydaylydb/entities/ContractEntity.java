package mydaylydb.entities;

public class ContractEntity {

    private int id;
    private String proyectos;
    private String clientes;
    private String tipocontrato;
    private String tipomoneda;
    private String descripcioncontrato;
    private int plazocontrato;
    private String formapago;
    private String detallepago;
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

    public String getProyectos() {
        return proyectos;
    }

    public void setProyectos(String proyectos) {
        this.proyectos = proyectos;
    }

    public String getClientes() {
        return clientes;
    }

    public void setClientes(String clientes) {
        this.clientes = clientes;
    }

    public String getTipocontrato() {
        return tipocontrato;
    }

    public void setTipocontrato(String tipocontrato) {
        this.tipocontrato = tipocontrato;
    }

    public String getTipomoneda() {
        return tipomoneda;
    }

    public void setTipomoneda(String tipomoneda) {
        this.tipomoneda = tipomoneda;
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

    public String getFormapago() {
        return formapago;
    }

    public void setFormapago(String formapago) {
        this.formapago = formapago;
    }

    public String getDetallepago() {
        return detallepago;
    }

    public void setDetallepago(String detallepago) {
        this.detallepago = detallepago;
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

    public ContractEntity(int id, String proyectos_id, String clientes_id, String tipocontrato_id, String tipomoneda_id, String descripcioncontrato, int plazocontrato, String tipopagocontrato, String formapagocontrato, double exonerado, double imponible, double impuesto, double valortotal, int estado) {
        this.id = id;
        this.proyectos = proyectos_id;
        this.clientes = clientes_id;
        this.tipocontrato = tipocontrato_id;
        this.tipomoneda = tipomoneda_id;
        this.descripcioncontrato = descripcioncontrato;
        this.plazocontrato = plazocontrato;
        this.formapago = tipopagocontrato;
        this.detallepago = formapagocontrato;
        this.exonerado = exonerado;
        this.imponible = imponible;
        this.impuesto = impuesto;
        this.valortotal = valortotal;
        this.estado = estado;
    }   
}
