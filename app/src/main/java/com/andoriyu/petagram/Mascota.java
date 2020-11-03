package com.andoriyu.petagram;

public class Mascota {
    private String nombre;
    private String votos;
    private int foto;

    public Mascota(String nombre, String votos, int foto) {
        this.nombre = nombre;
        this.votos = votos;
        this.foto = foto;
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {  this.nombre = nombre;}

    public String getVotos() {  return votos; }

    public void setVotos(String votos) {  this.votos = votos; }

    public int getFoto() {  return foto;  }

    public void setFoto(int foto) {  this.foto = foto; }
}
