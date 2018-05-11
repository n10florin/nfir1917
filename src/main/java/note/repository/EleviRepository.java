package note.repository;

import java.util.List;

import note.model.Elev;

public interface EleviRepository {
	void addElev(Elev e);
	List<Elev> getElevi();
	Elev getElev(int nrMatricol);
	void readElevi(String fisier);
}
