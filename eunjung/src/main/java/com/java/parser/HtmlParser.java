package com.java.parser;

import java.util.HashMap;
import java.util.Map;

public class HtmlParser {
    public Tag parse(String html) {
        Tag tag = null;
        
        boolean isOpenTag = false;
        boolean isCloseTag = false;
        String tagName = "";
        
        for (int i = 0; i < html.length(); i++) {
            String atChar = String.valueOf(html.charAt(i));
            
            if ("<".equals(atChar)) {
                i++;
                atChar = String.valueOf(html.charAt(i));
                if ("/".equals(atChar)) {
                    i++;
                    atChar = String.valueOf(html.charAt(i));
                    isCloseTag = true;
                    isOpenTag = false;
                } else {
                    isOpenTag = true;
                    isCloseTag = false;
                }
            }
            
            if (">".equals(atChar)) {
                if (!isCloseTag) {
                    tag = new Tag(tagName);
    //                dom.put(tagName, new HashMap<String, Object>());
    //                pointMap = (Map<String, Object>) pointMap.get(tagName);
                    tagName = "";
                }
                isOpenTag = false;
                isCloseTag = false;
            }
            
            if (isOpenTag) {
                tagName += String.valueOf(html.charAt(i));
            }
            
            if (isCloseTag) {
                
            }
        }
        
        return tag;
    }
}
