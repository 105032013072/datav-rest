package com.bosssoft.platform.datav.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 分类树的节点
 * 
 * @author huangxw
 */
public class CategoryTreeNode {

    private String Id;

    private String label;

    private boolean isLeaf;

    private Object data;

    private List<CategoryTreeNode> children = new ArrayList<CategoryTreeNode>();

    
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<CategoryTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryTreeNode> children) {
        this.children = children;
    }

    public void addChild(CategoryTreeNode childNode) {
        this.children.add(childNode);
    }

}
