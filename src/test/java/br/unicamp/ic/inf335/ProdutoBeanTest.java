package br.unicamp.ic.inf335.tests;

import br.unicamp.ic.inf335.beans.ProdutoBean;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoBeanTest {

    @Test
    void compareTo() {
        ArrayList<ProdutoBean> produtos = new ArrayList<ProdutoBean>();
        ProdutoBean produto1 = new ProdutoBean("CD00001", "Celular Galaxy S20", "128 Gb, Preto, com Carregador", 2000.0, "Poucos riscos, estado de novo.");
        ProdutoBean produto2 = new ProdutoBean("CD00002", "Celular Galaxy S10", "128 Gb, Preto, com Carregador", 1000.0, "Poucos riscos, estado de novo.");
        ProdutoBean produto3 = new ProdutoBean("CD00003", "Celular Galaxy S15", "128 Gb, Preto, com Carregador", 1500.0, "Poucos riscos, estado de novo.");
        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);

        Collections.sort(produtos);

//        Esperamos que os produtos sejam ordenados de acordo com seu valor
//        o valor menor vem primeiro

        assertEquals(1000.0, produtos.get(0).getValor());
        assertEquals(1500.0, produtos.get(1).getValor());
        assertEquals(2000.0, produtos.get(2).getValor());


    }
}