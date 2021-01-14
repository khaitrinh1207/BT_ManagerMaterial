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
        if(ManagerMaterial.today().isEqual(getExpiryDate()) && ManagerMaterial.today().isBefore(getExpiryDate())){
            return getAmount()*0.5;
        } else if (ManagerMaterial.today().isEqual(getExpiryDate().minusDays(3)) && ManagerMaterial.today().isBefore(getExpiryDate().minusDays(3))){
            return getAmount()*0.7;
        } else
            return getAmount()*0.9;
//            return getAmount()*0.9;
//        }
//        else if (ManagerMaterial.today().isEqual(getExpiryDate().minusDays(5)) && ManagerMaterial.today().isAfter(getExpiryDate().minusDays(3))) {
//            return getAmount() * 0.7;
//        } else if (ManagerMaterial.today().isEqual(getExpiryDate().minusDays(3))) {
//            return getAmount() * 0.5;
//        } else
//        return 0;
    }

    @Override
    public String toString() {
        return "Meat { " +
                super.toString() +
                "] [weight: " + weight + "K.G" +
                "] }";
    }
}
