package persistence;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import exceptions.FileFormatInvalid;

public interface FileFormat{

    public abstract void createFile(ArrayList<Object[]> data, String filePath) throws IOException, FileFormatInvalid, TransformerConfigurationException, ParserConfigurationException, TransformerException;

}