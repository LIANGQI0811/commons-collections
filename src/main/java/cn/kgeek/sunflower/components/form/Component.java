package cn.kgeek.sunflower.components.form;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class Component {
    private String type;
    private String key;
    private String title;
    private String hint;
    private boolean required;
    private List<ChildrenNode> children;
    private String action;

    public Component(ComponentType type) {
        this.type = type.name;
        this.required = false;
        this.hint = "";
        this.children = new ArrayList<>();
    }
    public Component addChild(ChildrenNode child) {
        this.children.add(child);
        return this;
    }

    public static enum ComponentType {
        LABEL("label");

        private String name;

        ComponentType(String name) {
            this.name = name;
        }
    }

    public static enum ComponentAction  {
        NAV("NA")
        ;

        ComponentAction(String name) {
            this.name = name;
        }

        private String name;

        public String getName() {
            return name;
        }
    }
}
