package priv.cassie.assertTestDemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//The code is from https://zhuanlan.zhihu.com/p/111706639
public class AssertExceptionTest {

    @Test
    @DisplayName("异常测试")
    public void exceptionTest() {
        ArithmeticException exception = Assertions.assertThrows(
                //扔出断言异常
                ArithmeticException.class, () -> System.out.println(1 % 0));

        System.out.println(exception);

    }
}
