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
        if (today.isBefore(getExpiryDate())&&(
                today.isAfter(getExpiryDate().minusMonths(2)) ||
                        today.isEqual(getExpiryDate().minusMonths(2)))){
            System.out.println("Giảm 40%");
            return getAmount()*0.6;
        } else if(today.isBefore(getExpiryDate().minusMonths(2)) &&
                (today.isAfter(getExpiryDate().minusMonths(4))||
                        today.isEqual(getExpiryDate().minusMonths(4)))){
            System.out.println("Giảm 20%");
            return getAmount()*0.8;
        } else if(today.isBefore(getExpiryDate().minusMonths(4))&&
                (today.isEqual(getManufacturingDate())||
                        today.isAfter(getManufacturingDate())
                )){
            System.out.println("Giảm 5%");
            return getAmount()*0.95;
        } else {
            System.out.println("Dữ liệu lỗi");
        }
        return 0;
    }

    @Override
    public String toString() {
        return "CrispyFlour { " +
                super.toString() +
                "] [quantity: " + quantity + "K.G" +
                "] }";
    }
}
