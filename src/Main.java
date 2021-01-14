import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ManagerMaterial manager = new ManagerMaterial();
        manager.readFile();
        while (true) {
            System.out.println("Ứng dụng quản lý nguyên liệu:");
            System.out.println("Nhập 1: Thêm nguyên liệu");
            System.out.println("Nhập 2: Hiển thị nguyên liệu");
            System.out.println("Nhập 3: Hiển thị sản phẩm theo ưu đãi");
            System.out.println("Nhập 4: Hiển thị chênh lệch chiết khấu");
            System.out.println("Nhập 5: Xóa dữ liệu");
            System.out.println("Nhập 0: Thoát");
            System.out.println();
            System.out.println("--------------------------------------------");
            int change = Integer.parseInt(sc.nextLine());
            switch (change) {
                case 1: {
                    System.out.println("Nhập a: Thêm nguyên liệu Thịt");
                    System.out.println("Nhập b: Thêm nguyên liệu Bột");
                    String type = sc.nextLine();
                    switch (type) {
                        case "a":
                            manager.addMaterial(infomation("a"));
                            manager.writeFile();
                            break;
                        case "b":
                            manager.addMaterial(infomation("b"));
                            manager.writeFile();
                            break;
                        default:
                            System.err.println("Sai cú pháp !!!");
                            break;
                    }
                    sc.nextLine();
                }
                break;
                case 2:
                    manager.displayMaterial();
                    break;
                case 3:
                    manager.sortByDiscount();
                    break;
                case 4:
                    manager.difference();
                    break;
                case 5:
                    System.out.println("Nhập vị trí muốn xóa:");
                    int index = Integer.parseInt(sc.nextLine());
                    manager.remove(index);
                    break;
                case 0: {
                    return;
                }
                default:
                    System.err.println("Sai cú pháp !");
            }
        }
    }


    public static Material infomation(String cate) {
        System.out.print("Nhập mã sản phẩm:");
        String id = sc.nextLine();
        System.out.print("Nhập tên sản phẩm:");
        String name = sc.nextLine();
        System.out.print("Nhập ngày sản xuất(dd-MM-yyyy):");
        String mfd = sc.nextLine();
        LocalDate manufacturingDate = LocalDate.parse(mfd, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.print("Nhập giá:");
        int cost = sc.nextInt();
        if (cate.equals("a")) {
            System.out.print("Nhâp trọng lượng:");
            double weight = sc.nextDouble();
            return new Meat(id, name, manufacturingDate, cost, weight);
        } else if (cate.equals("b"))
            System.out.print("Nhập định lượng:");
        double quantity = sc.nextDouble();
        return new CrispyFlour(id, name, manufacturingDate, cost, quantity);
    }
}