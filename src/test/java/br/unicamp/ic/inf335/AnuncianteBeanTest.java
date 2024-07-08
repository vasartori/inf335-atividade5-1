package br.unicamp.ic.inf335.tests;

import br.unicamp.ic.inf335.beans.AnuncianteBean;
import br.unicamp.ic.inf335.beans.AnuncioBean;
import br.unicamp.ic.inf335.beans.ProdutoBean;
import java.net.MalformedURLException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AnuncianteBeanTest {

    private ArrayList<AnuncioBean> anuncios;

    @BeforeEach
    void setUp() throws MalformedURLException{
        ProdutoBean produto1 = new ProdutoBean("CD00001", "Celular Galaxy S10", "128 Gb, Preto, com Carregador", 1000.0, "Poucos riscos, estado de novo.");
        ProdutoBean produto2 = new ProdutoBean("CD00002", "Celular Galaxy S15", "128 Gb, Preto, com Carregador", 1500.0, "Poucos riscos, estado de novo.");
        ProdutoBean produto3 = new ProdutoBean("CD00003", "Celular Galaxy S20", "128 Gb, Preto, com Carregador", 2000.0, "Poucos riscos, estado de novo.");
        ArrayList<URL> fotos = new ArrayList<>();
        fotos.add(new URL("https://site.com/foto1.jpg"));
        fotos.add(new URL("https://site.com/foto2.jpg"));
        AnuncioBean anuncio1 = new AnuncioBean(produto1, fotos, 0.5);
        AnuncioBean anuncio2 = new AnuncioBean(produto2, fotos, 0.2);
        AnuncioBean anuncio3 = new AnuncioBean(produto3, fotos, 0.1);

        ArrayList<AnuncioBean> anuncios = new ArrayList<>();
        anuncios.add(anuncio1);
        anuncios.add(anuncio2);
        anuncios.add(anuncio3);
        this.anuncios = anuncios;
    }

    @Test
    void getAnuncios() {
        AnuncianteBean anunciante = new AnuncianteBean("Joao do Teste", "123.456.789-00", this.anuncios);
        assertEquals(3, anunciante.getAnuncios().size());
    }

    @Test
    void setAnuncios() throws MalformedURLException {
        AnuncianteBean anunciante = new AnuncianteBean("Joao do Teste", "123.456.789-00", this.anuncios);
        ProdutoBean produto4 = new ProdutoBean("CD00003", "Celular Galaxy S24", "128 Gb, Preto, com Carregador", 4000.0, "Novo.");
        ArrayList<URL> fotos = new ArrayList<>();
        fotos.add(new URL("https://site.com/foto1.jpg"));
        fotos.add(new URL("https://site.com/foto2.jpg"));
        AnuncioBean anuncioNovo = new AnuncioBean(produto4, fotos, 0.0);
        this.anuncios.add(anuncioNovo);

        anunciante.setAnuncios(this.anuncios);

        assertEquals(4, this.anuncios.size());

    }

    @Test
    void addAnuncio() throws MalformedURLException {
        AnuncianteBean anunciante = new AnuncianteBean("Joao do Teste", "123.456.789-00", this.anuncios);
        ProdutoBean produto4 = new ProdutoBean("CD00003", "Celular Galaxy S19", "128 Gb, Preto, com Carregador", 3000.0, "Novo.");
        ArrayList<URL> fotos = new ArrayList<>();
        fotos.add(new URL("https://site.com/foto1.jpg"));
        fotos.add(new URL("https://site.com/foto2.jpg"));
        AnuncioBean anuncioNovo = new AnuncioBean(produto4, fotos, 0.0);

        anunciante.addAnuncio(anuncioNovo);

        assertEquals(4, anunciante.getAnuncios().size());

    }

    @Test
    void removeAnuncio() {
        AnuncianteBean anunciante = new AnuncianteBean("Joao do Teste", "123.456.789-00", this.anuncios);
        anunciante.removeAnuncio(0);

        assertEquals(2, anunciante.getAnuncios().size());
    }

    @Test
    void valorMedioAnuncios()  {
        AnuncianteBean anunciante = new AnuncianteBean("Joao do Teste", "123.456.789-00", this.anuncios);
        Double valorMedio = anunciante.valorMedioAnuncios();

        assertEquals(1166.67, valorMedio);

    }
}