package com.prodata.curso.starter.exercicios.olaMundo;

public class OlaMundo {
    public static void main(String[] args) {
        System.out.println("Olá, Mundo!");
        metodoPrivado(); //Chamada de um método
        metodoProtegido(metodoPublico()); //Chamada encapsulada - Executa primeiro "metodoPublico" e depois "metodoProtegido"
    }

    private static void metodoPrivado() {
        /* Acessível apenas dentro desta classe */
    }

    protected static void  metodoProtegido(String paramTexto) {
        /* Aceessível a outras classes dentro da mesma pasta/pacote */
    }

    public static String metodoPublico(){
        /* Acessível a qualquer classe do projeto */
        return "Retorna um texto";
    }
}

