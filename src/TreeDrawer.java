import javax.swing.*;
import java.awt.*;

public class TreeDrawer {
    Branch branch;

    TreeDrawer(Branch branch) {
        this.branch = branch;
    }

    public void draw() {
        JFrame mainFrame = new JFrame("Tree");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setSize(1000, 1000);
        mainFrame.setBackground(new Color(0, 0, 0));
        mainFrame.add(new DrawPanel(branch));

        mainFrame.setVisible(true);
    }
}

class DrawPanel extends JPanel {
    Branch branch;

    public DrawPanel(Branch b) {
        branch = b;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(128, 50, 50));

        drawNewBranch(branch, g2d, 500, 1000, 180);
    }

    private void drawNewBranch(Branch branch, Graphics2D g2d, int startX, int startY, int parentAngle) {
        double parentAngleGrad = parentAngle * Math.PI / 180;
        int length = branch.getLength();
        int endX = (int) ((startX + length * Math.sin(parentAngleGrad)));
        int endY = (int) ((startY + length * Math.cos(parentAngleGrad)));
        g2d.drawLine(startX, startY, endX, endY);

        Branch[] branches = branch.getChilds();

        for (int i = 0; i < 5; i++) {
            if (branches[i] != null) {
                if(branches[i].getLastBranch() == false){
                    g2d.setColor(new Color(128, 50, 50));
                } else {
                    g2d.setColor(new Color(100, 250, 50));
                }

                if (i < 3) {
                    double childAngle = parentAngle - 30;
                    int startChildX = (int)((startX + length/2 * Math.sin(parentAngleGrad)));
                    int startChildY = (int)((startY + length/2 * Math.cos(parentAngleGrad)));
                    drawNewBranch(branches[i], g2d, startChildX, startChildY, (int) childAngle);
                } else if (i == 3) {
                    double childAngle = parentAngle;
                    int startChildX = endX;
                    int startChildY = endY;
                    drawNewBranch(branches[i], g2d, startChildX, startChildY, (int) childAngle);
                } else {
                    double childAngle = parentAngle + 30;
                    int startChildX = (int)((startX + length/2 * Math.sin(parentAngleGrad)));
                    int startChildY = (int)((startY + length/2 * Math.cos(parentAngleGrad)));
                    drawNewBranch(branches[i], g2d, startChildX, startChildY, (int) childAngle);
                }
            }
        }
    }
}
