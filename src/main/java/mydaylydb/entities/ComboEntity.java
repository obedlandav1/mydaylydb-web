package mydaylydb.entities;

public class ComboEntity {
    
    private int id;
    private String codigo;
    private String nombrecorto;
    private String nombrelargo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public ComboEntity() {
    }
   
    public ComboEntity(int id, String codigo, String nombrecorto, String nombrelargo) {
        this.id = id;
        this.codigo = codigo;
        this.nombrecorto = nombrecorto;
        this.nombrelargo = nombrelargo;
    }
}
