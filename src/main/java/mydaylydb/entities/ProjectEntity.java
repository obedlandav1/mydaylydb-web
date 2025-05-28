package mydaylydb.entities;

public class ProjectEntity {

    private int id;
    private String razonsocial_id;
    private String nombrecorto;
    private String nombrelargo;
    private int plazoproyecto;
    private Double montoproyecto;
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

    public int getPlazoproyecto() {
        return plazoproyecto;
    }

    public void setPlazoproyecto(int plazoproyecto) {
        this.plazoproyecto = plazoproyecto;
    }

    public Double getMontoproyecto() {
        return montoproyecto;
    }

    public void setMontoproyecto(Double montoproyecto) {
        this.montoproyecto = montoproyecto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public ProjectEntity() {
    }

    public ProjectEntity(int id, String razonsocial_id, String nombrecorto, String nombrelargo, int plazoproyecto, Double montoproyecto, int estado) {
        this.id = id;
        this.razonsocial_id = razonsocial_id;
        this.nombrecorto = nombrecorto;
        this.nombrelargo = nombrelargo;
        this.plazoproyecto = plazoproyecto;
        this.montoproyecto = montoproyecto;
        this.estado = estado;
    }
}
