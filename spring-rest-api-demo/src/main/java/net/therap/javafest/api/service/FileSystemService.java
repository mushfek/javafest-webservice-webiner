package net.therap.javafest.api.service;

import java.io.FileNotFoundException;

/**
 * @author Mushfekur Rahman
 * @since 1.0
 */
public interface FileSystemService {

    /**
     * Retrieves raw file data from given location
     *
     * @param path Path from where the file will be loaded
     * @return Raw file data in byte array form
     */
    byte[] getFileData(String path);

    /**
     * Saves a binary file onto the given location
     *
     * @param path Path where to store file
     * @param data File data to be written
     */
    void saveFile(String path, byte[] data) throws Exception;
}
