import java.util.HashMap;
import java.util.LinkedList;
public class testtest
{
    HashMap<Integer, LinkedList<Integer>> memo = new HashMap<>();
    private LinkedList<Integer> howSum(int targetSum, LinkedList<Integer> numbers)
    {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return new LinkedList<>();
        if (targetSum < 0) return null;

        for(int num : numbers)
        {
            int remainder = targetSum - num;
            LinkedList<Integer> remainderResult = howSum(remainder, numbers);
            if (remainderResult != null)
            {
                remainderResult.addLast(num);
                memo.put(targetSum, remainderResult);
                return memo.get(targetSum);
            }
        }
        memo.put(targetSum, null);
        return null;
    }

    public static void main(String...args)
    {
        testtest ob = new testtest();
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(2);  ll.add(3);
        System.out.println(ob.howSum(7,ll)); // [3, 2, 2]
        ob.memo.clear();
        ll.clear();
        ll.add(5);  ll.add(3);  ll.add(4);   ll.add(7);
        System.out.println(ob.howSum(7,ll)); // [4, 3]
        ob.memo.clear();
        ll.clear();
        ll.add(2);  ll.add(4);
        System.out.println(ob.howSum(7,ll)); // null
        ob.memo.clear();
        ll.clear();
        ll.add(2);   ll.add(3);  ll.add(5);
        System.out.println(ob.howSum(8,ll)); // [2, 2, 2, 2]
        ob.memo.clear();
        ll.clear();
        ll.add(7);  ll.add(14);
        System.out.println(ob.howSum(300,ll)); // null
    }
}
