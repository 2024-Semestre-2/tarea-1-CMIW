/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP1;

import java.util.Arrays;

/**
 *
 * @author someone
 */
public class Memory {
    private Object[] memoryArray; // Using Object to hold both instructions and data
    private int nextInstructionAddress; // User segment for instructions
    private int nextDataAddress; // Segment for data
    private int instructionAddresSize = 50;
    private int dataAddressSize = 100;
    private int memorySize;
    
    public Memory(int size) {
        if (size >= this.dataAddressSize + this.instructionAddresSize) {
            this.memorySize = size;
        } else {
            this.memorySize = this.dataAddressSize + this.instructionAddresSize;
        }
        this.nextInstructionAddress = 0;
        this.nextDataAddress = instructionAddresSize;
        this.memoryArray = new Object[this.memorySize];
    }
    
    public void loadInstruction(String opcode, String operation, String[] operands) {
        if (this.nextInstructionAddress > instructionAddresSize) { // Assuming 0-19 is OS segment
            throw new IllegalArgumentException("Attempt to access OS segment or out-of-bounds memory address");
        }
        memoryArray[this.nextInstructionAddress] = new Instruction(opcode, operation, operands, this.nextInstructionAddress);
        this.nextInstructionAddress++;
    }
    
    public Instruction getInstruction(int address) {
        if (address > instructionAddresSize) { // Assuming 0-19 is OS segment
            throw new IllegalArgumentException("Attempt to access OS segment or out-of-bounds memory address");
        } else {
            return (Instruction) this.memoryArray[address];
        }
    }
    
    public Object[] getMemoryArray() {
        return Arrays.copyOfRange(this.memoryArray, 0, instructionAddresSize);
    }
    
    public int instructionAddresSize() {
        return this.instructionAddresSize;
    }
}
