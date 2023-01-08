package priv.cassie.assertTestDemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

//The code is from https://zhuanlan.zhihu.com/p/111706639
public class AssertTimeoutTest {
    @Test
    @DisplayName("超时测试")
    public void timeoutTest() {
        //如果测试方法时间不超过1s则不会异常
        Assertions.assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(200));
        //如果测试方法时间超过1s将会异常
        Assertions.assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(2000));
    }
}
