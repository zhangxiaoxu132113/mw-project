package com.water.tools;

import org.apache.commons.lang3.SerializationUtils;

import java.io.*;

/**
 * Desc: 序列化操作类
 * Created by paul on 2016/2/18.
 */
public class SerializeUtil {
    public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            // 序列化
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Object unserialize(byte[] bytes) throws Exception {
        ByteArrayInputStream bais = null;
        try {
            // 反序列化
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(
                    new BufferedInputStream(bais));
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                bais.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param bytes 需要反序列化的对象的字节数组
     * @return
     * @Title: deserialize
     * @Description: 获取反序列化对象，当反序列化过程出现错误时
     */
    public static <T> T deserialize(byte[] bytes) {
        T target = null;
        if (bytes != null) {
            try {
                target = (T)SerializationUtils.deserialize(bytes);
            } catch (Exception e) {
                //
            } finally {
                //
            }
        }
        return target;
    }
}
