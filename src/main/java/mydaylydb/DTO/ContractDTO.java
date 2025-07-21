package mydaylydb.DTO;

import java.util.List;

public class ContractDTO {

    private String id;
    private String project;
    private String client;
    private String typecontract;
    private String currency;
    private String description;
    private String term;
    private String payment;
    private List<PaymentDetailDTO> paydetail; // puedes guardarlo como String JSON
    private Double exonerated;
    private Double taxable;
    private Double tax;
    private Double total;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getTypecontract() {
        return typecontract;
    }

    public void setTypecontract(String typecontract) {
        this.typecontract = typecontract;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public List<PaymentDetailDTO> getPaydetail() {
        return paydetail;
    }

    public void setPaydetail(List<PaymentDetailDTO> paydetail) {
        this.paydetail = paydetail;
    }

    public Double getExonerated() {
        return exonerated;
    }

    public void setExonerated(Double exonerated) {
        this.exonerated = exonerated;
    }

    public Double getTaxable() {
        return taxable;
    }

    public void setTaxable(Double taxable) {
        this.taxable = taxable;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
