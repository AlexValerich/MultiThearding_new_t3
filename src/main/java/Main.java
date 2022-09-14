
public class Main {
    public static void main(String[] args) {

        int sizeArray = 1000;
        int sumOneStream = 0;
        int[] array = new int[sizeArray];

        for (int i = 0; i < sizeArray; i++) {
            array[i] = ((int) (Math.random() * 10));
        }
        long startOne = System.currentTimeMillis();
        for (int sum : array) {
            sumOneStream += sum;
        }
        long finishOne = System.currentTimeMillis();
        long elapsedOne = finishOne - startOne;
        System.out.println("Выполнение задачи в один поток, время: " + elapsedOne + " результат: " + sumOneStream);

        long startMulti = System.currentTimeMillis();
        ForkSum forkJoinPool = new ForkSum(array);

        System.out.println("Выполнение задачи в несколько потоков результат: " + forkJoinPool.compute());
        long finishMulti = System.currentTimeMillis();
        long elapsedMulti = finishMulti - startMulti;
        System.out.println("Выполнение задачи в несколько потоков, время: " +  elapsedMulti);
    }
}