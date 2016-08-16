
public class Animate implements Runnable {

	BlockBreakerPanel blockBreakerPanel;

	public Animate(BlockBreakerPanel bbp) {

		blockBreakerPanel = bbp;
	}

	@Override
	public void run() {

		while (true) {
			blockBreakerPanel.update();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
