package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere").isNotNull();
    }
    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron").isNotNull();
    }
    @Test
    void isThis4() {
        Box box = new Box(4, 10);
        int number = box.getNumberOfVertices();
        assertThat(number).isEqualTo(4).isNotNull();
    }
    @Test
    void isThisMinus1() {
        Box box = new Box(4, 0);
        int number = box.getNumberOfVertices();
        assertThat(number).isEqualTo(-1).isNotNull();
    }
    @Test
    void isThisTrue() {
        Box box = new Box(4, 10);
        boolean exist = box.isExist();
        assertThat(exist).isTrue().isNotNull();
    }
    @Test
    void isThisFalse() {
        Box box = new Box(4, 0);
        boolean exist = box.isExist();
        assertThat(exist).isFalse().isNotNull();
    }
    @Test
    void isThisDouble() {
        Box box = new Box(8, 10);
        double num = box.getArea();
        assertThat(num).isEqualTo(600).isNotNull();
    }
    @Test
    void isThis0() {
        Box box = new Box(9, 10);
        double num = box.getArea();
        assertThat(num).isEqualTo(0).isNotNull();
    }
}