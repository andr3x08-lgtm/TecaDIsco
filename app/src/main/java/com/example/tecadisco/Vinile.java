package com.example.tecadisco;

public class Vinile {
    private String mTitolo;
    private String mArtista;
    private int mAnno;
    private int mValore;

    public Vinile(String titolo, String artista, int anno, int valore) {
        mTitolo = titolo;
        mArtista = artista;
        mAnno = anno;
        mValore = valore;
    }

    public String getTitolo() { return mTitolo; }
    public String getArtista() { return mArtista; }
    public int getAnno() { return mAnno; }
    public int getValore() { return mValore; }
}
