package mydaylydb.interfaces;

import java.util.List;
import mydaylydb.entities.AccountEntity;

public interface AccountInterface {

    public abstract boolean Create(AccountEntity accountEntity);

    public abstract AccountEntity ReadById(int id);

    public abstract boolean Update(int id);

    public abstract boolean Delete(int Id);

    public abstract List<AccountEntity> SelectTipoCuenta();

    public abstract List<AccountEntity> SelectTipoMoneda();

    public abstract List<AccountEntity> SelectAllAccount();

    String SELECT_ACCOUNT_TYPE = "SELECT DISTINCT tipoCuenta FROM cuentas WHERE estado = 1";

    String SELECT_COIN_NAMES = "SELECT DISTINCT monedaCuenta FROM cuentas WHERE estado = 1";
}
