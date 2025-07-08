package mydaylydb.interfaces;

import java.util.List;
import mydaylydb.entities.ClientEntity;
import org.json.JSONArray;

public interface ClientInterfase {

    public abstract boolean Create(ClientEntity clientEntity);

    public abstract JSONArray ReadById(int id);

    public abstract boolean Update(ClientEntity projectEntity);

    public abstract boolean Delete(int Id);
    
    public abstract JSONArray SelectClientByLikeName(String name);
    
    public abstract List<ClientEntity> SelectAllClientsByCompany(int company);

    String CLIENT_CREATE = "CALL CLIENT_CREATE(?,?,?,?,?,?,?,?,?,?);";

    String READ_BY_ID = "CALL CLIENT_READ_BY_ID(?)";

    String CLIENT_UPDATE = "CALL CLIENT_UPDATE_BY_ID (?,?,?,?,?)";

    String DELETE_BY_ID = "CALL CLIENT_DELETE_BY_ID(?)";

    String CLIENT_SELECT_ALL_BY_LIKE_NAME = "CALL CLIENT_SELECT_ALL_BY_LIKE_NAME(?)";

    String CLIENT_SELECT_ALL_BY_COMPANY = "CALL PROJECT_SELECT_ALL_BY_COMPANY(?)";
    
}
