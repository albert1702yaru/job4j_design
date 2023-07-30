package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }
    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> array = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .containsOnly("second", "first", "three", "four", "five")
                .containsExactly("first", "second", "three", "four", "five")
                .containsExactlyInAnyOrder("three", "four", "five", "first", "second")
                .containsAnyOf("first", "one")
                .doesNotContain("one", "two")
                .startsWith("first", "second")
                .endsWith("four", "five")
                .containsSequence("three", "four")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }
    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> array = simpleConvert.toSet("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .containsOnly("second", "first", "three", "four", "five")
                .containsExactlyInAnyOrder("three", "four", "five", "first", "second")
                .containsAnyOf("first", "one")
                .doesNotContain("one", "two")
                .containsAnyOf("zero", "second", "six");
    }
    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> array = simpleConvert.toMap("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .containsKey("second")
                .containsValues(1, 2, 3)
                .doesNotContainKey("one")
                .doesNotContainValue(5)
                .containsEntry("first", 0);
    }
}