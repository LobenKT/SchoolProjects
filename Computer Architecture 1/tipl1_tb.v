//TIPAN, LOBEN KLIEN A. | CSARCH1 S15
//F=A(CD+B)+BC' 
//MODEL USED: BEHAVIORAL MODELING 
`timescale 10ns/1ps
`include "tipl1.v"

module circuit_behavior_tb();
    reg[3:0] t_input;
    wire t_D;
    integer i;

    circuit_behavior dut(t_F,t_input[3],t_input[2], t_input[1], t_input[0]);
    
    initial
    begin
        t_input = 3'b000;
        for (i=1; i<17; i=i+1)
        begin
            #30 t_input = i;
        end
    end
    initial  //response monitor 
    begin
        $display("AUTHOR: LOBEN TIPAN");
        $monitor("time = %0d ",$time, "A = %b B = %b C = %b input_D = %b output_F = %b", t_input[3],t_input[2], t_input[1], 
        t_input[0],t_F);
        $dumpfile("tipl1.vcd");
        $dumpvars();    
    end
endmodule