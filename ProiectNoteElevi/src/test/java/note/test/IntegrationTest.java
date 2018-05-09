package note.test;

import static org.junit.Assert.*;

import java.util.List;

import note.model.Corigent;
import note.model.Elev;
import note.model.Medie;
import note.model.Nota;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import note.utils.ClasaException;
import note.utils.Constants;

import note.controller.NoteController;

public class IntegrationTest {

	NoteController ctrl;
	
	@Before
	public void setUp() throws Exception {
		ctrl = new NoteController();
	}
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void testA() throws ClasaException {
		Nota nota = new Nota(1000, "Desen", 10);
		ctrl.addNota(nota);
		assertEquals(1, ctrl.getNote().size());
	}

	@Test
	public void testB() throws ClasaException {
		Elev e1 = new Elev(1, "Elev1");
		Elev e2 = new Elev(2, "Elev2");
		ctrl.addElev(e1);
		ctrl.addElev(e2);
		Nota n1 = new Nota(1,"Materie1", 10);
		ctrl.addNota(n1);
		ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
		List<Medie> rezultate = ctrl.calculeazaMedii();
		for(Medie m : rezultate)
			if(m.getElev().getNrmatricol() == 2)
				assertEquals(m.getMedie(), Double.NaN,0.0001);
	}

	@Test
	public void testC() throws ClasaException {
		Elev e1 = new Elev(1, "Elev1");
		Elev e2 = new Elev(2, "Elev2");
		ctrl.addElev(e1);
		ctrl.addElev(e2);
		Nota n1 = new Nota(1,"Materie1", 1);
		Nota n2 = new Nota(1,"Materie1", 7);
		Nota n3 = new Nota(1,"Materie2", 10);
		Nota n4 = new Nota(1,"Materie2", 10);
		Nota n5 = new Nota(2,"Materie2", 4);
		Nota n6 = new Nota(2,"Materie2", 5);
		Nota n7 = new Nota(2,"Materie2", 3);
		Nota n8 = new Nota(2,"Materie1", 4);
		ctrl.addNota(n1);
		ctrl.addNota(n2);
		ctrl.addNota(n3);
		ctrl.addNota(n4);
		ctrl.addNota(n5);
		ctrl.addNota(n6);
		ctrl.addNota(n7);
		ctrl.addNota(n8);
		ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
		List<Corigent> corigenti = ctrl.getCorigenti();
		assertEquals(corigenti.get(1).getNrMaterii(), corigenti.get(0).getNrMaterii()+1);
	}

    @Test
    public void testABC() throws ClasaException {
        Elev e1 = new Elev(1, "Elev1");
        ctrl.addElev(e1);
        Nota nota = new Nota(1, "Desen", 10);
        ctrl.addNota(nota);
        assertEquals(1, ctrl.getNote().size());
        ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
        List<Medie> rezultate = ctrl.calculeazaMedii();
        assertEquals(1, rezultate.size());
        List<Corigent> corigenti = ctrl.getCorigenti();
        assertEquals(corigenti.size(),0);
    }

	@Test
	public void testAB() throws ClasaException {
		Elev e1 = new Elev(1, "Elev1");
		ctrl.addElev(e1);
		Nota nota = new Nota(1, "Desen", 10);
		ctrl.addNota(nota);
        assertEquals(1, ctrl.getNote().size());
        ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
		List<Medie> rezultate = ctrl.calculeazaMedii();
		assertEquals(1, rezultate.size());
	}
}
