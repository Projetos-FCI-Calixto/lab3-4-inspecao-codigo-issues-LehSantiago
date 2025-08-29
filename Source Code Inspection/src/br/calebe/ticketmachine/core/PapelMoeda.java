package br.calebe.ticketmachine.core;
/**
* Corretoras:
* Isadora Caetano Brandão de Sousa - 10420646
* Letícia Santiago da Silva - 10420655
*
* @author Calebe de Paula Bianchini
*/
public class PapelMoeda {
   protected int valor;
   protected int quantidade;
   /*
	 * Tipo de Defeito: Comissão
	 *
	 * Não há validação para verificar se os valores são negativos.
	 * */
   public PapelMoeda(int valor, int quantidade) {
       this.valor = valor;
       this.quantidade = quantidade;
   }
   public int getValor() {
       return valor;
   }
   public int getQuantidade() {
       return quantidade;
   }
}
