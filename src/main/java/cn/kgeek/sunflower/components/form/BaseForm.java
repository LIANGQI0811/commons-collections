package cn.kgeek.sunflower.components.form;

import java.util.List;

public abstract class BaseForm {
    private List<Component> sunfolwerForm;

    public abstract BaseForm config();

    public BaseForm addComponent(Component component) {
        this.sunfolwerForm.add(component);
        return  this;
    }

    public BaseForm addLabel(String text) {
        return this.addComponent(new Label());
    }

}
