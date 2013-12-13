import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Tree {
    //int heightTree = 100;

    List<Branch> listOfBranches = new LinkedList<Branch>();

    public Branch generateTree() {
        Branch b = new Branch(500);
        return b;
    }

    private void printTree(Branch b, int gen) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gen; i++) {
            sb.append(" ");
        }
        System.out.println(sb.toString() + b.getLength());
        printNextGeneration(b, gen);

    }

    private void printNextGeneration(Branch b, int gen) {
        int generation = gen + 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gen; i++) {
            sb.append(" ");
        }
        for (Branch branch : b.getChilds()) {
            if (branch != null) {
                System.out.println(sb.toString() + branch.getLength());

                /*
                if(branch.getLastBranch() == false){
                    //Если это ветка - рисуем ветку
                    System.out.println(sb.toString() + branch.getLength());
                } else {
                    //Если это крайняя ветка, рисуем лист
                    System.out.println(sb.toString() + 0);
                }
                */
                printNextGeneration(branch, generation);
            }
        }
    }

}


class Branch {
    private boolean lastBranch = false;
    private int length = 100;
    private Branch[] childs = new Branch[5];

    public Branch(int parentLenght) {
        length = (int) ((Math.random() * 0.2 + 0.5) * parentLenght);

        if (length < 10)
            lastBranch = true;
        if (lastBranch == false) {
            addBranches();
        }
    }

    private void addBranches() {
        for (int i = 0; i < 5; i++) {
            if (Math.random() > 0.1) {
                childs[i] = new Branch(length);
            } else {
                childs[i] = null;
            }
        }
    }

    public Branch[] getChilds() {
        return childs;
    }

    public int getLength() {
        return length;
    }

    public boolean getLastBranch() {
        return lastBranch;
    }


}