package com.myapp.songr;

import com.myapp.songr.model.Album;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SongrApplicationTests {

	@Test
	void toStringAlbum() {
		Album album = new Album("Eghdab", "asala",5,1840,"https://upload.wikimedia.org/wikipedia/ar/f/fb/Ighdab.jpg");
		String output = album.toString();
		String expected = "Album{title='Eghdab', artist='asala', songCount=5, length=1840, imageUrl='https://upload.wikimedia.org/wikipedia/ar/f/fb/Ighdab.jpg'}";
		Assertions.assertEquals(expected,output);
	}

	@Test
	void getArtist() {
		Album album = new Album("Eghdab", "asala",5,1840,"https://upload.wikimedia.org/wikipedia/ar/f/fb/Ighdab.jpg");
		String output = album.getArtist();;
		String expected = "asala";
		Assertions.assertEquals(expected,output);
	}

}
