import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BlockBreakerPanel extends JPanel implements KeyListener {

	Thread thread;
	Animate animate;
	Block paddle;
	ArrayList<Block> blocks = new ArrayList<Block>();
	ArrayList<Block> ball = new ArrayList<Block>();

	public BlockBreakerPanel() {

		paddle = new Block(175, 480, 150, 25, "paddle.png");

		for (int i = 0; i < 8; i++) {
			blocks.add(new Block((i * 60 + 2), 0, 60, 25, "blue.png"));
		}

		for (int i = 0; i < 8; i++) {
			blocks.add(new Block((i * 60 + 2), 25, 60, 25, "green.png"));
		}

		for (int i = 0; i < 8; i++) {
			blocks.add(new Block((i * 60 + 2), 50, 60, 25, "yellow.png"));
		}

		for (int i = 0; i < 8; i++) {
			blocks.add(new Block((i * 60 + 2), 75, 60, 25, "red.png"));
		}

		ball.add(new Block(237, 437, 25, 25, "ball.png"));

		addKeyListener(this);
		setFocusable(true);
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		for (Block b : blocks) {
			b.draw(g, this);
		}

		for (Block b : ball) {
			b.draw(g, this);
		}

		paddle.draw(g, this);
	}

	public void update() {

		for (Block ba : ball) {

			ba.x = ba.x + ba.dx;

			if (ba.x > (getWidth() - 25) && ba.dx > 0 || ba.x < 0) {
				ba.dx = ba.dx * (-1);
			}

			if (ba.y < 0 || ba.intersects(paddle)) {
				ba.dy = ba.dy * (-1);
			}

			ba.y = ba.y + ba.dy;

			for (Block b : blocks) {

				if (ba.intersects(b) && !b.destroyed) {
					b.destroyed = true;
					ba.dy = ba.dy * (-1);
				}
			}
		}
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			animate = new Animate(this);
			thread = new Thread(animate);
			thread.start();
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT && paddle.x > 0) {

			paddle.x = paddle.x - 15;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT && paddle.x < (getWidth() - paddle.width)) {

			paddle.x = paddle.x + 15;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
