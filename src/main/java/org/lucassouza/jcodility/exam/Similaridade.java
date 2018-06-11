package org.lucassouza.jcodility.exam;

import java.util.HashMap;
import java.util.Map;

public class Similaridade {

  public static void main(String[] args) {
    Similaridade test = new Similaridade();

    System.out.println(test.solucao(1213)); // 12
    System.out.println(test.solucao(123)); // 6
    System.out.println(test.solucao(100)); // 1
    System.out.println(test.solucao(120)); // 4
    System.out.println(test.solucao(1200)); // 6
    System.out.println(test.solucao(12000)); // 8
    System.out.println(test.solucao(312000)); // 60
    System.out.println(test.solucao(212000)); // 30
    System.out.println(test.solucao(0)); // 1
  }

  public int solucao(int n) {
    Map<Integer, Integer> ocorrencias = new HashMap<>();
    Integer total = this.separarDigitos(n, ocorrencias);
    Integer resultado;
    Integer[] valores;

    valores = ocorrencias.values().toArray(new Integer[ocorrencias.size()]);
    resultado = this.calcularPermutacao(total, valores);

    // Desconsidera os zeros no início
    if (ocorrencias.containsKey(0)) {
      Double quantidadeDeZeros = Double.valueOf(ocorrencias.get(0));
      Double quantidadeDeDigitos = Double.valueOf(total);
      Double provisorio = Double.valueOf(resultado);

      provisorio = provisorio - (provisorio / (quantidadeDeDigitos / quantidadeDeZeros));
      resultado = provisorio.intValue();
    }

    return resultado;
  }

  public Integer calcularPermutacao(Integer total, Integer... combinacoes) {
    Long denominador = 1L;
    Long numerador;
    Long resultado;

    for (Integer combinacao : combinacoes) {
      if (combinacao > 1) {
        denominador = denominador * this.fatorial(combinacao);
      }
    }

    numerador = this.fatorial(total);
    resultado = numerador / denominador;

    return resultado.intValue();
  }

  private Integer separarDigitos(int numero, Map<Integer, Integer> ocorrencias) {
    Integer total = 0;

    while (numero != 0) {
      int digito = numero % 10;

      numero = numero / 10;

      if (ocorrencias.containsKey(digito)) {
        ocorrencias.put(digito, ocorrencias.get(digito) + 1);
      } else {
        ocorrencias.put(digito, 1);
      }

      total++;
    }

    return total;
  }

  private Long fatorial(Integer numero) {
    Long resultado = 1L;

    for (int fator = 2; fator <= numero; fator++) {
      resultado = resultado * fator;
    }

    return resultado;
  }
}
