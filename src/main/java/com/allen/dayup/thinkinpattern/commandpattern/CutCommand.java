package com.allen.dayup.thinkinpattern.commandpattern;

/**
 * @Auther: 20190598
 * @Date: 2020/7/17 13:43
 * @Description:
 */
public class CutCommand extends Command {

    public CutCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if( editor.textField.getSelectedText().isEmpty()){
            return false;
        }

        String source = editor.textField.getText();
        editor.clipboard = editor.textField.getSelectedText();
        editor.textField.setText(cutString(source));

        return true;
    }

    private String cutString(String source) {
        String start = source.substring(0, editor.textField.getSelectionStart());
        String end = source.substring(editor.textField.getSelectionEnd());
        return start + end;
    }
}
