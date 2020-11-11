package com.prodata.curso.starter.exercicios.variaveis;

import java.util.List;
import java.util.Map;

public class Referenciais {
    private Map<String, Object> objetoMap;
    private List<Map<String, Object>> objetoListaDeMap;
    private Primitivas objetoClassePrimitiva;

    private static final int INDEX_RETORNA_OBJETO_MAP = 0;

    public void acessoVariavelMapList() {
        Object valorMap =
                objetoMap.get("nome_chave_objeto");

        Map<String, Object> valorList =
                objetoListaDeMap.get(INDEX_RETORNA_OBJETO_MAP);
    }

    public void acessoVariavelClasse() {
        int variavelInteira =
                objetoClassePrimitiva.getInteira4Bytes();
    }
}
