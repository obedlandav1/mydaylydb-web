package mydaylydb.entities;

public class CompanyEntity {

    private int id;
    private String nombrecorto;
    private String nombrelargo;
    private String numidentidad;
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

    public String getNumidentidad() {
        return numidentidad;
    }

    public void setNumidentidad(String numidentidad) {
        this.numidentidad = numidentidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public CompanyEntity() {
    }
    
    public CompanyEntity(String nombreCorto, String nombreLargo, String numIdentidad, String estado) {
        this.nombrecorto = nombreCorto;
        this.nombrelargo = nombreLargo;
        this.numidentidad = numIdentidad;
        this.estado = estado;
    }
}
