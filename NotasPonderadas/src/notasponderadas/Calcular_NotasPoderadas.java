/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notasponderadas;

/**
 *
 * @author Emerson
 */
public class Calcular_NotasPoderadas {
    
    private boolean cbNota1;
    private boolean cbNota2;
    private boolean cbNota3;
    private boolean cbNota4;
    private boolean cbNota5;
    // colua das notas
    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;
    private double nota5;
    // coluna dos pesos
    private double peso1;
    private double peso2;
    private double peso3;
    private double peso4;
    private double peso5;
    // variaveis de instacia de saida
    private double mediaFinal;
    private double totalDosPesos;
    
    // variaveis de instancia de negocios
    private boolean calculoTemPeso;
    
    
    public Calcular_NotasPoderadas() {
        limpar();
    }
    
    public void limpar() {
        this.cbNota1 = true;
        this.cbNota2 = true;
        this.cbNota3 = true;
        this.cbNota4 = true;
        this.cbNota5 = true;
        this.nota1 = 0;
        this.nota2 = 0;
        this.nota3 = 0;
        this.nota4 = 0;
        this.nota5 = 0;
        this.peso1 = 0;
        this.peso2 = 0;
        this.peso3 = 0;
        this.peso4 = 0;
        this.peso5 = 0;
        this.mediaFinal = 0;
        this.totalDosPesos = 0;
        this.calculoTemPeso = true;
        
    }
    
     // conceito de encapsulamento
    // set's/get's metoidos modificadores/acessores
    public boolean isCbNota1() {
        return cbNota1;
    }

    public boolean isCbNota2() {
        return cbNota2;
    }

    public boolean isCbNota3() {
        return cbNota3;
    }

    public void setCbNota3(boolean cbNota3) {
        this.cbNota3 = cbNota3;
    }

    public boolean isCbNota4() {
        return cbNota4;
    }

    public void setCbNota4(boolean cbNota4) {
        this.cbNota4 = cbNota4;
    }

    public boolean isCbNota5() {
        return cbNota5;
    }

    public void setCbNota5(boolean cbNota5) {
        this.cbNota5 = cbNota5;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double getNota4() {
        return nota4;
    }

    public void setNota4(double nota4) {
        this.nota4 = nota4;
    }

    public double getNota5() {
        return nota5;
    }

    public void setNota5(double nota5) {
        this.nota5 = nota5;
    }

    public double getPeso1() {
        return peso1;
    }

    public void setPeso1(double peso1) {
        this.peso1 = peso1;
    }

    public double getPeso2() {
        return peso2;
    }

    public void setPeso2(double peso2) {
        this.peso2 = peso2;
    }

    public double getPeso3() {
        return peso3;
    }

    public void setPeso3(double peso3) {
        this.peso3 = peso3;
    }

    public double getPeso4() {
        return peso4;
    }

    public void setPeso4(double peso4) {
        this.peso4 = peso4;
    }

    public double getPeso5() {
        return peso5;
    }

    public void setPeso5(double peso5) {
        this.peso5 = peso5;
    }

    public double getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(double mediaFinal) {
        this.mediaFinal = mediaFinal;
    }

    public void setTotalDosPesos(double totalDosPesos) {
        this.totalDosPesos = totalDosPesos;
    }

    public double getTotalDosPesos() {
        return totalDosPesos;
    }

    public boolean isCalculoTemPeso() {
        return calculoTemPeso;
    }

    public void setCalculoTemPeso(boolean calculoTemPeso) {
        this.calculoTemPeso = calculoTemPeso;
    }

    // regras de negocio
    public void calcularAMedia() {
        if (calculoTemPeso) {
            // instrcuções para calcular com peso
            if (isCbNota1() && isCbNota2()) {
                totalDosPesos = peso1 + peso2;
                mediaFinal = (nota1 * peso1 + nota2 * peso2) / totalDosPesos;
            }
            if (isCbNota1() && isCbNota2() && isCbNota3()) {
                totalDosPesos = peso1 + peso2 + peso3;
                mediaFinal = (nota1 * peso1 + nota2 * peso2 + nota3 * peso3)
                        / totalDosPesos;
            }
            if (isCbNota1() && isCbNota2() && isCbNota3() && isCbNota4()) {
                totalDosPesos = peso1 + peso2 + peso3 + peso4;
                mediaFinal = (nota1 * peso1 + nota2 * peso2 + nota3 * peso3 + 
                        nota4 * peso4) / totalDosPesos;
            }
            if (isCbNota1() && isCbNota2() && isCbNota3() && isCbNota4() && 
                    isCbNota5()) {
                totalDosPesos = peso1 + peso2 + peso3 + peso4 + peso5;
                mediaFinal = (nota1 * peso1 + nota2 * peso2 + nota3 * peso3 + 
                        nota4 * peso4 + nota5 * peso5) / totalDosPesos;
            }
        } else {
            // INSTRUÇÕES PARA CALCULARSEM PESO

            if (isCbNota1() && isCbNota2()) {
                mediaFinal = (nota1 + nota2) / 2;
            }
            if (isCbNota1() && isCbNota2() && isCbNota3()) {
                mediaFinal = (nota1 + nota2 + nota3) / 3;
            }
            if (isCbNota1() && isCbNota2() && isCbNota3() && isCbNota4()) {
                mediaFinal = (nota1 + nota2 + nota3 + nota4) / 4;
            }
            if (isCbNota1() && isCbNota2() && isCbNota3() && isCbNota4() && 
                    isCbNota5()) {
                mediaFinal = (nota1 + nota2 + nota3 + nota4 + nota5) / 5;
            }
        }
    }
    
}
