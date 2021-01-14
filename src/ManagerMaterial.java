import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ManagerMaterial {
    Scanner sc = new Scanner(System.in);
    private List<Material> materialList;
    public static final String FILE_NAME = "material.dat";

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

    public void sortByDiscount(){
        Collections.sort(materialList,((o1, o2) -> {
            if (o1.getRealMoney()>o2.getRealMoney())
                return 1;
            if (o1.getRealMoney()<o2.getRealMoney())
                return -1;
            else
                return 0;
        }));
        displayMaterial();
    }

    public void writeFile(){
        try{
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(materialList);
            oos.close();
            fos.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void readFile(){
        try{
            FileInputStream fis = new FileInputStream(FILE_NAME);
            ObjectInputStream oos = new ObjectInputStream(fis);
            materialList = (List<Material>) oos.readObject();
        }catch (Exception e){
            System.out.println(e);
        }
        displayMaterial();
    }

}
