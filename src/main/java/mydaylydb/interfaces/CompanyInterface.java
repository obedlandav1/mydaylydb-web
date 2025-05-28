package mydaylydb.interfaces;

import java.util.List;
import mydaylydb.entities.CompanyEntity;

public interface CompanyInterface {

    public abstract CompanyEntity SelectCompanyByName(String name);

    public abstract List<CompanyEntity> SelectAllCompanyName();

    String SELECT_COMPANY_NAMES = "SELECT nombreCorto FROM razonSocial WHERE estado = 1";

    String SELECT_COMPANY_BY_NAME = "SELECT id, nombreCorto, nombreLargo FROM razonSocial WHERE nombreCorto=? AND estado = 1";

}
