package com.meli.modulo6_ex1;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Mesa> mesas;

    public Database() {
        List<Mesa> mesas = new ArrayList<>();
        Mesa mesa1 = new Mesa(1,new ArrayList<Pedido>(), 0);
        Mesa mesa2 = new Mesa(2,new ArrayList<Pedido>(), 0);
        Mesa mesa3 = new Mesa(3,new ArrayList<Pedido>(), 0);
        mesas.add(mesa1);
        mesas.add(mesa2);
        mesas.add(mesa3);
        this.mesas = mesas;
    }

    public void saveMesa(Mesa mesa){
        mesa.setId(mesas.size());
        mesas.add(mesa);
    }

    public Mesa getMesa(int id){
        return mesas.stream().filter(mesa -> mesa.getId() == id).findFirst().orElse(null);
    }

    public List<Mesa> getMesas() {
        return mesas;
    }
}
