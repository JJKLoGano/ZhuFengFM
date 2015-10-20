package com.jjklogano.zufengfm.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加/解密工具类
 * Created
 * Author : LoGano(贾璟琨)
 * Email : mengpangzhi@hotmial.com
 * Date : 2015/10/12
 */
public final class EncryptTools {

    private EncryptTools(){}


    /**
     * 获取文件MD5字符串
     * @param stringContent
     * @return
     */
    public static String getMD5String(String stringContent){
        String ret=null;

        if (stringContent != null) {
            try {
                //创建消息摘要对象，使用MD5算法
                MessageDigest digest = MessageDigest.getInstance("MD5");
                //计算URL对应的MD5数据，生成的数据是字节数组
                //内部包含了不可显示的字节，需要进行编码才可以转换成字符串
                //不要使用new String()!!!!
                //要转换成16进制内容
                byte[] data = digest.digest(stringContent.getBytes());
                //对MD5结果编码
                //每一个字节转换为16进制，并且拼接成字符出串
                ret=toHex(data);

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

        }
        return ret;
    }

    /**
     * 将字节数组转换成16进制编码字符串
     * @param data
     * @return
     */
    public static String toHex(byte[] data){
        String ret=null;
        if (data != null&&data.length>0) {
            StringBuilder builder=new StringBuilder();
            for (byte b : data) {
                int v=b & 0xFF;
                String hexString = Integer.toHexString(v);
                if(v>0x0F){
                    builder.append(hexString);
                }else{
                    builder.append('0').append(hexString);
                }
            }
            ret=builder.toString();
        }
        return ret;
    }
}
