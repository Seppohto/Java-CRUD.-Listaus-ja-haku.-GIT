package test;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import model.Asiakas;
import model.dao.Dao;

@TestMethodOrder(OrderAnnotation.class)
class Junit_testaa_Asiakkaat {

	@Test
	@Order(1) 
	public void testPoistaKaikkiAsiakkaat() {
		Dao dao = new Dao();
		dao.poistaKaikkiAsiakkaat("nimda");
		ArrayList<Asiakas> asiakkaat = dao.listaaKaikki();
		assertEquals(0, asiakkaat.size());
	}
	
	@Test
	@Order(2) 
	public void testLisaaAsiakas() {		
		//Tehd‰‰n muutama uusi testiasiakas
		Dao dao = new Dao();
		Asiakas asiakas_1 = new Asiakas("Olli", "Uronen", "35841031230","a@co.com",1111);
		Asiakas asiakas_2 = new Asiakas("Ollimpi", "Muronen", "040404040","b@co.com",2222);
		Asiakas asiakas_3 = new Asiakas("Seppo", "Kepponen", "050505050","c@co.com",3333);
		Asiakas asiakas_4 = new Asiakas("Sepompi", "EiHepponen", "0400400400","d@co.com",4444);
		System.out.println(asiakas_1);
		assertEquals(true, dao.lisaaAsiakas(asiakas_1));
		assertEquals(true, dao.lisaaAsiakas(asiakas_2));
		assertEquals(true, dao.lisaaAsiakas(asiakas_3));
		assertEquals(true, dao.lisaaAsiakas(asiakas_4));
	}
	
	@Test
	@Order(3) 
	public void testMuutaAsiakas() {
		//Muutetaan yht‰ asiakasta
		Dao dao = new Dao();
		Asiakas muutettava = dao.etsiAsiakas(2222);
		muutettava.setAsiakas_id(11111);
		muutettava.setEtunimi("Ollein");
		muutettava.setSukunimi("Puronen");
		muutettava.setPuhelin("0700123123");	
		muutettava.setSposti("olli@kolli.com");
		dao.muutaAsiakas(muutettava, 2222);	
		assertEquals(11, dao.etsiAsiakas(11111).getAsiakas_id());
		assertEquals("Ollein", dao.etsiAsiakas(11111).getEtunimi());
		assertEquals("Puronen", dao.etsiAsiakas(11111).getSukunimi());
		assertEquals("0700123123", dao.etsiAsiakas(11111).getPuhelin());
		assertEquals("olli@kolli.com", dao.etsiAsiakas(11111).getSposti());
	}
	
	@Test
	@Order(4) 
	public void testPoistaAsiakas() {
		Dao dao = new Dao();
		dao.poistaAsiakas("11111");
		assertEquals(null, dao.etsiAsiakas(11));
	}

}
