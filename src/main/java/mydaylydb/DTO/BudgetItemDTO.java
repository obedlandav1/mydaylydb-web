package mydaylydb.DTO;

import java.util.List;

public class BudgetItemDTO {

    private String itemnum;
    private String itemdes;
    private String itemsub;
    private List<BudgetSubitemDTO> subtitems;

    public String getItemnum() {
        return itemnum;
    }

    public void setItemnum(String itemnum) {
        this.itemnum = itemnum;
    }

    public String getItemdes() {
        return itemdes;
    }

    public void setItemdes(String itemdes) {
        this.itemdes = itemdes;
    }

    public String getItemsub() {
        return itemsub;
    }

    public void setItemsub(String itemsub) {
        this.itemsub = itemsub;
    }

    public List<BudgetSubitemDTO> getSubtitems() {
        return subtitems;
    }

    public void setSubtitems(List<BudgetSubitemDTO> subtitems) {
        this.subtitems = subtitems;
    }
}
