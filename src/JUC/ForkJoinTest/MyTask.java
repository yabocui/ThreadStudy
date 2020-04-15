package JUC.ForkJoinTest;

import java.util.concurrent.RecursiveTask;

public class MyTask extends RecursiveTask<Integer> {

    private static final Integer ADJUSTVALUE = 10;

    private int begin;

    private int result;

    private int end;

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
        result=0;
    }

    @Override
    protected Integer compute() {
        System.out.println("Begin to run2...");
        if ((end-begin)<=ADJUSTVALUE){
            for (int i=begin;i<=end;i++){
                result=result+i;
            }
        }else{
            int mid=(end+begin)/2;
            MyTask task1=new MyTask(begin,mid);
            MyTask task2=new MyTask(mid,end);
            task1.fork();
            task2.fork();
            result=task1.join()+task2.join();
        }
        return result;
    }
}
