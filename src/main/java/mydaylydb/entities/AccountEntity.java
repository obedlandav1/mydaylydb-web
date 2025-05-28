package mydaylydb.entities;

public class AccountEntity {

    private int id;
    private String razonsocial_id;
    private String bancos_id;
    private String tipocuenta_id;
    private String tipomoneda_id;
    private String numerocuenta;
    private String numerointerbancario;
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

    public String getBancos_id() {
        return bancos_id;
    }

    public void setBancos_id(String bancos_id) {
        this.bancos_id = bancos_id;
    }

    public String getTipocuenta_id() {
        return tipocuenta_id;
    }

    public void setTipocuenta_id(String tipocuenta_id) {
        this.tipocuenta_id = tipocuenta_id;
    }

    public String getTipomoneda_id() {
        return tipomoneda_id;
    }

    public void setTipomoneda_id(String tipomoneda_id) {
        this.tipomoneda_id = tipomoneda_id;
    }

    public String getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(String numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public String getNumerointerbancario() {
        return numerointerbancario;
    }

    public void setNumerointerbancario(String numerointerbancario) {
        this.numerointerbancario = numerointerbancario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public AccountEntity() {
    }

    public AccountEntity(int id, String razonsocial_id, String bancos_id, String tipocuenta_id, String tipomoneda_id, String numerocuenta, String numerointerbancario, int estado) {
        this.id = id;
        this.razonsocial_id = razonsocial_id;
        this.bancos_id = bancos_id;
        this.tipocuenta_id = tipocuenta_id;
        this.tipomoneda_id = tipomoneda_id;
        this.numerocuenta = numerocuenta;
        this.numerointerbancario = numerointerbancario;
        this.estado = estado;
    }
}
