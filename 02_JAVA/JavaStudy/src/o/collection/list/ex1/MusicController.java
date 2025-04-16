package o.collection.list.ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class MusicController {
	private List list = new ArrayList();
	
	
	
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
		for(Object obj : list) { //오브젝트는 다 받을 수있기 때문에 리스트에서 뭔가 꺼낼 때
			Music  m =(Music)obj;
			if(m.getTitle().equals(obj)) {
				return m;
			}
			
	
//		for(Music music : list) {//이건 제네릭으로 <Music>을 썻기 때문에 가능 제네릭을 사용하지 않았다면 사용 불가능
//			if(music.getTitle().equals(title)) {
//				return music;
//			}
//			
//		}
		}
		return null;
	}
	
	
	public Music removeMusic(String title) {
		
		for(Object obj : list) {
			Music m =(Music)obj;
			if(m.getTitle().equals(title)) {
				list.remove(m);
			}
		}
		return null;
	}

	/*
	Music m = this.searchMusic(title);
	if(m != null) {
		int index = list.indexOf(m);
		System.out.println(index);
		list.remove(music);
			}
	return null;
	*/
	
	public Music setMusic(String title, Music music) {
		Music m = this.searchMusic(title);
		if(m != null) {
			int index = list.indexOf(m);
			list.set(index, music);
		}
		return m;
	}
	public int ascTitle() {
		
		//Collections.sort : 컬렉션에서 정렬기능을 제공하는 메서드
		//정렬하고 싶은 컬렉션객체와 정렬기준을 정한 객체(Comparator를 구현한 객체)를 
		//전달하면 정렬기준에 맞춰 정렬을 수행해준다.
		
		Collections.sort(list, new AscTitle());
		
		return 1;
	}
	
	public int descSinger() {
//		Collections.sort(list, new Comparator<Music>(){
//			public int compare(Music o1, Music o2) {
//				return o2.getSinger().compareTo(o1.getSinger());
//			}
//			
//		});
		
		/*
		 * 함수형 인터페이스
		 * - 단 하나의 추상메서드를 가진 인터페이스
		 * 람다식을 통해서 단일추상메서드를 바로 구현해서 사용할 수 있다.
		 * 
		 * */
		
//		Comparator com = (o1, o2) -> ((Music)o2).getSinger().compareTo(((Music)o1).getSinger());
//		Collections.sort(list, com);이거랑 
//		Collections.sort(list, (o1, o2) -> ((Music)o2).getSinger().compareTo(((Music)o1).getSinger()));
//		이거랑 같다

		//람다식의 기본구조
		// (매개변수) -> {실행할 코드}
		
		//반환값이 1개일 때는 {}생략가능
		// (매개변수) -> 반환값
		Collections.sort(list, (o1, o2) -> ((Music)o2).getSinger().compareTo(((Music)o1).getSinger()));
		
		return 1;
	}

	
	

}
