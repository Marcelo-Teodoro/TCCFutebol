/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author Pgz
 */
public enum EnumPosicao {
    
    GOLEIRO("Goleiro", "Defesa"), 
    L_DIREITA("Lateral Direita","Defesa"),
    L_ESQUERDA("Lateral Esquerda","Defesa"),
    ZAGUEIRO("Zagueiro","Defesa"),
    LIBERO("Libero","Defesa"),
    
    MEIO_DEFENSIVO("Meio-Campo Defensivo","Meio Campo"),
    ALA_DIREITO("Ala Direito","Meio Campo"),
    ALA_ESQUERDO("Ala Esquerdo","Meio Campo"),
    MEIO_CAMPO("Meio-Campo","Meio Campo"),
    MEDIO_DIREITO("Meio Direito","Meio Campo"),
    MEDIO_ESQUERDO("Meio Esquerdo","Meio Campo"),
    MEIO_OFENSIVO("Meio-Campo Ofensivo","Meio Campo"),
    EXTREMO_DIREITO("Extremo Direito","Meio Campo"),
    EXTREMO_ESQUERDO("Extremo Esquerdo","Meio Campo"),
    
    PONTA_DIREITA("Ponta Direita","Atacante"),
    PONTA_ESQUERDA("Ponta Esquerda","Atacante"),
    ATACANTE("Atacante","Atacante"),
    CENTRO_AVANTE("Centro Avante","Atacante");
    
    private String posicao;
    private String funcao;

    private EnumPosicao(String posicao, String funcao) {
        this.posicao = posicao;
        this.funcao = funcao;
    }
    
    
}
