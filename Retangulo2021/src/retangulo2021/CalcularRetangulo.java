
package retangulo2021;


public class CalcularRetangulo {
 //variabeis de instancia   
 private double LadoA;
 private double LadoB;
 private double Perimetro;
 private double Area;
 
 //metodo construtor
 public void  CalcularRetangulo() {
limpar();
     
 }
 
 public void limpar() {
  this.LadoA = 0;
  this.LadoB = 0;
  this.Perimetro = 0;
  this.Area = 0;
     
 }         
 
 // encapsulamento
 // metodos acessores / modificadore
 // metodos get's / set's
 
 public void setLadoA(double LadoA){
     this.LadoA = LadoA;
 }
 public double getLadoA(){
     return this.LadoA;
 }
 
  public void setLadoB(double LadoB){
     this.LadoB = LadoB;
 }
 public double getLadoB(){
     return this.LadoB;
 }
 
 public double getPerimetro(){
     return this.Perimetro;
 }
 
 public double getArea(){
     return this.Area;
 }
 
 //metodos de negocio
 public void calcularPerimetro(){
     this.Perimetro = this.LadoA * 2 + this.LadoB * 2;
 }
 
 public void calcularArea(){
     this.Area = this.LadoA * this.LadoB;
 }
 //public void acaobotaolimpa(){
//Perimetro.setText("");
//Area.setText("");
//}
 
}
