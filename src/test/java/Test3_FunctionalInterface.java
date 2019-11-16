import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Log4j2
class Test3_FunctionalInterface {

    List<String> stringList;

    @BeforeEach
    void beforeEach() {
        stringList = Arrays.asList("Abstract", "I", "Internationalization", "One", "Four");
    }

    @Test
    void nonFunctional() {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };

        stringList.sort(comparator);

        log.info(stringList);
    }

    @Test
    void lambda_1() {
        Comparator<String> comparator = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());

        stringList.sort(comparator);
    }

    @Test
    void lambda_2() {
        Comparator<String> comparator = (s1, s2) -> Integer.compare(s1.length(), s2.length());

        stringList.sort(comparator);
    }

    @Test
    void methodReference() {
        Comparator<String> comparator = Comparator.comparingInt(String::length);

        stringList.sort(comparator);
    }

}