package threadTest;

public class LifeOff implements Runnable {

  protected int      countDown = 10;
  private static int taskCount = 10;
  private final int  id        = taskCount++;

  public LifeOff() {
  }

  LifeOff(int countDown) {
    this.countDown = countDown;
  }

  public String status() {
    return "#" + id + "(" + (countDown > 0 ? countDown : "LifeOff!") + ").";
  }

  @Override
  public void run() {
    while (countDown-- > 0) {
      System.out.println(status());
      Thread.yield();
    }
  }

}
