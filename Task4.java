package in.FutureIntern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class Task4 extends JPanel implements ActionListener {
    private final int WIDTH = 400;
    private final int HEIGHT = 400;
    private final int BOX_SIZE = 20;
    private final ArrayList<Point> snake = new ArrayList<>();
    private Point food;
    private char direction = 'R';
    private boolean gameOver = false;
    private int score = 0;
    private final Timer timer;

    public Task4() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.WHITE);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT -> direction = 'L';
                    case KeyEvent.VK_UP -> direction = 'U';
                    case KeyEvent.VK_RIGHT -> direction = 'R';
                    case KeyEvent.VK_DOWN -> direction = 'D';
                }
            }
        });
        initializeGame();
        timer = new Timer(100, this);
        timer.start();
    }

    private void initializeGame() {
        snake.clear();
        snake.add(new Point(9 * BOX_SIZE, 9 * BOX_SIZE));
        spawnFood();
    }

    private void spawnFood() {
        Random rand = new Random();
        food = new Point(rand.nextInt(WIDTH / BOX_SIZE) * BOX_SIZE, rand.nextInt(HEIGHT / BOX_SIZE) * BOX_SIZE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gameOver) {
            g.setColor(Color.RED);
            g.drawString("Game Over! Score: " + score, WIDTH / 4, HEIGHT / 2);
            return;
        }
        g.setColor(Color.RED);
        g.fillRect(food.x, food.y, BOX_SIZE, BOX_SIZE);
        g.setColor(Color.GREEN);
        for (Point p : snake) {
            g.fillRect(p.x, p.y, BOX_SIZE, BOX_SIZE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            moveSnake();
            checkCollision();
            repaint();
        }
    }

    private void moveSnake() {
        Point head = snake.getFirst();
        Point newHead = new Point(head);

        switch (direction) {
            case 'L' -> newHead.x -= BOX_SIZE;
            case 'U' -> newHead.y -= BOX_SIZE;
            case 'R' -> newHead.x += BOX_SIZE;
            case 'D' -> newHead.y += BOX_SIZE;
        }

        if (newHead.equals(food)) {
            score++;
            snake.addFirst(newHead);
            spawnFood();
        } else {
            snake.addFirst(newHead);
            snake.removeLast();
        }
    }

    private void checkCollision() {
        Point head = snake.getFirst();
        if (head.x < 0 || head.y < 0 || head.x >= WIDTH || head.y >= HEIGHT || snake.subList(1, snake.size()).contains(head)) {
            gameOver = true;
            timer.stop();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        Task4 game = new Task4();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
