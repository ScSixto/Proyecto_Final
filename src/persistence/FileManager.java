package persistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.json.simple.DeserializationException;

import exceptions.FileFormatInvalid;

public class FileManager {

    JsonFile jsonFile;

    public FileManager() {
        this.jsonFile = new JsonFile();
    }

    public void writeJsonFile(ArrayList<Object[]> data, String filePath) throws IOException, FileFormatInvalid {
        new JsonFile().createFile(data, filePath);
    }

    public void writeXmlFile(ArrayList<Object[]> data, String filePath)
            throws IOException, FileFormatInvalid, ParserConfigurationException, TransformerException {
        new XmlFile().createFile(data, filePath);

    }

    public void writeTxtFile(ArrayList<Object[]> data, String filePath) throws IOException, FileFormatInvalid {
        new TxtFile().createFile(data, filePath);

    }

    public void writeBinFile(ArrayList<Object[]> data, String filePath) throws IOException {
        new BinFile().createFile(data, filePath);
    }

    public ArrayList<Object[]> readSpeciesList(String speciesJsonFilePath, boolean isFile)
            throws FileNotFoundException, IOException, DeserializationException {
        return jsonFile.readSpeciesList(speciesJsonFilePath, isFile);
	}

	public ArrayList<Object[]> readCultiveList(String cultiveJsonFileUrl, boolean isFile)
            throws FileNotFoundException, IOException, DeserializationException {
		return jsonFile.readCultiveList(cultiveJsonFileUrl, isFile);
	}
}