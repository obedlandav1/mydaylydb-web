package mydaylydb.interfaces;

import java.util.List;
import mydaylydb.entities.ProjectEntity;
import org.json.JSONArray;

public interface ProjectInterface {

    public abstract boolean Create(ProjectEntity projectEntity);

    public abstract JSONArray ReadById(int id);

    public abstract boolean Update(ProjectEntity projectEntity);

    public abstract boolean Delete(int Id);

    public abstract List<ProjectEntity> SelectAllProjectsByCompany(int company);

    String PROJECT_CREATE = "CALL PROJECT_CREATE(?,?,?,?,?,?);";

    String READ_BY_ID = "CALL PROJECT_READ_BY_ID(?)";

    String PROJECT_UPDATE = "CALL PROJECT_UPDATE_BY_ID (?,?,?,?,?)";

    String DELETE_BY_ID = "CALL PROJECT_DELETE_BY_ID(?)";

    String PROJECT_SELECT_ALL_BY_COMPANY = "CALL PROJECT_SELECT_ALL_BY_COMPANY(?)";
}
