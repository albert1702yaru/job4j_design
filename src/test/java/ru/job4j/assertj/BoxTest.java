package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

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
        Box box = new Box(4, 9);
        double num = box.getArea();
        assertThat(num).isEqualTo(140.29d, withPrecision(0.007d))
                .isCloseTo(140.29d, withPrecision(0.01d))
                .isCloseTo(140.29d, Percentage.withPercentage(1.0d)).isGreaterThan(140.29)
                .isLessThan(140.30).isNotNull();
    }
    @Test
    void isThis0() {
        Box box = new Box(4, 10);
        double num = box.getArea();
        assertThat(num).isEqualTo(173.2d, withPrecision(0.006d))
                .isCloseTo(173.2d, withPrecision(0.01d))
                .isCloseTo(173.2d, Percentage.withPercentage(1.0d)).isGreaterThan(173.2)
                .isLessThan(173.21).isNotNull();
    }
}