package cn.kgeek.sunflower.components.form;

public class DemandForm  extends BaseForm{

    @Override
    public BaseForm config() {
        this.addLabel("ff").addLabel("");
        return this;
    }
}
