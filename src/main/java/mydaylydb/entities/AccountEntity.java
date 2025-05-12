package mydaylydb.entities;

public class AccountEntity {
    
    private int id;
    private int razonsocial_id;
    private int bancos_id;
    private String numerocuenta;
    private String tipocuenta;
    private String monedacuenta;
    private int estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRazonsocial_id() {
        return razonsocial_id;
    }

    public void setRazonsocial_id(int razonsocial_id) {
        this.razonsocial_id = razonsocial_id;
    }

    public int getBancos_id() {
        return bancos_id;
    }

    public void setBancos_id(int bancos_id) {
        this.bancos_id = bancos_id;
    }

    public String getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(String numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public String getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(String tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    public String getMonedacuenta() {
        return monedacuenta;
    }

    public void setMonedacuenta(String monedacuenta) {
        this.monedacuenta = monedacuenta;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public AccountEntity() {
    }

    public AccountEntity(int razonSocial_id, int bancos_id, String numeroCuenta, String tipoCuenta, String monedaCuenta, int estado) {
        this.razonsocial_id = razonSocial_id;
        this.bancos_id = bancos_id;
        this.numerocuenta = numeroCuenta;
        this.tipocuenta = tipoCuenta;
        this.monedacuenta = monedaCuenta;
        this.estado = estado;
    }
}
