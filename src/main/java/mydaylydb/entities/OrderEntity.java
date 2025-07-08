package mydaylydb.entities;

public class OrderEntity {

    private int id;
    private String proyectos;
    private String proveedores;
    private String tipoorden;
    private String tipomoneda;
    private String descripcioncontrato;
    private int plazoorden;
    private String formapago;
    private String detallepago;
    private String consideraciones;
    private double subtotal1;
    private double tipocambio;
    private double subtotal2;
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

    public String getProveedores() {
        return proveedores;
    }

    public void setProveedores(String proveedores) {
        this.proveedores = proveedores;
    }

    public String getTipoorden() {
        return tipoorden;
    }

    public void setTipoorden(String tipoorden) {
        this.tipoorden = tipoorden;
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

    public int getPlazoorden() {
        return plazoorden;
    }

    public void setPlazoorden(int plazoorden) {
        this.plazoorden = plazoorden;
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

    public String getConsideraciones() {
        return consideraciones;
    }

    public void setConsideraciones(String consideraciones) {
        this.consideraciones = consideraciones;
    }

    public double getSubtotal1() {
        return subtotal1;
    }

    public void setSubtotal1(double subtotal1) {
        this.subtotal1 = subtotal1;
    }

    public double getTipocambio() {
        return tipocambio;
    }

    public void setTipocambio(double tipocambio) {
        this.tipocambio = tipocambio;
    }

    public double getSubtotal2() {
        return subtotal2;
    }

    public void setSubtotal2(double subtotal2) {
        this.subtotal2 = subtotal2;
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

    public OrderEntity() {
    }

    public OrderEntity(int id, String proyectos, String proveedores, String tipoorden, String tipomoneda, String descripcioncontrato, int plazoorden, String formapago, String detallepago, String consideraciones, double subtotal1, double tipocambio, double subtotal2, double exonerado, double imponible, double impuesto, double valortotal, int estado) {
        this.id = id;
        this.proyectos = proyectos;
        this.proveedores = proveedores;
        this.tipoorden = tipoorden;
        this.tipomoneda = tipomoneda;
        this.descripcioncontrato = descripcioncontrato;
        this.plazoorden = plazoorden;
        this.formapago = formapago;
        this.detallepago = detallepago;
        this.consideraciones = consideraciones;
        this.subtotal1 = subtotal1;
        this.tipocambio = tipocambio;
        this.subtotal2 = subtotal2;
        this.exonerado = exonerado;
        this.imponible = imponible;
        this.impuesto = impuesto;
        this.valortotal = valortotal;
        this.estado = estado;
    }


}
