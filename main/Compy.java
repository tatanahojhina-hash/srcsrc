import taxes.TaxSystem;

public class Compy {
    private final String title;
    private int debit;
    private int credit;
    private TaxSystem taxSystem;

    public Compy(String title, TaxSystem taxSystem) {
        this.title = title;
        this.taxSystem = taxSystem;
        this.debit = 0;
        this.credit = 0;
    }

    public void shiftMoney(int amount) {
        if (amount > 0) {
            debit += amount;
        } else if (amount < 0) {
            credit += Math.abs(amount);
        }
    }

    public void setTaxSystem(TaxSystem taxSystem) {
        this.taxSystem = taxSystem;
    }

    public void payTaxes() {
        int taxAmount = taxSystem.calcTaxFor(debit, credit);
        System.out.println("Компания " + title + " уплатила налог в размере: " + taxAmount + " руб.");
        debit = 0;
        credit = 0;
    }

    public int applyDeals(Deal[] deals) {
        if (deals != null) {
            for (Deal deal : deals) {
                this.debit += deal.debitChange;
                this.credit += deal.creditChange;
            }
        }

        int profitBeforeTax = this.debit - this.credit;
        this.payTaxes();

        return profitBeforeTax;
    }

    // Геттеры для тестирования
    public int getDebit() { return debit; }
    public int getCredit() { return credit; }
    public String getTitle() { return title; }
}
