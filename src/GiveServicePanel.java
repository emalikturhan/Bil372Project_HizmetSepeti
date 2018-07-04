import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

class GiveServicePanel extends JPanel {
        JButton addCourse, clear;
        GiveServicePanel() {
            addCourse = new JButton("Add Course");
            clear = new JButton("Clear");
            setLayout(new FlowLayout());
            add(addCourse);
            add(clear);
        }
    }