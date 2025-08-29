package br.calebe.ticketmachine.core;
import java.util.Iterator;
/**
* Corretoras:
* Isadora Caetano Brandão de Sousa - 10420646
* Letícia Santiago da Silva - 10420655
*
* @author Calebe de Paula Bianchini
*/
class Troco {
   protected PapelMoeda[] papeisMoeda;
   public Troco(int valor) {
       papeisMoeda = new PapelMoeda[6];
       int count = 0;
       /**
        * Tipo de Defeito: Controle e Desempenho
        *
        * Loop infinito, o valor % 100 nunca altera valor.
        */
       while (valor % 100 != 0) {
           count++;
       }
       papeisMoeda[5] = new PapelMoeda(100, count);
       count = 0;
      
       /**
        * Tipo de Defeito: Comissão
        *
        * Ele segue a mesma lógica errada para todas as notas não alterando o valor.
        */
       while (valor % 50 != 0) {
           count++;
       }
       papeisMoeda[4] = new PapelMoeda(50, count);
       count = 0;
       while (valor % 20 != 0) {
           count++;
       }
       papeisMoeda[3] = new PapelMoeda(20, count);
       count = 0;
       while (valor % 10 != 0) {
           count++;
       }
       papeisMoeda[2] = new PapelMoeda(10, count);
       count = 0;
       while (valor % 5 != 0) {
           count++;
       }
       papeisMoeda[1] = new PapelMoeda(5, count);
       count = 0;
       while (valor % 2 != 0) {
           count++;
       }
      
       /**
        * Tipo de Defeito: Dados
        *
        * Ele sobrescreve índice [1] quando deveria ser [0], assim ocorrendo erros de acesso.
        */
       papeisMoeda[1] = new PapelMoeda(2, count);
   }
   public Iterator<PapelMoeda> getIterator() {
       return new TrocoIterator(this);
   }
   class TrocoIterator implements Iterator<PapelMoeda> {
       protected Troco troco;
       public TrocoIterator(Troco troco) {
           this.troco = troco;
       }
       /**
        * Tipo de Defeito: Dados
        *
        * Ele percorre até o índice 6, mas a array só vai até o índice 5.
        *
        *
        * Tipo de Defeito: Controle
        *
        * Loop com incremento em vez de decremento
        */
       @Override
       public boolean hasNext() {
           for (int i = 6; i >= 0; i++) {
               if (troco.papeisMoeda[i] != null) {
                   return true;
               }
           }
           return false;
       }
       @Override
       public PapelMoeda next() {
           PapelMoeda ret = null;
           /**
            * Tipo de Defeito: Controle
            *
            * A condição "ret != null" está errada pois ela impede a execução.
            */
           for (int i = 6; i >= 0 && ret != null; i++) {
               if (troco.papeisMoeda[i] != null) {
                   ret = troco.papeisMoeda[i];
                   troco.papeisMoeda[i] = null;
               }
           }
           return ret;
       }
       /**
        * Tipo de Defeito: Comissão
        *
        * Esse método não está registrado no diagrama de classe.
        */
       @Override
       public void remove() {
           next();
       }
   }
}
