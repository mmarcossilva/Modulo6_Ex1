package com.meli.modulo6_ex1;

import java.util.List;

public class Pedido {
    private int id;
    private int mesaId;
    private List<Prato> pratos;
    private double valorTotal;

    public Pedido(int id, int mesaId, List<Prato> pratos) {
        this.id = id;
        this.mesaId = mesaId;
        this.pratos = pratos;
        this.valorTotal = pratos.stream().mapToDouble(Prato::getPreco).sum();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMesaId() {
        return mesaId;
    }

    public void setMesaId(int mesaId) {
        this.mesaId = mesaId;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
