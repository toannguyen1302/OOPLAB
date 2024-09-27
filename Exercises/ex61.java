package Exercises;
import javax.swing.JOptionPane;

// Question: 
// +) if users choose Cancel: return same as No
// +) I have customize in the cmt below

public class ex61 {

    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null, "Do you want to change to first class ticker?");

        // Object[] options = { "I do",
        //         "I don't" };
        // int n = JOptionPane.showOptionDialog(null,
        //         "Do you want to change to 1st class ticker?",
        //         "Ticket Confirmation Question",
        //         JOptionPane.YES_NO_OPTION,
        //         JOptionPane.QUESTION_MESSAGE,
        //         null,
        //         options,
        //         options[0]);

        JOptionPane.showMessageDialog(null,
                "You've chosen: " + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
        System.exit(0);
    }
}