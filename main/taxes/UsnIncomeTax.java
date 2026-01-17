package taxes;

public class UsnIncomeTax extends TaxSystem {
    @Override
    public int calcTaxFor(int debit, int credit) {
        return (int) (debit * 0.06); // 6% от доходов, не может быть отрицательным
    }
}