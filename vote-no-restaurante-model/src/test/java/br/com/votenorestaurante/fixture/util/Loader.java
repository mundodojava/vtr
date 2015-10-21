package br.com.votenorestaurante.fixture.util;

import java.util.List;

import br.com.six2six.fixturefactory.Fixture;

public class Loader {

    public static <T> T gimme(Class<T> clazz, String label) {
        return gimme(1, clazz, label).get(0);
    }

    public static <T> List<T> gimme(int qtd, Class<T> clazz, String label) {
        return Fixture.from(clazz).gimme(qtd, label);
    }

}
