package com.allen.dayup.测试驱动开发.chap2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: allen
 * @Date: 2020-09-02 22:48
 * @Description:
 */
public class TemplateParse {

    public List<String> parse(String template) {
        List<String> segments = new ArrayList<>();
        int index = collectSegments(segments, template);
        addTail(segments, template, index);
        addEmptyStringTemplateWasEmpty(segments);

        return segments;
    }

    private void addEmptyStringTemplateWasEmpty(List<String> segments) {
        if( segments.isEmpty() ){
            segments.add("");
        }
    }

    private void addTail(List<String> segs, String src, int index) {
        if( index < src.length()){
            segs.add(src.substring(index));
        }
    }

    private int collectSegments(List<String> segs, String src) {
        Pattern pattern = Pattern.compile("\\$\\{[^}]*\\}");
        Matcher matcher = pattern.matcher(src);
        int index = 0;
        while ( matcher.find() ){
            addPrecedingPlainText(segs, src, matcher, index);
            addVariables(segs, src, matcher);
            index = matcher.end();
        }

        return index;
    }

    private void addVariables(List<String> segs, String src, Matcher matcher) {
        segs.add( src.substring(matcher.start(), matcher.end()));
    }

    private void addPrecedingPlainText(List<String> segs, String src, Matcher matcher, int index) {
        if( index != matcher.start() ){
            segs.add( src.substring(index, matcher.start()));
        }
    }

    public List<Segment> parseSegments(String template) {
        List<Segment> segments = new ArrayList<>();
        List<String> strings = parse(template);

        for (String s : strings ){
            if( Template.isVariable(s)){
                String name = s.substring(2, s.length()-1);
                segments.add(new Variable(name));
            } else {
                segments.add(new PlainText(s));
            }
        }

        return segments;
    }
}
