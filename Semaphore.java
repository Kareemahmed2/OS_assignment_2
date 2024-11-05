public class Semaphore {
    protected int value;
    protected Semaphore(int value) {
        this.value = value;
    }
    public synchronized void P() {//the wait function
        value--;                  // it tells the outside cars to wait as there is no available parking spots
        if(value < 0) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
    }
    public synchronized void V() { // the notify function
        value++;
        if(value <= 0) {
            notify();
        }
    }
}
