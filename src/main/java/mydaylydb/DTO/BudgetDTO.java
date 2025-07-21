package mydaylydb.DTO;

import java.util.List;

public class BudgetDTO {
    private String budgettittle;
    private String budgetbillable;
    private List<BudgetItemDTO> budgetitems;

    public String getBudgettittle() {
        return budgettittle;
    }

    public void setBudgettittle(String budgettittle) {
        this.budgettittle = budgettittle;
    }

    public String getBudgetbillable() {
        return budgetbillable;
    }

    public void setBudgetbillable(String budgetbillable) {
        this.budgetbillable = budgetbillable;
    }

    public List<BudgetItemDTO> getBudgetitems() {
        return budgetitems;
    }

    public void setBudgetitems(List<BudgetItemDTO> budgetitems) {
        this.budgetitems = budgetitems;
    }
}
