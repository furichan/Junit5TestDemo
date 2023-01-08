package priv.cassie.parallelTestDemo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;

// parallel test code from https://blog.csdn.net/weixin_43972159/article/details/118763743
public class ParallelTest {
    // 成员变量money
    static Integer money;

    // 在所有方法执行之前,先初始化一下钱
    @BeforeAll
    static void beforeAll() {
        money = 1000;
        System.out.println("初始化money = "+money);

    }
    // 1000人,每人加一次,在1000人加完以后,检查一下数量对不对
    @AfterAll
    static void afterAll() {
        System.out.println("最后money = "+money);
        Assertions.assertEquals(2000,money);
    }

//    /**
//     * 演示问题,模拟1000人同时进来,没有加锁
//     */
//    @RepeatedTest(1000)
//    void test01() {
//        money++;
//        System.out.println("money = " + money);
//    }

    /**
     * 锁这的是money,这样就没有问题了
     */
    @RepeatedTest(1000)
    void test02() {
        synchronized (money) {
            money++;
            System.out.println("money = " + money);
        }
    }

//    /**
//     * 这里写this,锁住这个类对象,也锁不住
//     * 举个例子,这个类是一个厕所,你是把这个厕所给锁了
//     * 可这1000个人本来就在厕所里面,1000个人去争抢这张纸,还会出现问题的,
//     * 所以核心是要对纸进行加锁,一个人用完了,另外一个人才能接着用(例子有点恶心,哈哈)
//     */
//    @RepeatedTest(1000)
//    void test03() {
//        synchronized (this) {
//            money++;
//            System.out.println("money = " + money);
//        }
//    }




}
