package com.mcal.uidesigner.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class NonOverwritingFileOutputStream extends OutputStream {
    private final String path;
    private byte[] buffer = new byte[1000];
    private int pos;

    public NonOverwritingFileOutputStream(String path) {
        this.path = path;
    }

    @Override
    public void write(int oneByte) throws IOException {
        if (pos >= buffer.length) {
            grow(pos + 1);
        }
        byte[] bArr = buffer;
        int i = pos;
        pos = i + 1;
        bArr[i] = (byte) oneByte;
    }

    @Override
    public void write(byte[] buf, int offset, int count) throws IOException {
        if (pos + count >= buffer.length) {
            grow(pos + count);
        }
        for (int i = 0; i < count; i++) {
            buffer[pos + i] = buf[offset + i];
        }
        pos += count;
    }

    private void grow(int len) {
        byte[] newBuffer = new byte[Math.max(buffer.length * 2, len)];
        System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);
        buffer = newBuffer;
    }

    @Override
    public void close() throws IOException {
        new File(path).getParentFile().mkdirs();
        if (new File(path).exists() && new File(path).length() == ((long) pos)) {
            boolean differ = false;
            FileInputStream in = new FileInputStream(path);
            int i = 0;
            while (true) {
                int b = in.read();
                if (b == -1) {
                    break;
                }
                int i2 = i + 1;
                if (b != buffer[i]) {
                    differ = true;
                    break;
                }
                i = i2;
            }
            in.close();
            if (!differ) {
                return;
            }
        }
        FileOutputStream out = new FileOutputStream(path);
        out.write(buffer, 0, pos);
        out.close();
    }
}
