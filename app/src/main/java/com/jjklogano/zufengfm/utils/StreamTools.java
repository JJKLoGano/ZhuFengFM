package com.jjklogano.zufengfm.utils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created
 * I/O流工具类
 * Author : LoGano(贾璟琨)
 * Email : mengpangzhi@hotmial.com
 * Date : 2015/10/12
 */
public final class StreamTools {
    private StreamTools() {

    }

    public static byte[] readStream(InputStream inputStream) throws IOException {
        byte[] ret = null;
        ByteArrayOutputStream bout = null;

        if (inputStream != null) {
            bout = new ByteArrayOutputStream();
            byte[] buf = new byte[128];
            int len;
            while (true) {
                len = inputStream.read(buf);
                if (len == -1) {
                    break;
                }
                bout.write(buf, 0, len);
            }
            //buf必须进行=null操作；
            //降低内存溢出风险
            buf = null;
            ret = bout.toByteArray();
            bout.close();
        }
        return ret;
    }
}
