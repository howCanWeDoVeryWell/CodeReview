package com.java.parser;

import java.util.ArrayList;
import java.util.List;

public class Tag {
    private String tagName;
    private List<Tag> childTags;
    private Tag parentTag;
    
    public Tag(String tagName) {
        this.tagName = tagName;
        this.childTags = new ArrayList<>();
        this.parentTag = this;
    }
    
    public String getTagName() {
        return tagName;
    }
    
    public List<Tag> getChildTags() {
        return childTags;
    }
    
    public Tag getParentTag() {
        return parentTag;
    }
}
