package net.therap.javafest.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * @author Mushfekur Rahman
 * @since 1.0
 */
@Service
public class FileSystemServiceImpl implements FileSystemService {

    private static final Logger log = LoggerFactory.getLogger(FileSystemServiceImpl.class);

    public FileSystemServiceImpl() {
    }

    @Override
    public byte[] getFileData(String path) {
        return new byte[0];
    }

    @Override
    public void saveFile(String path, byte[] data) throws Exception {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));
        bos.write(data);
        bos.flush();
        bos.close();
    }
}
