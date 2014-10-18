package processData;


import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bean.Album;

public class FindAlbum {
	private static Album album;

	public static Album find(String albumTitle) throws JsonParseException, JsonMappingException, IOException {
		FindAlbum.album=null;
		ObjectMapper mapper = new ObjectMapper();
		List<Album> albumList = mapper.readValue(new File("albumSource.json"),new TypeReference<List<Album>>() { });
		for(Album al:albumList){
			System.out.println(">>>>>>>>>"+al.getTitle());
			if(al.getTitle().equals(albumTitle)){
				FindAlbum.album=al;
				System.out.println("FounD>>>>>>>>>");
			}
		}
		return album;
	}
	
}
