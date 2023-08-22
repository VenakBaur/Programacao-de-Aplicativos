package atividade.math;

import javax.swing.JOptionPane;

public class AtividadeMath {

    public static void main(String[] args) {
        
        //a) Peça ao usuário para informar dois números: x e y
        
        int numero1 = 0, numero2 = 0;
        int aleatorio = 0;
        
        numero1 = Integer.parseInt(JOptionPane.showInputDialog("Insira um numero"));
        
        numero2 = Integer.parseInt(JOptionPane.showInputDialog("Insira um numero"));
                
        JOptionPane.showMessageDialog(null, "Menor " + Math.min(numero1,numero2));
        
        //b) Use o método correto para encontrar o valor maior de x e y.
        
        JOptionPane.showMessageDialog(null, "Maior " + Math.max(numero1,numero2));
        
        //c) Use o método correto para encontrar o valor menor de x e y
        
        JOptionPane.showMessageDialog(null, "Menor " + Math.min(numero1,numero2));
        
        //d) Use o método correto para encontrar a raiz quadrada x e de y
        
        JOptionPane.showMessageDialog(null, "Raiz quadrada " + Math.sqrt(numero1));

        JOptionPane.showMessageDialog(null, "Raiz quadrada " + Math.sqrt(numero2));
        
        //e) Use o método correto para elevar ao cubo x e ao quadrado y

        JOptionPane.showMessageDialog(null, "Elevado ao cubo " + Math.pow(numero1,3));
        
        JOptionPane.showMessageDialog(null, "Elevado ao quadrado " + Math.pow(numero2,2));
        
        //f) Use o método correto para retornar um número aleatório entre 0 e 10.
        
        aleatorio = (int)(Math.random() * 10);
        
        JOptionPane.showMessageDialog(null, "Numero sorteado " + aleatorio);
        
    }
    
}
