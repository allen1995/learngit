package com.allen.dayup.thinkinpattern.commandpattern;

/**
 * @Auther: 20190598
 * @Date: 2020/7/17 13:42
 * @Description:
 */
public class CopyCommand extends Command {

    public CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        editor.clipboard = editor.textField.getSelectedText();
        return false;
    }
}
