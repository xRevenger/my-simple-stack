package deqo.kchu.mysimplestack;

import java.util.EmptyStackException;

public class Item implements ISimpleStack{
    private int valeur;
    private Item suivant;
    private Boolean vide;

    public Item(int val) {
        this.valeur = val;
        this.suivant = null;
    }

    public Item(Boolean vide) {
        if (vide) {
            this.valeur = -1;
            this.suivant = null;
            this.vide = true;
        }
    }

    public int getVal() {
        return this.valeur;
    }

    public Item getSuivant() {
        return this.suivant;
    }

    public void setSuivant(Item item) {
        this.vide = false;
        this.suivant = item;
    }

    @Override
    public boolean isEmpty(){
        return(this.vide);
    }

    @Override
    public int getSize() {
        Item itCourant = this;
        int i = 0;
        while(itCourant != null) {
            i++;
            itCourant = itCourant.getSuivant();
        }
        return i-1;
    }

    @Override
    public void push(Item item) {
        Item itCourant = this;
        while(itCourant.getSuivant() != null) {
            itCourant = itCourant.getSuivant();
        }
        itCourant.setSuivant(item);
    }

    @Override
    public Item peek() throws EmptyStackException {
        if (this.vide)
            throw new EmptyStackException();

        Item itCourant = this;
        while(itCourant.getSuivant() != null) {
            itCourant = itCourant.getSuivant();
        }
        return itCourant;
    }

    @Override
    public Item pop() throws EmptyStackException {
        if (this.vide)
            throw new EmptyStackException();

        Item itCourant = this;
        Item itPrecedent = new Item(true);
        while(itCourant.getSuivant() != null) {
            itPrecedent = itCourant;
            itCourant = itCourant.getSuivant();
        }
        itPrecedent.setSuivant(null);

        if (itPrecedent.getVal() == -1)
            this.vide = true;

        return itCourant;
    }
}
