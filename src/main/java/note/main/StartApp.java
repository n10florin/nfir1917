package note.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import note.utils.ClasaException;

import note.model.Corigent;
import note.model.Medie;
import note.model.Elev;
import note.model.Nota;

import note.controller.NoteController;

//functionalitati
//i.	 adaugarea unei note la o anumita materie (nr. matricol, materie, nota acordata); 
//ii.	 calcularea mediilor semestriale pentru fiecare elev (nume, nr. matricol), 
//iii.	 afisarea elevilor coringenti, ordonati descrescator dupa numarul de materii la care nu au promovat şi alfabetic dupa nume.


public class StartApp {
    /**
     * @param args
     * @throws ClasaException
     */
    public static void main(String[] args) throws ClasaException {
        // TODO Auto-generated method stub
        NoteController ctrl = new NoteController();
        List<Medie> medii;
        List<Corigent> corigenti;
        ctrl.readElevi("src" + File.separator + "elevi");
        ctrl.readNote("src" + File.separator + "note");
        ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
        boolean gasit = false;
        while (!gasit) {
            System.out.println("1. Adaugare Nota");
            System.out.println("2. Calculeaza medii");
            System.out.println("3. Elevi corigenti");
            System.out.println("4. Afisare clasa");
            System.out.println("5. Iesire");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                int option = Integer.parseInt(br.readLine());
                switch (option) {
                    case 1:
                        System.out.print("Dati nr. matricol:");
                        Integer nrMatricol = Integer.parseInt(br.readLine());
                        System.out.print("Dati materie:");
                        String materie = br.readLine();
                        System.out.print("Dati nota:");
                        Integer n = Integer.parseInt(br.readLine());
                        ctrl.addNota(new Nota(nrMatricol, materie, n));
                        for (Nota nota : ctrl.getNote()) {
                            System.out.println(nota);
                        }
                        break;
                    case 2:
                        medii = ctrl.calculeazaMedii();
                        for (Medie medie : medii)
                            System.out.println(medie);
                        break;
                    case 3:
                        corigenti = ctrl.getCorigenti();
                        for (Corigent corigent : corigenti)
                            System.out.println(corigent);
                        break;
                    case 4:
                        ctrl.afiseazaClasa();
                        break;
                    case 5:
                        gasit = true;
                        break;
                    default:
                        System.out.println("Introduceti o optiune valida!");
                }

            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                System.out.println(e.getMessage());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                System.out.println(e.getMessage());
            } catch (ClasaException e) {
                // TODO Auto-generated catch block
                System.out.println(e.getMessage());
            }
        }
    }
}
