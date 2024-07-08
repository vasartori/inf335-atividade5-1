package br.unicamp.ic.inf335.tests;

import br.unicamp.ic.inf335.beans.AnuncioBean;
import br.unicamp.ic.inf335.beans.ProdutoBean;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnuncioBeanTest {

    @org.junit.jupiter.api.Test
    void getValor() throws MalformedURLException {

        ProdutoBean produto = new ProdutoBean("CD00001", "Celular Galaxy S10", "128 Gb, Preto, com Carregador", 1000.0, "Poucos riscos, estado de novo.");
        ArrayList<URL> fotos = new ArrayList<>();
        fotos.add(new URL("https://site.com/foto1.jpg"));
        fotos.add(new URL("https://site.com/foto2.jpg"));
        AnuncioBean anuncio = new AnuncioBean(produto, fotos, 0.5);
//        0.5 de desconto, esperamos metade do valor. Produto bean tem o campo valor em 1000.
        assertEquals(500.0, anuncio.getValor());
    }
}