package javaapplication1;

import javax.swing.JOptionPane;

public class JavaApplication1 {

    public static void main(String[] args) {
        
        int acao = 1, contador = 0, contador2 = 0;
        float media = 0, totalNotas = 0, mediaTurma = 0, resultado = 0;
        float [] notas = new float [999];
        float [] medias = new float [999];
        String [] alunos = alunos = new String [999];
        int quantidadeNotas = 0, quantidadeAlunos = 0;
        int inserirNota = 0;
        
        quantidadeAlunos = Integer.parseInt(JOptionPane.showInputDialog("Quantos alunos na classe?"));
        
           for (int i = 0; i < quantidadeAlunos; i++) {
            
            alunos [i] = JOptionPane.showInputDialog("Nome do Aluno");
            
        }
        
        do {
           
           Object selectedValue = JOptionPane.showInputDialog(null,"Escolha um item", "Opçao",
              JOptionPane.INFORMATION_MESSAGE, null,
                  alunos, alunos [0]); //
        
        
        quantidadeNotas = Integer.parseInt(JOptionPane.showInputDialog(selectedValue + "\n" + "Quantas notas deseja inserir?"));
        
        for (int i = 0; i < quantidadeNotas; i++) {
              
            notas [i] = Float.parseFloat(JOptionPane.showInputDialog("Insira a nota"));
            
            contador++;
            
        }
        
        for (int i = 0; i < contador; i++) {
            
            totalNotas += notas [i];
            
        }
        
        media = totalNotas / quantidadeNotas;
        
        medias [contador2] = media;
        
        contador2++;
        contador = 0;
        
        acao = Integer.parseInt(JOptionPane.showInputDialog("Deseja continuar? \n 1- sim \n 2- não"));
        
        } while (acao == 1);
        
        for (int i = 0; i < contador2; i++) {
            
            mediaTurma += medias [i];
            
        }
         
        resultado = mediaTurma / contador;
        
        JOptionPane.showMessageDialog(null, "A media da turma é " + resultado);
        
    }
    
}
