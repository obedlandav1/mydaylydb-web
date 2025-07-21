package mydaylydb.DTO;

import java.util.List;

public class OrderDTO {

    private String id;
    private String project;
    private String provider;
    private String dateorder;
    private String typeorder;
    private String description;
    private String term;
    private String currency;
    private String payment;
    private List<BudgetDTO> budgetbody;
    private List<PaymentDetailDTO> paymentdetail;
    private List<ConsiderationDTO> genconsider;
    private List<ConsiderationDTO> speconsider;
    private String subtotal1;
    private String exchange;
    private String subtotal2;
    private Double exonerated;
    private Double taxable;
    private Double tax;
    private Double total;
    private String letters;

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

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getDateorder() {
        return dateorder;
    }

    public void setDateorder(String dateorder) {
        this.dateorder = dateorder;
    }

    public String getTypeorder() {
        return typeorder;
    }

    public void setTypeorder(String typeorder) {
        this.typeorder = typeorder;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<BudgetDTO> getBudgetbody() {
        return budgetbody;
    }

    public void setBudgetbody(List<BudgetDTO> budgetbody) {
        this.budgetbody = budgetbody;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public List<PaymentDetailDTO> getPaymentdetail() {
        return paymentdetail;
    }

    public void setPaymentdetail(List<PaymentDetailDTO> paymentdetail) {
        this.paymentdetail = paymentdetail;
    }

    public List<ConsiderationDTO> getGenconsider() {
        return genconsider;
    }

    public void setGenconsider(List<ConsiderationDTO> genconsider) {
        this.genconsider = genconsider;
    }

    public List<ConsiderationDTO> getSpeconsider() {
        return speconsider;
    }

    public void setSpeconsider(List<ConsiderationDTO> speconsider) {
        this.speconsider = speconsider;
    }

    public String getSubtotal1() {
        return subtotal1;
    }

    public void setSubtotal1(String subtotal1) {
        this.subtotal1 = subtotal1;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getSubtotal2() {
        return subtotal2;
    }

    public void setSubtotal2(String subtotal2) {
        this.subtotal2 = subtotal2;
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

    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }
    
    
}
