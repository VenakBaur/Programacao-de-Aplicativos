package animal;

import javax.swing.JOptionPane;

public class Animal {
  String nome;
   String especie;
   String peso;
   String cor;
   int idade;
   
   public Animal(){
   }
   
   public Animal(String nome,String especie, String peso,String cor, int idade ){
       
       this.nome = nome;
       this.especie = especie;
       this.peso = peso;
       this.cor = cor;
       this.idade = idade;
       
   }
   
   public void alimentar(){
       
       JOptionPane.showMessageDialog(null , "O animal se alimentando! ");
   }
   
   public String movimentar(){
       
       String move = JOptionPane.showInputDialog("Como ele se movimenta!");
       return move;
   }
   
   public float calcularTamanho(float comprimento, float largura){
       
       float tamanho = comprimento*largura;
       return tamanho;
   }
}
