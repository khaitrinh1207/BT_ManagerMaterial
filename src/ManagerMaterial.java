import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerMaterial {
    Scanner sc = new Scanner(System.in);
    private List<Material> materialList;

    public ManagerMaterial() {
        materialList = new ArrayList<>();
    }

    public void addMaterial(Material material){
        materialList.add(material);
    }

    public void displayMaterial(){
        for (Material material: materialList) {
            System.out.println(material);
        }
    }

    public static LocalDate today(){
        LocalDate td = LocalDate.now();
        return td;
    }
}
