/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP1;

/**
 *
 * @author someone
 */
public class Instruction {
    String opcode;
    String operation;
    String[] operands;
    int memoryAddress;
    
    public Instruction(String opcode, String operation, String[] operands, int memoryAddress) {
        this.opcode = opcode;
        this.operation = operation;
        this.operands = operands;
        this.memoryAddress = memoryAddress;
    }
}
