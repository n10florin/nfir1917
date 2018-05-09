package note.repository;

import java.util.HashMap;
import java.util.List;

import note.utils.ClasaException;

import note.model.Corigent;
import note.model.Elev;
import note.model.Medie;
import note.model.Nota;

public interface ClasaRepository {
	
	void creazaClasa(List<Elev> elevi, List<Nota> note);
	HashMap<Elev, HashMap<String, List<Integer>>> getClasa();
	List<Medie> calculeazaMedii() throws ClasaException;
	void afiseazaClasa();
	List<Corigent> getCorigenti() throws ClasaException;
}
