package com.filaemjava;


public class Fila<T> {

    private No<T> refNoEntradaFila;

    public Fila() {
        this.refNoEntradaFila = null;
    }

    public void enqueue(T object) {
        No novoNo = new No(object);
        novoNo.setRefNo(refNoEntradaFila);
        refNoEntradaFila = novoNo;
    }



    public T first() {
        if (!this.isEmpety()){
            No primeiroNo = refNoEntradaFila;
            while(true){
                if (primeiroNo.getRefNo() != null){
                    primeiroNo = primeiroNo.getRefNo();
                }else{
                    break;
                }
            }
            return (T) primeiroNo.getObject();
        }
        return null;
    }

    public T dequeue() {
        if (!this.isEmpety()){
            No primeiroNo = refNoEntradaFila;
            No noAuxiliar = refNoEntradaFila;
            while(true){
                if (primeiroNo.getRefNo() != null){
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getRefNo();
                }else{
                    noAuxiliar.setRefNo(null);
                    break;
                }
            }
            return (T) primeiroNo.getObject();

        }
        return null;

    }

    public boolean isEmpety() {
        return this.refNoEntradaFila == null? true: false;
    }

    @Override
    public String toString() {
        String stringRetorno = "";
        No noAuxiliar = refNoEntradaFila;

        if (refNoEntradaFila != null){
            while (noAuxiliar != null) {
                stringRetorno += "[No{objeto=" + noAuxiliar.getObject() + "}]-->";
                noAuxiliar = noAuxiliar.getRefNo();
            }
        }else{
            stringRetorno = "null";
        }

        return stringRetorno;
    }
}
