package taxes;


public class UsnIncomeMinusExpensesTax extends TaxSystem {

    @Override
    public int calcTaxFor(int debit, int credit) {
        int profit = debit - credit;
        return profit > 0 ? (int) (profit * 0.15) : 0;
    }

}
