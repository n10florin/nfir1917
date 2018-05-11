package note.repository;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import note.utils.ClasaException;
import note.utils.Constants;

import note.model.Nota;

public class NoteRepositoryMock implements NoteRepository{
	private List<Nota> note;
	
	public NoteRepositoryMock() {
		note = new LinkedList<Nota>();
	}


	@Override
	public void addNota(Nota nota) throws ClasaException {
		// TODO Auto-generated method stub
		if(!validareNota(nota))
			return;
		note.add(nota);
	}

	private boolean validareNota(Nota nota) throws ClasaException {
		// TODO Auto-generated method stub
		if(nota.getMaterie().length() < 4 || nota.getMaterie().length() > 20)
			throw new ClasaException(Constants.invalidMateria);
		if(nota.getNrmatricol() < Constants.minNrmatricol || nota.getNrmatricol() > Constants.maxNrmatricol)
			throw new ClasaException(Constants.invalidNrmatricol);
		if(nota.getNota() < Constants.minNota || nota.getNota() > Constants.maxNota)
			throw new ClasaException(Constants.invalidNota);
		return true;
	}

	@Override
	public List<Nota> getNote() {
		// TODO Auto-generated method stub
		return note;
	}
	
	public void readNote(String fisier) {
		try {
			FileInputStream fstream = new FileInputStream(fisier);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(";");
				Nota nota = new Nota(Integer.parseInt(values[0]), values[1], Integer.parseInt(values[2]));
				note.add(nota);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
