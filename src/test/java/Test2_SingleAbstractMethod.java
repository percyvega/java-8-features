import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

//@FunctionalInterface
interface PrintDemo {
    void print(String s);
}

@Log4j2
class Test2_SingleAbstractMethod {

    @Test
    void nonFunctional() {
        PrintDemo demo = new PrintDemo() {
            @Override
            public void print(String s) {
                log.info(s);
            }
        };

        demo.print("Hello!");
    }

    @Test
    void lambda_1() {
        PrintDemo demo = (String s) -> log.info(s);

        demo.print("Hello!");
    }

    @Test
    void lambda_2() {
        PrintDemo demo = (s) -> log.info(s);

        demo.print("Hello!");
    }

    @Test
    void methodReference() {
        PrintDemo demo = log::info;

        demo.print("Hello!");
    }

}