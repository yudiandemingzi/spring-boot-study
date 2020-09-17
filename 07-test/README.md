#SpringBoot(20）---断言(Assert)

我们在写单元测试的时候,除了接口直接抛异常而导致该单元测试失败外，还有种是业务上的错误也代表着该单元测试失败。
好比我们在测试接口的时候，该接口返回是1代表成功，如果是0那就代表是失败的，这个时候可以考虑使用断言。


##一、原理

我们知道，我们可以通过断言来校验测试用例的返回值和实际期望值进行比较，以此来判断测试是否通过。那我们先来看下如果失败的情况下它的流程是怎么样的。

对于断言而言，如果是错误最终都会进入下面的方法

```java
    static public void fail(String message) {
        if (message == null) {
            throw new AssertionError();
        }
        throw new AssertionError(message);
    }
```

很明显，这里有一个`AssertionError`对象，我们来看下这个对象。

```
public class AssertionError extends Error {
 //......
}
```

我们很明显看到，它实继承是`Error`，而不是**Exception**。这说明什么，说明你无法通过**try catch**去捕获这个异常，只要进入断言fail中，一定会抛出异常。

<br>

##二、Assert 源码

这里只展示Assert源码中常用的方法,一些不常用或者过期的方法这里就不展示了。

```java
public class Assert {

    /**
     * 结果 = 预期 则正确
     */
    static public void assertEquals(Object expected, Object actual)

    /**
     * 结果 != 预期 则正确
     */
    static public void assertNotEquals(Object unexpected, Object actual)

    /**
     * condition == true 则正确
     */
    static public void assertTrue(boolean condition)

    /**
     * condition == false 则正确
     */
    static public void assertFalse(boolean condition)

    /**
     * 永远是错误
     */
    static public void fail()

    /**
     * 结果不为空 则正确
     */
    static public void assertNotNull(Object object)

    /**
     * 结果为空 则正确
     */
    static public void assertNull(Object object)

    /**
     * 两个对象引用 相等 则正确（上面相当于equels 这里类似于使用“==”比较两个对象）
     */
    static public void assertSame(Object expected, Object actual)

    /**
     * 两个对象引用 不相等 则正确
     */
    static public void assertNotSame(Object unexpected, Object actual)

    /**
     * 两个数组相等 则正确
     */
    public static void assertArrayEquals(Object[] expecteds, Object[] actuals)

    /**
     * 这个单独介绍
     */
    public static <T> void assertThat(T actual, Matcher<? super T> matcher)
        
}

```

`注意` 上面每一个方法，都会有一个多一个参数的方法，这个参数为:**String message**。意思就是错误的情况下，我们可以输出我们自定义的message

**示例**

```java
   //这个就表示 结果 != 预期 的情况下，抛出的AssertionError 信息是我们指定的message
   static public void assertEquals(String message,Object expected, Object actual)

```

上面还有一个方法需要单独介绍，那就是assertThat方法。

<br>

##三、assertThat方法


大家习惯把assertThat理解成`新断言`，因为上面所以的功能方法，都可以通过assertThat这一个方法来实现。

####1、基本语法

assertThat 的基本语法如下：

```
assertThat( [value], [matcher statement] );

```
**value** 是接口返回信息中，我们想要测试的变量值

**matcher statement**: 是使用`Hamcrest`匹配符来表达的对前面变量所期望的值的声明，如果**value**值与**matcher statement**所表达的期望值相符，则测试成功，否则测试失败。

####2、基本使用

`字符串匹配符`

```java
  String n = "xiao";
// containsString：字符串变量中包含指定字符串时，测试通过
assertThat(n, containsString("xiao"));
// startsWith：字符串变量以指定字符串开头时，测试通过
assertThat(n, startsWith("xi"));
// endsWith：字符串变量以指定字符串结尾时，测试通过
assertThat(n, endsWith("ao"));
// euqalTo：字符串变量等于指定字符串时，测试通过
assertThat(n, equalTo("xiao"));
// equalToIgnoringCase：字符串变量在忽略大小写的情况下等于指定字符串时，测试通过
assertThat(n, equalToIgnoringCase("xiao"));
// equalToIgnoringWhiteSpace：字符串变量在忽略头尾任意空格的情况下等于指定字符串时，测试通过
assertThat(n, equalToIgnoringWhiteSpace(" xiao   "));
```
`int匹配符`

```java
int s = 1;
// allOf：所有条件必须都成立，测试才通过（大于1同时小于3）
assertThat(s, allOf(greaterThan(1), lessThan(3)));
// anyOf：只要有一个条件成立，测试就通过 （大于1或者小于2）
assertThat(s, anyOf(greaterThan(1), lessThan(2)));
// anything：无论什么条件，测试都通过
assertThat(s, anything());
// is：变量的值等于指定值时，测试通过
assertThat(s, is(2));
// not：和is相反，变量的值不等于指定值时，测试通过
assertThat(s, not(1));
```

`double匹配符`

```java
double d = 1D;
// closeTo：浮点型变量的值在3.0±0.5范围内，测试通过
assertThat(d, closeTo(3.0, 0.5));
// greaterThan：变量的值大于指定值时，测试通过
assertThat(d, greaterThan(3.0));
// lessThan：变量的值小于指定值时，测试通过
assertThat(d, lessThan(3.5));
// greaterThanOrEuqalTo：变量的值大于等于指定值时，测试通过
assertThat(d, greaterThanOrEqualTo(3.3));
// lessThanOrEqualTo：变量的值小于等于指定值时，测试通过
assertThat(d, lessThanOrEqualTo(3.4));
```
`集合匹配符`

```java
List<String> list = new ArrayList();
// hasItem：Iterable变量中含有指定元素时，测试通过
assertThat(list, hasItem("xiao"));

Map<String, String> m = new HashMap<>();
// hasEntry：Map变量中含有指定键值对时，测试通过
assertThat(m, hasEntry("xi", "xiao"));
// hasKey：Map变量中含有指定key时，测试通过
assertThat(m, hasKey("x"));
// hasValue：Map变量中含有指定value值时，测试通过
assertThat(m, hasValue("x"));
```

<br>

##四、测试

这里对于老断言，和新断言各测试5个。

####1、老断言

`示例`

```java
public class TestServiceImplTest {
    
    @Test
    public void test1() {
        String str = "xiao";
        assertEquals(str, "xiaoniao");//不相等，所以错误
    }
    @Test
    public void test2() {
        assertFalse(Boolean.TRUE); //不是false,所以错误
    }

    @Test
    public void test3() {
       fail("直接是错误"); //直接是错误
    }

    @Test
    public void test4() {
        assertNull("xiao"); //不为空所以为错误
    }

    @Test
    public void test5() {
        assertNotNull("xiao");//不为空，所以为正确
    }
    
}
```
这里应该只有第5个测试用例通过，前面4个都不通过的，我们在来看实际运行结果

（图1）

与实际相符，前面4个，测试用例不通过。而且可以看到第3个是我们自定义错误信息，在控制台也打印出来了。


####2、新断言


`示例`

```java
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TestServiceImplTest {

    @Test
    public void test1() {
        String str = "xiao";
        assertThat("这两字符串不相等",str, is("xiaoniao"));//不相等，所以错误
    }
    @Test
    public void test2() {
        int s = 1;
        assertThat(s, anyOf(greaterThan(1), lessThan(2)));//满足 大于1或者小于2 所以正确
    }

    @Test
    public void test3() {
        double d = 1D;
        assertThat(d, allOf(greaterThanOrEqualTo(1D),lessThan(2D)));//满足大于等于1 并且 小于2 所以正确

    }

    @Test
    public void test4() {
        List<String> list = Lists.newArrayList("xiao","zhong","da");
        assertThat(list, hasItem("xiao"));  //包含xiao 所以正确
    }

    @Test
    public void test5() {
        Map<String, String> map = new HashMap<>();
        map.put("xiao", "xiao");
        assertThat(map, hasKey("xiao")); //该map包含该key，所以正确
    }
}
```
这里应该只有第1个测试用例不通过，其它都是通过的，我们在来看实际运行结果

（图2）


符合预期。







