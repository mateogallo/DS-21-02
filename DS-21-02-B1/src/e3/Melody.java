package e3;

import java.util.ArrayList;
import java.util.Objects;


public class Melody {

    private final ArrayList<Notes> notes;
    private final ArrayList<Accidentals> accidentals;
    private final ArrayList<Float> times;
    private int hash;

    public Melody() {
        notes = new ArrayList<>();
        accidentals = new ArrayList<>();
        times = new ArrayList<>();
    }


    public void addNote(Notes note, Accidentals accidental, float time) {

        if (note == null || accidental == null || time <= 0) {
            throw new IllegalArgumentException();
        }
        notes.add(note);
        accidentals.add(accidental);
        times.add(time);
    }

    public Notes getNote(int index) {
        if (index > notes.size() - 1 || index<0) {
            throw new IllegalArgumentException();
        }
        return notes.get(index);
    }

    public Accidentals getAccidental(int index) {
        if (index > accidentals.size() - 1 || index<0) {
            throw new IllegalArgumentException();
        }
        return accidentals.get(index);
    }


    public float getTime(int index) {
        if (index > times.size() - 1 || index<0) {
            throw new IllegalArgumentException();
        }
        return times.get(index);
    }


    public int size() {
        return notes.size();
    }


    public float getDuration() {

        float total = 0;
        for (Float time : times) {
            total = total + time;
        }
        return total;
    }

    private double valorNota(Notes note, Accidentals accidentals) {
        double noteval, accval;
        if (accidentals == Accidentals.SHARP) {
            accval = 0.5;
        } else if (accidentals == Accidentals.FLAT) {
            accval = -0.5;
        } else accval = 0;

        if (note == Notes.SI && accval == 0.5) {
            return 0;
        } else if (note == Notes.DO && accval == -0.5) {
            return 6;
        } else if (note == Notes.MI && accval == 0.5) {
            return 3;
        } else if (note == Notes.FA && accval == -0.5) {
            return 2;
        } else {
            noteval = note.ordinal() + accval;
            return noteval;
        }
    }

    private boolean compararMelodias(Melody mel1, Melody mel2){
        int i = 0;
        while( i< mel1.size()) {
            if (valorNota(mel1.getNote(i), mel1.getAccidental(i)) == valorNota(mel2.getNote(i), mel2.getAccidental(i))) {
                i++;
            }
            else{
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Melody mel = (Melody) o;
        if (size() != mel.size()) {
            return false;
        } else {
            if (!compararMelodias(this,mel)) {
                return false;
            }
        }
        this.hash = Objects.hash(mel, this);
        mel.hash = this.hash;
        return this.times.equals(mel.times);
    }


    @Override
    public int hashCode() {
        return hash;
    }

    @Override
    public String toString() {

        String s1 = "";
        String aux;

        for (int i = 0; i < size(); i++) {
            aux = notes.get(i).toString() + accidentals.get(i).toString() + "(" + times.get(i).toString() + ") ";
            s1 = s1.concat(aux);
        }
        return s1.trim();
    }
}