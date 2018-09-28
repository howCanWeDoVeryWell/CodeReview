package com.java;

import com.java.parser.HtmlParser;
import com.java.parser.Tag;
import org.hamcrest.MatcherAssert;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class HtmlParserTest {
    private HtmlParser parser = new HtmlParser();
    @Test
    public void testHtmlParserCaseOnlyHtml() {
        // Given
        String html = "<html></html>";
        
        // When
        Tag tag = parser.parse(html);
        
        // Then
        Tag expectedTag = new Tag("html");
        
        Assertions.assertEquals(expectedTag.getTagName(), tag.getTagName());
        MatcherAssert.assertThat(tag.getChildTags(), CoreMatchers.is(expectedTag.getChildTags()));
    }
    
    @Test
    public void testHtmlParserCaseHtmlInnerTag() {
        // Given
        String html = "<html><header></header><body></body></html>";

        // When
        Tag tags = parser.parse(html);

        // Then
        Map<String, Object> htmlMap = new HashMap<>();
        htmlMap.put("header", null);
        htmlMap.put("body", null);
        Map<String, Object> expectedDom = new HashMap<>();
        expectedDom.put("html", htmlMap);
//        Assertions.assertEquals(expectedDom, dom);
    }
}
