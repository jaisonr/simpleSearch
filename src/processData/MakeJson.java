package processData;

import java.io.IOException;
import java.text.ParseException;

import bean.Album;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class MakeJson {

	public static String generateJsonData(String albumTitle) throws JsonGenerationException,
			JsonMappingException, IOException, ParseException {
		ObjectMapper mapper = new ObjectMapper();
		Album album = FindAlbum.find(albumTitle);
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		// mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS,
		// true);
		//SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy");
		//mapper.setDateFormat(outputFormat);
		mapper.setSerializationInclusion(Include.NON_EMPTY);

		//mapper.writeValue(new File("album.json"), album);
		return mapper.writeValueAsString(album);

	}

}
