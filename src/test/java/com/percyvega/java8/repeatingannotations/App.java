package com.percyvega.java8.repeatingannotations;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class App {

    @Test
    void testGetAnnotationsByType_when_one() {
        Color color = Pants.class.getAnnotation(Color.class);
        assertThat(color.name()).isEqualTo("blue");

        Colors colors = Pants.class.getAnnotation(Colors.class);
        assertThat(colors).isNull();

        Color[] colorArray = Pants.class.getAnnotationsByType(Color.class);
        assertThat(colorArray.length).isEqualTo(1);
        assertThat(colorArray[0].name()).isEqualTo("blue");
    }

    @Test
    void testGetAnnotationsByType_when_multiple() {
        Color color = Shirt.class.getAnnotation(Color.class);
        assertThat(color).isNull();

        Colors colors = Shirt.class.getAnnotation(Colors.class);
        assertThat(colors.value().length).isEqualTo(3);

        Color[] colorArray = Shirt.class.getAnnotationsByType(Color.class);
        assertThat(colorArray.length).isEqualTo(3);
        assertThat(colorArray[0].name()).isEqualTo("red");
        assertThat(colorArray[1].name()).isEqualTo("blue");
        assertThat(colorArray[2].name()).isEqualTo("green");
    }
}
