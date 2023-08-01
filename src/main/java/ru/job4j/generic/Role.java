package ru.job4j.generic;

public class Role extends Base {

    private final String user;

    public Role(String id, String user) {
        super(id);
        this.user = user;
    }

    public String getRoleName() {
        return user;
    }
}
