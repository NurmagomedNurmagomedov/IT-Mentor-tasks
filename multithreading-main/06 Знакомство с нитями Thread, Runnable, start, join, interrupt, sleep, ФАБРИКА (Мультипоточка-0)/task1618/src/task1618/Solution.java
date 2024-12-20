package task1618;

/* 
Снова interrupt
Создай нить TestThread.
В методе main создай экземпляр нити, запусти, а потом прерви ее используя метод interrupt().


Requirements:
1. Класс TestThread должен быть унаследован от Thread.
2. Класс TestThread должен иметь public void метод run.
3. Метод main должен создавать объект типа TestThread.
4. Метод main должен вызывать метод start у объекта типа TestThread.
5. Метод main должен вызывать метод interrupt у объекта типа TestThread.*/

public class Solution {
    public static void main(String[] args){
        TestThread testThread = new TestThread();
        testThread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testThread.interrupt();
        //Add your code here - добавь код тут
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread{


        public void run() {
            long i=0;
            while (!this.isInterrupted()) {
                i++;
                if (i %100000 == 0) System.out.println(i);
            }
        }
    }
}