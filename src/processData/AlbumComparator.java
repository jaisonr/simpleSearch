package processData;

import java.util.Comparator;
import bean.Album;

public class AlbumComparator implements Comparator<Album> {

	@Override
	public int compare(Album album1, Album album2) {
		String albumName1=album1.getTitle();
		String albumName2=album2.getTitle();
		return albumName1.compareTo(albumName2);
	}

}
