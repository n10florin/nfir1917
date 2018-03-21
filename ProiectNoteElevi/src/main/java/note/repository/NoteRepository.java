package note.repository;

import java.util.List;
import note.utils.ClasaException;

import note.model.Nota;

public interface NoteRepository {
	
	void addNota(Nota nota) throws ClasaException;
	List<Nota> getNote();
	void readNote(String fisier);
	
}
