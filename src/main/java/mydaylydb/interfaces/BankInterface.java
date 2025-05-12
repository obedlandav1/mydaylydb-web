package mydaylydb.interfaces;

import java.util.List;
import mydaylydb.entities.BankEntity;

public interface BankInterface {

    public abstract List<BankEntity> SelectAllBankName();

    String SELECT_BANK_NAMES = "SELECT id, nombreLargo FROM bancos WHERE estado = 1";
}
