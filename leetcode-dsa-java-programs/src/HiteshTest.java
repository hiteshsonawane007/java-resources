import java.util.*;
import java.util.stream.Collectors;

public class HiteshTest {

    public static void main(String[] args) {
        String sentence = "dhgfsdfjhdsjfhdfjghfug";

        List<Character> lst = sentence.chars().mapToObj(e->(char)e).collect(Collectors.toList());

        Set<Character> Jset = sentence.chars().mapToObj(e->(char)e).collect(Collectors.toSet());


        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;

        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);

        int ans = 0;
        int curr = 0;

        for (int num: nums) {
            curr += num % 2;
            ans += counts.getOrDefault(curr - k, 0);
            counts.put(curr, counts.getOrDefault(curr, 0) + 1);
            System.out.println("num here is------------>"+num);
            System.out.println("curr here is------------>"+curr);
            System.out.println("ans here is------------>"+ans);
            System.out.println("counts here is------------>"+counts);
            System.out.println("==========================================================");
        }


    }
}
