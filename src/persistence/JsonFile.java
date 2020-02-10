package persistence;

import java.io.*;
import java.util.ArrayList;

import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

import exceptions.FileFormatInvalid;

import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownHostException;

public class JsonFile implements FileFormat {
	//
	// private static ArrayList<String> especies;
	//
	// public JsonFile() {
	// especies = new ArrayList<String>();
	// }
	//
	// public static BufferedReader readJSONWeb(String webServicePath) {
	// BufferedReader buffer = new BufferedReader(new
	// InputStreamReader(getHttpURLConnection(false,webServicePath)));
	// return buffer;
	// }

	public static InputStream getHttpURLConnection(boolean isProxy, String filePath) {
		HttpURLConnection httpURLConnection;
		URL url = null;
		InputStream inputStream = null;
		try {
			url = new URL(filePath);
			if (!isProxy) {
				System.out.println("Sin proxy");
				httpURLConnection = (HttpURLConnection) url.openConnection();
				inputStream = httpURLConnection.getInputStream();
			} else {
				System.out.println("Con proxy");
				Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.73", 8080));
				httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
				inputStream = httpURLConnection.getInputStream();
				if (inputStream == null)
					System.out.println("Este input no quiere funcionar");
			}

		} catch (ConnectException connectException) {
			isProxy = true;
			return getHttpURLConnection(isProxy, filePath);
		} catch (UnknownHostException e) {
			isProxy = true;
			System.out.println("Catch: " + e.getMessage());
			return getHttpURLConnection(isProxy, filePath);
		} catch (MalformedURLException e1) {
			System.out.println(e1.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return inputStream;
	}

	public Reader getReader(String route, boolean isFile) throws FileNotFoundException {
		Reader reader;
		if (isFile)
			reader = new FileReader(route);
		else
			reader = new BufferedReader(new InputStreamReader(JsonFile.getHttpURLConnection(false, route)));
		return reader;
	}

	public ArrayList<Object[]> readCultiveList(String fileName, boolean isFile)
			throws FileNotFoundException, IOException, org.json.simple.DeserializationException {
		ArrayList<Object[]> cultiveList = new ArrayList<>();
		JsonArray jsonCultiveArray = (JsonArray) Jsoner.deserialize(this.getReader(fileName, isFile));
		for (Object object : jsonCultiveArray) {
			JsonObject cultiveObj = (JsonObject) object;
			if (cultiveObj.size() >= 8)
				cultiveList.add(new Object[] { cultiveObj.getString("municipio"), cultiveObj.getInteger("a_o"),
						cultiveObj.getString("especie"), cultiveObj.getInteger("animales_sembrados"),
						cultiveObj.getInteger("animales_cosechados"),
						cultiveObj.getDouble("peso_promedio_por_animal_al_cosechar_g") });
		}
		return cultiveList;
	}

	public ArrayList<Object[]> readSpeciesList(String fileName, boolean isFile)
			throws FileNotFoundException, IOException, org.json.simple.DeserializationException {
		ArrayList<Object[]> speciesList = new ArrayList<>();
		JsonObject jsonObject = (JsonObject) Jsoner.deserialize(this.getReader(fileName, isFile));
		JsonArray listOfSpecies = (JsonArray) jsonObject.get("especies_de_peces");
		for (Object object : listOfSpecies) {
			JsonObject speciesObj = (JsonObject) object;
			speciesList.add(new Object[] { speciesObj.getInteger("id_especie"), speciesObj.getString("especie"),
					speciesObj.getDouble("costo_libra"), speciesObj.getString("tipo_agua"),
					speciesObj.getString("alimento") });
		}
		return speciesList;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void createFile(ArrayList<Object[]> data, String filePath) throws IOException, FileFormatInvalid {
		JsonObject jsonFather = new JsonObject();
		JsonArray townArray = new JsonArray();
		for (Object[] objects : data) {
			JsonObject town = new JsonObject();
			town.put("town_id",objects[0]);
			town.put("town_name",objects[1]);
			JsonArray cultiveArray = new JsonArray();
			for (Object[] object : (ArrayList<Object[]>) objects[2]){
				JsonObject cultive = new JsonObject();
				cultive.put("cultive_id",object[0]);
				cultive.put("year",object[1]);
				cultive.put("species_name",object[2]);
				cultive.put("cultivated_fishes_quantity",object[3]);
				cultive.put("harvested_fishes_quantity",object[4]);
				cultive.put("harvested_fish_average_weight_kg",object[7]);
				cultive.put("harvested_fishes_weight_kg",object[5]);
				cultive.put("total_cultive_cost",object[6]);
				cultiveArray.add(cultive);
			}
			town.put("cultive_list",cultiveArray);
			townArray.add(town);
		}
		jsonFather.put("town_list", townArray);
		new WriterManager().writeFile(filePath, jsonFather.toJson());;
	}
}