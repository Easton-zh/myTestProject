package com.abc.zh.study.json;

/**
 * @description JSON 概念
 * @author hao.z
 * @date 2021-03-31
 */
public class JsonConcept {

    /**
     * 1. 什么是json？
     *  JSON 就是一种轻量级的数据交换格式
     *
     * 2. json的优势？
     *      a.JSON 的简洁 和 清晰的层次结构
     *      b.易于人阅读和编写，同时也易于机器解析和生成
     *      c.有效的提升网络传输效率
     *      d.支持多种语言，很多流行的语言都对 JSON 格式有着很友好的支持
     */


    /**
     * 3. JSON、JSON对象、JSON数组区别?
     *
     * JSON 只是一种宏观上的叫法，可以理解为是一种数据结构，就像 xml 结构一样，是一种规约性内容；
     *      JSON 对象则是对 JSON 的具体体现；
     *      JSON 数组则是将多个 JSON 对象进行存储的一个集合，可以想象成 Java 中的 List 和 Object 的关系
     *
     *      例如：
     *      JSON 对象
     * 这就是一个平常使用的 JSON 对象，特征就是多个属性是被 {} 括起来的
     *
     * {
     * "area": "山东菏泽",
     * "name": "马马马马马百万",
     * "age": 25
     * }
     *
     * JSON 数组其实就是包含了多个 JSON 对象的一个集合，数组是以 数组括号 [] 括起来的
     * [{
     * "area": "广东",
     * "name": "山溪",
     * "age": 25
     * }, {
     * "area": "沙西",
     * "name": "马希泰",
     * "age": 26
     * }]
     *
     * 注意： JSON 数组并一定是要相同的 JSON 对象的集合，也可以是不同的对象，不过我在开发过程中并没有这么使用过，感觉挺别扭的。因为如果将多个对象放进一个 JSONArray 中的话，下意识认为是相同类型的集合
     *
     */

    /**
     * 4. 什么是 JSONObject ？
     *
     * JSONObject 是根据 JSON 形式在 Java 中存在的对象映射
     * 各大 JSON 类库的 JSONObject 内部实现也是不太一样的。这里以 fastjson 举例
     * public class JSONObject extends JSON implements Map<String, Object>, Cloneable, Serializable, InvocationHandler {
     *
     * private static final long serialVersionUID = 1L;
     *
     * private static final int DEFAULT_INITIAL_CAPACITY = 16;
     *
     * private final Map<String, Object> map;
     *
     * public JSONObject(){
     *
     * this(DEFAULT_INITIAL_CAPACITY, false);
     *
     * }
     *
     * public JSONObject(Map<String, Object> map){
     *
     * if (map == null) {
     *
     * throw new IllegalArgumentException("map is null.");
     *
     * }
     *
     * this.map = map;
     *
     * }
     *
     * // 。。。。省略其余内容
     *
     * }
     *
     * 可以看到 就是对 HashMap 的一层封装，并提供了一些个性化方法。有兴趣的话可以去研究下源码实现，这里就不一一解读了
     *
     * 其使用方式和 HashMap 并无太大区别
     *
     * JSONObject person = new JSONObject();
     *
     * person.put("name", "马马马马马百万");
     *
     * person.put("age", 25);
     *
     * person.put("area", "山东菏泽");
     *
     * JSONObject drug = new JSONObject();
     *
     * drug.put("drugName", "盐酸丁卡因注射液");
     *
     * drug.put("drugCode", "HXUDP000000000000MED0000342809");
     *
     * drug.put("dosformName", "注射剂");
     *
     */


    /**
     * 5. 什么是 JSONArray ？
     *
     * 其实刚才拿 List 与 Object 关系举例是有迹可查的
     *
     * 仅针对于 fastjson 而言，因为没看别的具体实现，怕被喷。含蓄点的好
     *
     * 存放数据的容器就是一个 List 的类型，默认创建为 ArrayList ，但不仅限于
     *
     * public class JSONArray extends JSON implements List<Object>, Cloneable, RandomAccess, Serializable {
     *
     * private static final long serialVersionUID = 1L;
     *
     * private final List<Object> list;
     *
     * protected transient Object relatedArray;
     *
     * protected transient Type componentType;
     *
     * public JSONArray(){
     *
     * this.list = new ArrayList<Object>();
     *
     * }
     *
     * public JSONArray(List<Object> list){
     *
     * this.list = list;
     *
     * }
     *
     * public JSONArray(int initialCapacity){
     *
     * this.list = new ArrayList<Object>(initialCapacity);
     *
     * }
     *
     * // 。。。省略余下部分
     *
     * }
     *
     * JSONArray 的平常使用方法
     *
     * 内心独白：不就是一个 List 中 套了个 Map 类结构嘛 对不对 品 你品 你仔细品
     *
     * JSONObject person = new JSONObject();
     *
     * person.put("name", "马马马马马百万");
     *
     * JSONObject drug = new JSONObject();
     *
     * drug.put("drugName", "盐酸丁卡因注射液");
     *
     * JSONArray array = new JSONArray();
     *
     * array.add(person);
     *
     * array.add(drug);
     *
     */

     /**
     * Fastjson 的简单应用
     *
     * 将对象转换为json字符串
     *
     * import com.alibaba.fastjson.JSON;
     *
     * String jsonStr = JSON.toJSONString(person);
     *
     * 将json字符串转换为JSONObject对象
     *
     * JSONObject jsonObject = JSON.parseObject(jsonStr);
     *
     * 将JSONObject 转换为对象
     *
     * JSONObject person = new JSONObject();
     *
     * person.put("name", "马马马马马百万");
     *
     * person.put("age", 25);
     *
     * Student stuObj = JSON.toJavaObject(person, Student.class);
     *
     * 结束语
     *
     * 上述文章中并没有涉及到复杂 JSON 对象，只是为了前期理解没有举例
     *
     * 下述 JSON 中涉及到了 数值、字符串、内置 JSON 对象、数组
     *
     * {
     *
     * "article": {
     *
     * "row": 1024,
     *
     * "lastUpdateTime": "2019-12-13 19:27:59",
     *
     * "Title": "Java 中 JSONArray 与 JSONObject 详细介绍结构及应用",
     *
     * "images": {
     *
     * "Url": "",
     *
     * "Height": 256,
     *
     * "Width": "256"
     *
     * },
     *
     * "sections": [17, 18, 19, 20]
     *
     * }
     *
     * }
     *
     * 关于 JSON格式化 相关的网站
     *
     * JSON解析及格式化个性网站 | 可以解析JSON及XML字符串的网站
     *
     * 关于 JSON 类库项目地址
     *
     * Json-lib | Gson | Jackson | FastJson
     *
     */
}
