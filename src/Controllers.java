import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CountButtonController implements ActionListener {
    UserWindow window;

    public CountButtonController(UserWindow window){
        this.window = window;
    }

    public void actionPerformed(ActionEvent e){
        Session session = window.getSession();
        String file = window.getFileName();
        if (window.radio1.isSelected()) {
            file = window.radio1.getText();
        } else if (window.radio2.isSelected()){
            file = window.radio2.getText();
        }
        session.countFile(file);
        window.setTextField(session.printFileWordCount(file));
    }

}
