package priv.cassie.parameterizedTestDemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import java.util.stream.Stream;

//The code is from https://zhuanlan.zhihu.com/p/111706639
public class ParameterizedTest {
    //@ValueSource: 为参数化测试指定入参来源，支持八大基础类以及String类型,Class类型
    @org.junit.jupiter.params.ParameterizedTest
    @ValueSource(strings = {"one", "two", "three"})
    @DisplayName("参数化测试1")
    public void parameterizedTest1(String string) {
        System.out.println(string);
        Assertions.assertTrue(StringUtils.isNotBlank(string));
    }

    //@CsvFileSource：表示读取指定CSV文件内容作为参数化测试入参
    @org.junit.jupiter.params.ParameterizedTest
    @CsvFileSource(resources = "/test.csv")  //指定csv文件位置
    @DisplayName("参数化测试-csv文件")
    public void parameterizedTest2(String name, Integer age) {
        System.out.println("name:" + name + ",age:" + age);
        Assertions.assertNotNull(name);
        Assertions.assertNotNull(age);
    }

    //@MethodSource：表示读取指定方法的返回值作为参数化测试入参(注意方法返回需要是一个流)
    @org.junit.jupiter.params.ParameterizedTest
    @MethodSource("method")    //指定方法名
    @DisplayName("方法来源参数")
    public void testWithExplicitLocalMethodSource(String name) {
        System.out.println(name);
        Assertions.assertNotNull(name);
    }

    static Stream<String> method() {
        return Stream.of("apple", "banana");
    }

    //@NullSource: 表示为参数化测试提供一个null的入参
    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @DisplayName("提供一个null的入参的参数化测试")
    public void testWithNullVal(String value){
        Assertions.assertNull(value);
        System.out.println("value值为null");
    }

}
