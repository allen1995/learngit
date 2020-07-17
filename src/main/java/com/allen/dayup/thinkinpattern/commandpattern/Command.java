package com.allen.dayup.thinkinpattern.commandpattern;

/**
 * @Auther: 20190598
 * @Date: 2020/7/17 11:43
 * @Description: 需求描述：
 * 文字编辑器和撤销：
 * 本例中的文字编辑器在每次和用户互动时，都会创建一个新的命令对象。命令执行其行为后压入历史堆栈。
 *
 * 当程序执行撤销操作的时，程序就会恢复该命令保存在编辑器的历史状态或者执行反向操作
 */
public abstract class Command {
    public Editor editor;

    private String backup;

    public Command(Editor editor) {
        this.editor = editor;
    }

    public abstract boolean execute();

    void backup(){
        backup = editor.textField.getText();
    }

    public void undo(){
        editor.textField.setText(backup);
    }


}
