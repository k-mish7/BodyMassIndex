import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Block Breaker");

		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		BlockBreakerPanel panel = new BlockBreakerPanel();

		frame.getContentPane().add(panel);

		frame.setVisible(true);
		frame.setSize(500, 600);

	}

}
