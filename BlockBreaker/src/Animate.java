
public class Animate implements Runnable {

	BlockBreakerPanel blockBreakerPanel;

	public Animate(BlockBreakerPanel bbp) {

		blockBreakerPanel = bbp;
	}

	@Override
	public void run() {

		while (true) {
			blockBreakerPanel.update();
		}
	}

}
