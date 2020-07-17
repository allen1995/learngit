package com.allen.dayup.thinkinpattern.commandpattern;

import javax.swing.*;
import java.awt.*;

/**
 * @Auther: 20190598
 * @Date: 2020/7/17 13:31
 * @Description:
 */
public class Editor {
    public JTextArea textField;
    public String clipboard;

    private CommandHistory history = new CommandHistory();

    public void init(){
        JFrame frame = new JFrame("Text editor (type & use button, Luke!)");
        JPanel content = new JPanel();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        textField = new JTextArea();
        textField.setLineWrap(true);
        content.add(textField);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton ctrlc = new JButton("Ctrl+C");
        JButton ctrlx = new JButton("Ctrl+X");
        JButton ctrlv = new JButton("Ctrl+V");
        JButton ctrlz = new JButton("Ctrl+Z");

        Editor editor = this;
        ctrlc.addActionListener( e -> executeCommand(new CopyCommand(editor)));
        ctrlx.addActionListener( e -> executeCommand(new CutCommand(editor)));
        ctrlv.addActionListener( e -> executeCommand(new ParseCommand(editor)));
        ctrlz.addActionListener( e -> undo());

        buttons.add(ctrlc);
        buttons.add(ctrlv);
        buttons.add(ctrlx);
        buttons.add(ctrlz);

        content.add(buttons);

        frame.setSize(450, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private void executeCommand(Command command){
        if( command.execute() ){
            history.push(command);
        }
    }

    private void undo(){
        if( history.isEmpty()){
            return;
        }

        Command command = history.pop();
        command.undo();
    }
}
