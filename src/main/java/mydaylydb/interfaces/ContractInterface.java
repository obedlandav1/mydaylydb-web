package mydaylydb.interfaces;

import java.util.List;
import mydaylydb.entities.ContractEntity;
import org.json.JSONArray;

public interface ContractInterface {

    public abstract boolean Create(ContractEntity contractEntity);

    public abstract JSONArray ReadById(int id);

    public abstract boolean Update(ContractEntity contractEntity);

    public abstract boolean Delete(int Id);

    public abstract List<ContractEntity> SelectAllContractsByProject(int projectid);
    
    String CONTRACT_CREATE = "CALL CONTRACT_CREATE(?,?,?,?,?,?,?,?,?,?,?,?,?);";

    String READ_BY_ID = "CALL CONTRACT_READ_BY_ID(?)";

    String CONTRACT_UPDATE = "CALL CONTRACT_UPDATE_BY_ID (?,?,?,?,?,?,?,?,?,?,?,?)";

    String DELETE_BY_ID = "CALL CONTRACT_DELETE_BY_ID(?)";

    String CONTRACT_SELECT_ALL_BY_PROJECT = "CALL CONTRACT_SELECT_ALL_BY_PROJECT(?)";
}
