package mydaylydb.interfaces;

import java.util.List;
import mydaylydb.entities.ComboEntity;
import org.json.JSONArray;

public interface ComboInterface {

    public abstract List<ComboEntity> SelectAllAccountsType();

    public abstract List<ComboEntity> SelectAllCurrenciesType();

    public abstract List<ComboEntity> SelectAllContractsType();
    
    public abstract List<ComboEntity> SelectAllOperationsType();

    public abstract List<ComboEntity> SelectAllBanksName();

    public abstract JSONArray SelectAllBankName();

    public abstract JSONArray SelectAllIdentificationType();

    String SELECT_ACCOUNT_TYPE = "SELECT id, nombreLargo FROM tipoCuenta";

    String SELECT_CURRENCY_TYPE = "SELECT id, nombreLargo FROM tipoMoneda";

    String SELECT_BANK_OPTIONS = "SELECT id, nombreLargo FROM bancos";

    String SELECT_CONTRACT_TYPE = "SELECT id, nombreCorto, nombreLargo FROM tipoContrato";

    String SELECT_IDENTIFICATION_TYPE = "SELECT id, nombreLargo FROM tipoIdentidad";

    String SELECT_ORDER_TYPE = "";

    String SELECT_OPERATION_TYPE = "SELECT id, nombreLargo FROM tipoOperacion";

    String SELECT_DOCUMENT_TYPE = "";

    String SELECT_IDENTITY_TYPE = "SELECT id, nombreCorto FROM tipoIdentidad";

    //public abstract JSONArray SelectAllIdentificationType();
    
    //String SELECT_CONTRACT_ID = "SELECT id, nombreCorto FROM tipoContrato WHERE nombreCorto=?";

}
