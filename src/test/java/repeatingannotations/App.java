package repeatingannotations;

import org.junit.jupiter.api.Test;

public class App {

    @Test
    void testGetAnnotationsByType_when_one() {
        Color[] colorArray = Pants.class.getAnnotationsByType(Color.class);
        for (Color color : colorArray) {
            System.out.println(color.name());
        }
    }

    @Test
    void testGetAnnotationsByType_when_multiple() {
        Color[] colorArray = Shirt.class.getAnnotationsByType(Color.class);
        for (Color color : colorArray) {
            System.out.println(color.name());
        }
    }
}
