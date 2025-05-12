package mydaylydb.interfaces;

import java.util.List;
import mydaylydb.entities.CompanyEntity;

public interface CompanyInterface {

    public abstract int SelectIdByName(String name);

    public abstract List<CompanyEntity> SelectAllCompanyName();

    String SELECT_COMPANY_NAMES = "SELECT nombreCorto FROM razonSocial WHERE estado = 1";
    
    String SELECT_ID = "SELECT id FROM razonSocial WHERE nombreCorto = ?";
    
}
