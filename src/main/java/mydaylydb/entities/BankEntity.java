package mydaylydb.entities;

public class BankEntity {
    
    private int id;
    private String nombrecorto;
    private String nombrelargo;
    private String estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrecorto() {
        return nombrecorto;
    }

    public void setNombrecorto(String nombrecorto) {
        this.nombrecorto = nombrecorto;
    }

    public String getNombrelargo() {
        return nombrelargo;
    }

    public void setNombrelargo(String nombrelargo) {
        this.nombrelargo = nombrelargo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BankEntity() {
    }
   
    public BankEntity(int id, String nombrecorto, String nombrelargo, String estado) {
        this.id = id;
        this.nombrecorto = nombrecorto;
        this.nombrelargo = nombrelargo;
        this.estado = estado;
    }
}
