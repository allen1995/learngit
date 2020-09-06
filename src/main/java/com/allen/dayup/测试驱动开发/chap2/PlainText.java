package com.allen.dayup.测试驱动开发.chap2;

import java.util.Map;
import java.util.Objects;

/**
 * @Auther: allen
 * @Date: 2020-09-06 08:13
 * @Description:
 */
public class PlainText implements Segment{
    private String text;

    public PlainText() {
    }

    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlainText)) return false;
        PlainText plainText = (PlainText) o;
        return Objects.equals(text, plainText.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public String evaluate(Map<String, String> variables) {
        return text;
    }
}
