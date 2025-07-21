package mydaylydb.interfaces;

import java.util.List;
import mydaylydb.entities.MovementEntity;
import org.json.JSONArray;

public interface MovementInterface {

    public abstract boolean Create(MovementEntity movementEntityt);

    public abstract JSONArray ReadById(int id);

    public abstract boolean Update(MovementEntity movementEntityt);

    public abstract boolean Delete(int Id);

    public abstract List<MovementEntity> SelectAllMovementsByCompany(int accountid, int year, int month);

    String CREATE_MOVEMENT = "CALL MOVEMENT_CREATE(?,?,?,?,?,?,?,?,?,?,?,?,?);";

    String READ_BY_ID = "CALL MOVEMENT_READ_BY_ID(?);";

    String UPDATE_MOVEMENT = "CALL MOVEMENT_UPDATE_BY_ID(?,?,?,?,?,?,?,?,?,?,?,?,?);";

    String DELETE_BY_ID = "CALL MOVEMENT_DELETE_BY_ID(?)";

    String SELECT_ALL_MOVEMENT_BY_COMPANY = "CALL MOVEMENT_SELECT_ALL_BY_ACCOUNT(?,?,?);";
       
    //public abstract List<AccountEntity> SelectTipoCuenta();

    //public abstract List<AccountEntity> SelectTipoMoneda();

    //String SELECT_ACCOUNT_TYPE = "SELECT DISTINCT tipoCuenta FROM cuentas WHERE estado = 1";

    //String SELECT_COIN_NAMES = "SELECT DISTINCT monedaCuenta FROM cuentas WHERE estado = 1";

}
