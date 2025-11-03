/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aulatries;

/**
 *
 * @author luizfkm
 */
public class NoTrie {
    //tamanho fixo para o alfabeto
    private static final int TAMANHO_ALFABETO = 26;
    
    //Aray de ponteiros para os filhos
    public NoTrie[] filhos;
    
    //flag para marcar se este no eh uma palavra completa
    public boolean fimPalavra;
    
    public NoTrie(){
        this.fimPalavra = false;
        this.filhos = new NoTrie[TAMANHO_ALFABETO];
    }
    
    
    
    
    
    
}
