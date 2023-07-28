package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("collection contains no data");
    }
    @Test
    void checkLength() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse).isInstanceOf(IllegalArgumentException.class).hasMessage("Names array is empty");
    }
    @Test
    void checkContains() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("a-b")).isInstanceOf(IllegalArgumentException.class).hasMessage("this name: a-b does not contain the symbol '='");
    }
    @Test
    void checkStartsWith() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("=b")).isInstanceOf(IllegalArgumentException.class).hasMessage("this name: =b does not contain a key");
    }
    @Test
    void checkIndexOf() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("b=")).isInstanceOf(IllegalArgumentException.class).hasMessage("this name: b= does not contain a value");
    }
}