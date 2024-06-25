package com.mcal.uidesigner.common;

import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeHelper {
    public static Object deserialize(String serialized, Object def) {
        if (serialized != null) {
            try {
                Object res = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(serialized, Base64.DEFAULT))).readObject();
                if (res != null) {
                    return res;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return def;
    }

    public static String serialize(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(bos);
            os.writeObject(obj);
            os.close();
            return Base64.encodeToString(bos.toByteArray(), Base64.DEFAULT);
        } catch (Exception e) {
            return null;
        }
    }
}
