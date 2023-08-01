package ru.job4j.generic;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RoleStoreTest {

    @Test
    void whenAddAndFindThenRoleNameIsPetr() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Стажер"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Стажер");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Стажер"));
        Role result = store.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRoleNameIsPetr() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Стажер"));
        store.add(new Role("1", "Джуниор"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Стажер");
    }

    @Test
    void whenReplaceThenRoleNameIsMaxim() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Стажер"));
        store.replace("1", new Role("1", "Джуниор"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Джуниор");
    }

    @Test
    void whenNoReplaceRoleThenNoChangeRoleName() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Стажер"));
        store.replace("10", new Role("10", "Джуниор"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Стажер");
    }

    @Test
    void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Стажер"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteRoleThenRoleNameIsPetr() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Стажер"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Стажер");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Стажер"));
        boolean result = store.replace("1", new Role("1", "Джуниор"));
        assertThat(result).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Стажер"));
        boolean result = store.replace("10", new Role("10", "Джуниор"));
        assertThat(result).isFalse();
    }

    @Test
    void whenDeleteOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Стажер"));
        boolean result = store.delete("1");
        assertThat(result).isTrue();
    }

    @Test
    void whenDeleteNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Стажер"));
        boolean result = store.delete("2");
        assertThat(result).isFalse();
    }
}