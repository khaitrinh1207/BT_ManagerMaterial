import java.time.LocalDate;

public class Meat extends Material {
    private double weight;

    public Meat() {
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public Double getAmount() {
        return cost * weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return manufacturingDate.plusDays(7);
    }

    @Override
    public double getRealMoney() {
        if (today.isBefore(getExpiryDate())&&(
                today.isAfter(getExpiryDate().minusDays(3)) ||
                        today.isEqual(getExpiryDate().minusDays(3)))){
            System.out.println("Giảm 50%");
            return getAmount()*0.5;
        } else if(today.isBefore(getExpiryDate().minusDays(3)) &&
                (today.isAfter(getExpiryDate().minusDays(5))||
                        today.isEqual(getExpiryDate().minusDays(5)))){
            System.out.println("Giảm 30%");
            return getAmount()*0.7;
        } else if(today.isBefore(getExpiryDate().minusDays(5))&&
                (today.isEqual(getManufacturingDate())||
                        today.isAfter(getManufacturingDate())
                )){
            System.out.println("Giảm 10%");
            return getAmount()*0.9;
        } else {
            System.out.println("Dữ liệu lỗi");
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Meat { " +
                super.toString() +
                "] [weight: " + weight + "K.G" +
                "] }";
    }
}
