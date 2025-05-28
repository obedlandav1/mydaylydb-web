package mydaylydb.interfaces;

import java.util.List;
import mydaylydb.entities.ComboEntity;

public interface ComboInterface {

    public abstract List<ComboEntity> SelectAllAccountType();

    public abstract List<ComboEntity> SelectAllCurrencyType();
    
    public abstract List<ComboEntity> SelectAllBankName();

    public abstract List<ComboEntity> SelectAllContractType();

    String SELECT_ACCOUNT_TYPE = "SELECT id, nombreLargo FROM tipoCuenta";

    String SELECT_CURRENCY_TYPE = "SELECT id, nombreLargo FROM tipoMoneda";

    String SELECT_BANK_OPTIONS = "SELECT id, nombreLargo FROM bancos";

    String SELECT_CONTRACT_TYPE = "";

    String SELECT_ORDER_TYPE = "";

    String SELECT_OPERATION_TYPE = "";

    String SELECT_DOCUMENT_TYPE = "";

    String SELECT_IDENTITY_TYPE = "SELECT id, nombreCorto FROM tipoIdentidad";

}
