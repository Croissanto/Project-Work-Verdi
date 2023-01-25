package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Author;
import com.example.demo.model.Gallery;
import com.example.demo.model.LibriGame;
import com.example.demo.model.repositories.GalleryRepository;
import com.example.demo.model.repositories.LibriGameRepository;
@SpringBootTest
class GalleryTest {
	@Autowired
	private GalleryRepository repoG;
	@Autowired
	private LibriGameRepository repoL;

	@Test
	public void createGallery(){
		List<LibriGame> list  = new LinkedList<>();
		LibriGame libroGame = new LibriGame(1, "sa", new Author(), null, 0, null);
		list.add(libroGame);
		Gallery gallery = new Gallery("AOh", list, 0);
		assertNotNull(repoG.save(gallery));
	
	}
	//Creare un galleryDTO , mandare al rest controller , verificare da repository se la galleria c'é 
	//tramite findByTitoloSaga , verificare se 

}
