package mydaylydb.interfaces;

import java.util.List;
import mydaylydb.entities.ProviderEntity;
import org.json.JSONArray;

public interface ProviderInterfase {

    public abstract boolean Create(ProviderEntity providerEntity);

    public abstract JSONArray ReadById(int id);

    public abstract boolean Update(ProviderEntity providerEntity);

    public abstract boolean Delete(int Id);
    
    public abstract JSONArray SelectProviderByLikeName(String name);
    
    public abstract List<ProviderEntity> SelectAllProvider();

    String PROVIDER_CREATE = "CALL PROVIDER_CREATE(?,?,?,?,?,?,?,?,?,?,?,?);";

    String READ_BY_ID = "CALL PROVIDER_READ_BY_ID(?)";

    String PROVIDER_UPDATE = "CALL PROVIDER_UPDATE_BY_ID (?,?,?,?,?)";

    String DELETE_BY_ID = "CALL PROVIDER_DELETE_BY_ID(?)";

    String PROVIDER_SELECT_ALL_BY_LIKE_NAME = "CALL PROVIDER_SELECT_ALL_BY_LIKE_NAME(?)";

    String PROVIDER_SELECT_ALL_BY_COMPANY = "CALL PROVIDER_SELECT_ALL";
    
}


