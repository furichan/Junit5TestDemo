package priv.cassie.dynamicTestDemo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

//The code is from https://zhuanlan.zhihu.com/p/111706639
public class DynamicTest {
    /**
     * JUnit5允许我们动态的创建单元测试,通过@TestFactory注解，会在运行时生成单元测试。
     * 需要注意的是@TestFactory修饰的方法本身并不是单元测试，他只是负责生成单元测试。
     * 我们只需要返回 DynamicTest的迭代器甚至是流即可生成不同的单元测试。
     * @return
     */
    @TestFactory
    @DisplayName("动态测试")
    Iterator<org.junit.jupiter.api.DynamicTest> dynamicTests() {
        return Arrays.asList(
                dynamicTest("第一个动态测试", () -> assertTrue(true)),
                dynamicTest("第二个动态测试", () -> assertEquals(4, 2 * 2))
        ).iterator();
    }
}
