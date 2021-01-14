import java.time.LocalDate;

public class CrispyFlour extends Material {
    private double quantity;

    public CrispyFlour() {
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, double quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public Double getAmount() {
        return quantity * cost;
    }

    @Override
    public LocalDate getExpiryDate() {
        return manufacturingDate.plusYears(1);
    }

    @Override
    public double getRealMoney() {
        if (getExpiryDate().isAfter(ManagerMaterial.today().plusMonths(4)) || getExpiryDate().isEqual(ManagerMaterial.today().plusMonths(4))) {
            return getAmount() * 0.8;
        } else if (getExpiryDate().isAfter(ManagerMaterial.today().plusMonths(2)) || getExpiryDate().isEqual(ManagerMaterial.today().plusMonths(2))) {
            return getAmount() * 0.6;
        }
        return getAmount() * 0.95;
    }

    @Override
    public String toString() {
        return "CrispyFlour { " +
                super.toString() +
                "] [quantity: " + quantity + "K.G" +
                "] }";
    }
}
