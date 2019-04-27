package com.johnny.store.common;

import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.enums.PriorityEnum;
import com.johnny.store.enums.ResponseOptionEnum;
import com.johnny.store.enums.ResponseTypeEnum;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class ConvertObjectUtils {
    /**
     *
     * <p>
     *
     * @description 转换javabean ,将class2中的属性值赋值给class1，如果class1属性有值，则不覆盖
     *              ，前提条件是有相同的属性名，该方法只能对String类型的属性进行赋值，其他类型需要手动赋值
     *              </p>
     * @param class1
     *            基准类,被赋值对象
     * @param class2
     *            提供数据的对象
     * @throws Exception
     * @author ex_dingyongbiao
     * @see
     */
    public static void convertJavaBean(Object class1, Object class2) throws StoreException {
        try{
            Class<?> clazz1 = class1.getClass();
            Class<?> clazz2 = class2.getClass();
            // 得到method方法
            Method[] method1 = clazz1.getMethods();
            Method[] method2 = clazz2.getMethods();

            int length1 = method1.length;
            int length2 = method2.length;
            if (length1 != 0 && length2 != 0) {
                // 创建一个get方法数组，专门存放class2的get方法。
                Method[] get = new Method[length2];
                for (int i = 0, j = 0; i < length2; i++) {
                    if (method2[i].getName().indexOf("get") == 0) {
                        get[j] = method2[i];
                        ++j;
                    }
                }
                for (Method aGet : get) {
                    // 数组初始化的长度多于get方法，所以数组后面的部分是null
                    if (aGet == null){
                        continue;
                    }

                    // 得到get方法的值，判断时候为null，如果为null则进行下一个循环
                    Object value = aGet.invoke(class2, new Object[]{});
                    if (null == value){
                        continue;
                    }
                    // 得到get方法的名称 例如：getXxxx
                    String getName = aGet.getName();
                    // 得到set方法的时候传入的参数类型，就是get方法的返回类型
                    Class<?> paramType = aGet.getReturnType();
                    Method getMethod = null;
                    try {
                        // 判断在class1中时候有class2中的get方法，如果没有则抛异常继续循环
                        getMethod = clazz1.getMethod(getName, new Class[]{});
                    } catch (NoSuchMethodException e) {
                        continue;
                    }
                    // class1的get方法不为空并且class1中get方法得到的值为空，进行赋值，如果class1属性原来有值，则跳过
                    if (null == getMethod || null != getMethod.invoke(class1, new Object[]{})){
                        continue;
                    }
                    // 通过getName 例如getXxxx 截取后得到Xxxx，然后在前面加上set，就组装成set的方法名
                    String setName = "set" + getName.substring(3);
                    // 得到class1的set方法，并调用
                    Method setMethod = clazz1.getMethod(setName, paramType);
                    setMethod.invoke(class1, value);
                }
            }
        }catch (InvocationTargetException ex){
            throw new StoreException(PriorityEnum.Normal,
                    new Date(),
                    ResponseCodeConsts.InvokeMethodException,
                    ResponseTypeEnum.Exception,
                    ResponseOptionEnum.Admin,
                    ex.getMessage(),
                    ex);
        }catch (IllegalAccessException ex){
            throw new StoreException(PriorityEnum.Normal,
                    new Date(),
                    ResponseCodeConsts.InvokeSecurityException,
                    ResponseTypeEnum.Exception,
                    ResponseOptionEnum.Admin,
                    ex.getMessage(),
                    ex);
        }catch (NoSuchMethodException ex){
            throw new StoreException(PriorityEnum.Normal,
                    new Date(),
                    ResponseCodeConsts.InvokeSecurityException,
                    ResponseTypeEnum.Exception,
                    ResponseOptionEnum.Admin,
                    ex.getMessage(),
                    ex);
        }
    }
}
