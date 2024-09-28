package Exercises;
import javax.swing.JOptionPane;

public class ex61 {

    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null, "Do you want to change to first class ticket?");

        // Object[] options = { "I do", "I don't" };
        // int option = JOptionPane.showOptionDialog(null,"Do you want to change to first class ticket?",
        //         "Ticket Confirmation Question",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

        JOptionPane.showMessageDialog(null,
                "You've chosen: " + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
        System.exit(0);
    }
}