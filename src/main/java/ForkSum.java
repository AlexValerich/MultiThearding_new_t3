import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class ForkSum extends RecursiveTask<Integer> {
    private int[] array;

    public ForkSum(int[] array) {
        this.array = array;
    }

    @Override
    protected Integer compute() {
        if (array.length <= 2) {
            return Arrays.stream(array).sum();
        }
        ForkSum firstForkSum = new ForkSum(Arrays.copyOfRange(array, 0, array.length / 2));
        ForkSum secondForkSum = new ForkSum(Arrays.copyOfRange(array, array.length / 2, array.length));

        invokeAll(firstForkSum, secondForkSum);

        Integer result = firstForkSum.join() + secondForkSum.join();

        return result;
    }
}