package com.allen.dayup.thinkinpattern.commandpattern;

/**
 * @Auther: 20190598
 * @Date: 2020/7/17 13:43
 * @Description:
 */
public class ParseCommand extends Command {


    public ParseCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if( editor.clipboard == null || editor.clipboard.isEmpty() ){
            return false;
        }

        backup();
        editor.textField.insert(editor.clipboard, editor.textField.getCaretPosition());

        return true;
    }
}
