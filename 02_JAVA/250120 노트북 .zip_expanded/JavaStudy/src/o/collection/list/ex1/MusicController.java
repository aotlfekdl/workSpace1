package o.collection.list.ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class MusicController {
	private List<Music> list = new ArrayList();
	
	
	
	public int addList(Music music) {
		
		list.add(music);
		return 1;
	}
	
	public int addAtZero(Music music) {
		list.add(0, music);
		return 1;
	
	}
			
	public List printAll() {
		
		
		return list ;
	}
	
	public Music searchMusic(String title) {
		
	
		for(Music music : list) {
			if(music.getTitle().equals(title)) {
				return music;
			}
			
		}
		
		return null;
	}
	
	public Music removeMusic(String title) {
		for(Music music : list) {
			if(music.getTitle().equals(title)) {
				list.remove(music);
			}
		}
		return null;
	}

	/*
	Music music = searchMusic(title);
	if(music != null) {
		list.remove(music);
			}
	return null;
	*/
	
	public Music setMusic(String title, Music newmusic) {
		Music music = searchMusic(title);
		if(music != null) {
			int index = list.indexOf(music);
			list.set(index, newmusic);
		}
		return music;
	}
	
	public int ascTitle() {
		
		
	//	Collections.sort(list, new AscTitle());
		
		return 1;
	}
	
	public int descSinger() {
		return 0;
	}

	
	

}
