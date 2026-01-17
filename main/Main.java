import taxes.UsnIncomeMinusExpensesTax;
import taxes.UsnIncomeTax;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Тестирование основной задачи ===\n");

        // Тест 1: УСН "Доходы"
        Compy compy1 = new Compy("ООО \"Ромашка\"", new UsnIncomeTax());
        compy1.shiftMoney(100000);
        compy1.shiftMoney(-30000);
        compy1.payTaxes();

        System.out.println();

        // Тест 2: УСН "Доходы минус расходы"
        Compy compy2 = new Compy("ООО \"Солнце\"", new UsnIncomeMinusExpensesTax());
        compy2.shiftMoney(150000);
        compy2.shiftMoney(-80000);
        compy2.payTaxes();

        System.out.println();

        // Тест 3: Смена системы налогообложения
        Compy compy3 = new Compy("ООО \"Ветер\"", new UsnIncomeTax());
        compy3.shiftMoney(200000);
        compy3.shiftMoney(-50000);
        compy3.setTaxSystem(new UsnIncomeMinusExpensesTax());
        compy3.payTaxes();

        System.out.println("\n=== Тестирование Задания 2 (необязательное) ===\n");

        // Тест 4: Применение сделок
        Compy compy4 = new Compy("ООО \"Звезда\"", new UsnIncomeMinusExpensesTax());

        Deal[] deals = {
            new Sale("Лампа", 5000),
            new Expenditure("Кабель", 1200),
            new Sale("Телевизор", 15000),
            new Expenditure("Доска", 800)
        };

        int differenceBeforeTax = compy4.applyDeals(deals);

        System.out.println("\nРазница доходов и расходов до уплаты налогов: " + differenceBeforeTax + " руб.");
        System.out.println("Текущие доходы: " + compy4.getDebit() + " руб.");
        System.out.println("Текущие расходы: " + compy4.getCredit() + " руб.");

        System.out.println("\n=== Дополнительные тесты ===\n");

        // Тест 5: Отрицательная прибыль
        Compy compy5 = new Compy("ООО \"Луна\"", new UsnIncomeMinusExpensesTax());
        compy5.shiftMoney(50000);
        compy5.shiftMoney(-100000);
        compy5.payTaxes();

        System.out.println();

        // Тест 6: Пустые сделки
        Compy compy6 = new Compy("ООО \"Марс\"", new UsnIncomeTax());
        int result = compy6.applyDeals(null);
        System.out.println("Результат пустых сделок: " + result + " руб.");
    }
}