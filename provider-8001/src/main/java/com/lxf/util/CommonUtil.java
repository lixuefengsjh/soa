package com.lxf.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lxf.common.Constants;
import com.lxf.common.TcmartErrorException;
import org.springframework.cglib.beans.BeanCopier;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;

/**
 * 通用方法
 *
 * @author Chinhin
 * 2019-07-16
 */
public final class CommonUtil {

    /**
     * 复制一个bean
     *
     * @param from    from
     * @param toClass 目标的class
     * @param <T>     目标泛型
     * @return 复制成功的目标
     */
    public static <T> T copy(Object from, Class<T> toClass) {
        BeanCopier copier = BeanCopier.create(from.getClass(), toClass, false);
        T toObj;
        try {
            toObj = toClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw TcmartErrorException.valueOf(Constants.ERROR_SYSTEM);
        }
        copier.copy(from, toObj, null);
        return toObj;
    }

    public static <T> List<T> copyList(List from, Class<T> toClass) {
        List<T> result = new ArrayList<>();
        if (from == null || from.size() == 0) {
            return result;
        }
        for (Object temp : from) {
            T copy = copy(temp, toClass);
            result.add(copy);
        }
        return result;
    }

    /**
     * 对象转json
     *
     * @param obj 要转换的对象
     */
    public static String toJson(Object obj) {
        return JSON.toJSONString(obj, SerializerFeature.DisableCircularReferenceDetect); // 避免循环引用
    }

    /**
     * json转对象
     *
     * @param json  json文本
     * @param clazz 解析的类
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    /**
     * json字符串转map
     *
     * @param json json文本
     */
    public static Map<String, Object> jsonToMap(String json) {
        return JSON.parseObject(json);
    }

    /**
     * 将主要单位（个），转为最小单位（btc的satoshi，eth的wei）
     *
     * @param num      多少个
     * @param decimals 精度
     * @return 结果
     */
    public static BigInteger convert2LowerUnit(BigDecimal num, int decimals) {
        return num.multiply(new BigDecimal(String.valueOf(Math.pow(10, decimals)))).toBigInteger();
    }

    /**
     * 将最小单位（btc的satoshi，eth的wei），转换为主要单位（个）
     *
     * @param num      最小单位的数
     * @param decimals 精度
     * @return 结果
     */
    public static BigDecimal convert2MajorUnit(BigInteger num, int decimals) {
        return new BigDecimal(num).divide(new BigDecimal(String.valueOf(Math.pow(10, decimals))), 18, RoundingMode.DOWN);
    }

    public static void main(String[] args) {
        System.out.println(BigDecimal.valueOf(9).negate());
    }

    public static BigDecimal div(BigDecimal num1, BigDecimal num2) {
        return num1.divide(num2, 8, RoundingMode.DOWN);
    }

    public static <T extends Comparable, V> Map<T, V> sortMapByKey(Map<T, V> data, Class<T> t, Class<V> v, boolean isAsc) {
        TreeMap<T, V> sortData = new TreeMap<>(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if (isAsc) {
                    return o1.compareTo(o2);
                } else {
                    return BigDecimal.valueOf(o1.compareTo(o2)).negate().intValue();
                }
            }
        });
        for (Map.Entry<T, V> item : data.entrySet()) {
            sortData.put(item.getKey(), item.getValue());
        }
        return new LinkedHashMap<>(sortData);
    }

}
