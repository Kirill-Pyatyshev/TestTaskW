import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        String[] array = {"1,3-5", "2", "3-4"};

        Port port = new Port(array);
        System.out.println(Arrays.toString(port.getArrayOfNumbers()));// 1) вывод массива последовательностей
        System.out.println(port.getUniqueGroups());// 2) вывод всех возможных уникальных групп
    }
}