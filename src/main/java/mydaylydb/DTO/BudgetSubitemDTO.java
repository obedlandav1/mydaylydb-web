package mydaylydb.DTO;

public class BudgetSubitemDTO {

    private String subitem;
    private String subdescription;
    private String subunit;
    private String subquantity;
    private String subprice;
    private String subtotal;

    public String getSubitem() {
        return subitem;
    }

    public void setSubitem(String subitem) {
        this.subitem = subitem;
    }

    public String getSubdescription() {
        return subdescription;
    }

    public void setSubdescription(String subdescription) {
        this.subdescription = subdescription;
    }

    public String getSubprice() {
        return subprice;
    }

    public void setSubprice(String subprice) {
        this.subprice = subprice;
    }

    public String getSubquantity() {
        return subquantity;
    }

    public void setSubquantity(String subquantity) {
        this.subquantity = subquantity;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getSubunit() {
        return subunit;
    }

    public void setSubunit(String subunit) {
        this.subunit = subunit;
    }

}
