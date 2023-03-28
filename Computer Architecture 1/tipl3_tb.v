/* LOBEN TIPAN CSARCH S-13*/

`timescale 1ns/1ps

module D_FLIPFLOP_tb();
    wire A,B,C,D;
    reg t_x, t_clk, t_rst;

    BCD dut (A, B, C, D, t_x, t_clk, t_rst);

    initial 
        begin
            t_clk = 1'b0;
            forever #5 t_clk = ~t_clk;
        end

    initial 
        begin
            t_rst = 1'b0;
            #5 t_rst = 1'b1;
        end
    
    initial begin
        t_x = 1'b0;
        #105 t_x = 1'b1;
    end

    initial #45 $finish;

    initial 
        begin
            $display("LOBEN TIPAN: Up Down BCD counter with D Flip Flop");
            $monitor("time: %0d, clk: %b, x: %b, rst: %b ----- %b%b%b%b", $time, t_clk, t_x, t_rst, A, B, C, D);
            $dumpfile("DFLIPFLOP.vcd");
            $dumpvars();
        end
endmodule