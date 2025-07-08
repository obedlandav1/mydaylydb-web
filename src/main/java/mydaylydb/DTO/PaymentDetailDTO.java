package mydaylydb.DTO;

public class PaymentDetailDTO {

    private String numitem;
    private String header;
    private String description;
    private String amount;

    public String getNumitem() {
        return numitem;
    }

    public void getNumitem(String numitem) {
        this.numitem = numitem;
    } 
    
    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }    
}
