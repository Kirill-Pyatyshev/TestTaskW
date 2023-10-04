import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Port {

    private final String[] array;
    private final List<List<Integer>> decryptedArray = new ArrayList<>();

    public Port(String[] array) {
        this.array = array;
    }

    public int[] getArrayOfNumbers() {
        for (String item : array) {
            decryptedArray.add(getNumbers(item));
        }
        return decryptedArray.stream().flatMapToInt(i -> i.stream().mapToInt(n -> n)).toArray();
    }

    public Set<List<Integer>> getUniqueGroups() {
        if (decryptedArray.size() < 1) {
            getArrayOfNumbers();
        }
        int length = decryptedArray.size();
        Set<List<Integer>> result = new HashSet<>();
        if (length == 0) {
            return result;
        }
        recursion(0, new ArrayList<>(), length, result);
        return result;
    }

    private List<Integer> getNumbers(String numbers) {
        ArrayList<Integer> result = new ArrayList<>();
        if (numbers.contains(",")) {
            String[] split = numbers.split(",");
            for (String s : split) {
                if (s.contains("-")) {
                    result.addAll(getSequence(s));
                } else {
                    result.add(Integer.parseInt(s));
                }
            }
        } else if (numbers.contains("-")) {
            result.addAll(getSequence(numbers));
        } else {
            result.add(Integer.parseInt(numbers));
        }
        return result;
    }

    private List<Integer> getSequence(String numbers) {
        ArrayList<Integer> result = new ArrayList<>();
        String[] split = numbers.split("-");
        int startIndex = Integer.parseInt(split[0]);
        int finishIndex = Integer.parseInt(split[1]);

        for (; startIndex <= finishIndex; startIndex++) {
            result.add(startIndex);
        }
        return result;
    }

    private void recursion(int position, List<Integer> constructor, int length, Set<List<Integer>> result) {
        if (position == length) {
            result.add(constructor);
        } else {
            List<Integer> array = decryptedArray.get(position);
            for (Integer number : array) {
                List<Integer> list = new ArrayList<>(constructor);
                list.add(number);
                recursion(position + 1, list, length, result);
            }
        }
    }

}