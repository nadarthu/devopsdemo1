package ch.zhaw.iwi.devops.demo;

public class Module {

    public long id;
    public String name;
    public String description;

    public Module() {}

    public Module(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}