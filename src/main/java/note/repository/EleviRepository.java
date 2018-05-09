package note.repository;

import java.util.List;

import note.model.Elev;

public interface EleviRepository {
	void addElev(Elev e);
	List<Elev> getElevi();
	void readElevi(String fisier);
}
