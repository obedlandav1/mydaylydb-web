package mydaylydb.interfaces;

import java.util.List;
import mydaylydb.entities.AccountEntity;
import org.json.JSONArray;

public interface AccountInterface {

    public abstract boolean Create(AccountEntity accountEntity);

    public abstract JSONArray ReadById(int id);

    public abstract boolean Update(AccountEntity accountEntity);

    public abstract boolean Delete(int Id);

    public abstract List<AccountEntity> SelectAllAccountsByCompany(int company);

    public abstract List<AccountEntity> SelectAllAccountsDetailsByCompany(int company);

    String CREATE_ACCOUNT = "CALL ACCOUNT_CREATE(?,?,?,?,?,?,?);";

    String READ_BY_ID = "CALL ACCOUNT_READ_BY_ID(?)";

    String UPDATE_ACCOUNT = "CALL ACCOUNT_UPDATE_BY_ID (?,?,?,?,?,?)";

    String DELETE_BY_ID = "CALL ACCOUNT_DELETE_BY_ID(?)";

    String SELECT_ALL_ACCOUNTS_BY_COMPANY = "CALL ACCOUNT_SELECT_ALL_BY_COMPANY(?)";
           
    //public abstract List<AccountEntity> SelectTipoCuenta();

    //public abstract List<AccountEntity> SelectTipoMoneda();

    //String SELECT_ACCOUNT_TYPE = "SELECT DISTINCT tipoCuenta FROM cuentas WHERE estado = 1";

    //String SELECT_COIN_NAMES = "SELECT DISTINCT monedaCuenta FROM cuentas WHERE estado = 1";

}
