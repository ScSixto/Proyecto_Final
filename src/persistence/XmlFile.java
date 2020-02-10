package persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import exceptions.FileFormatInvalid;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;

public class XmlFile implements FileFormat {

    @Override
    @SuppressWarnings("unchecked")
    public void createFile(ArrayList<Object[]> data, String filePath)throws IOException, FileFormatInvalid, ParserConfigurationException, TransformerException {
        Document doc = null;
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		
		docBuilder = docFactory.newDocumentBuilder();
		doc = docBuilder.newDocument();
		      
		Element rootElement = doc.createElement("town_list");
		doc.appendChild(rootElement);

		for (Object[] objects : data) {
            Element town = doc.createElement("town");

			Element idTown = doc.createElement("atribute");
			idTown.setAttribute("town_atribute", "town_id");
			idTown.setTextContent(String.valueOf((int) objects[0]));
			town.appendChild(idTown);
			
			Element nameTown = doc.createElement("atribute");
			idTown.setAttribute("town_atribute", "town_name");
			idTown.setTextContent((String) objects[1]);
            town.appendChild(nameTown);
            for (Object[] object : (ArrayList<Object[]>)objects[2]) {
                Element cultive = doc.createElement("cultive");
                cultive.setAttribute("cultive_id", String.valueOf(object[0]));
                cultive.setAttribute("year", String.valueOf(object[1]));
                cultive.setAttribute("species_name", (String)(object[2]));
                cultive.setAttribute("cultivated_fishes_quantity", String.valueOf(object[3]));
                cultive.setAttribute("harvested_fishes_quantity", String.valueOf(object[4]));
                cultive.setAttribute("harvested_fish_average_weight_kg", String.valueOf(object[7]));
                cultive.setAttribute("harvested_fishes_weight_kg", String.valueOf(object[5]));
                cultive.setAttribute("total_cultive_cost", String.valueOf(object[6]));
                town.appendChild(cultive);
            }
            rootElement.appendChild(town);
		}
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(filePath));
        transformer.transform(source, result);
        
	
	}
}