package JUC.ReadWriteLockTest;

//读写锁，可以并发度，效率更高
public class Test {

    public static void main(String[] args) {
        MyCatche myCatche=new MyCatche();
        for (int i = 0; i < 5; i++) {
            final int tmp=i;
            new Thread(()->{
                myCatche.addEle(String.valueOf(tmp));
            },"writeThread"+String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int tmp=i;
            new Thread(()->{
                myCatche.readEle();
            },"readThread"+String.valueOf(i)).start();
        }
    }

}
