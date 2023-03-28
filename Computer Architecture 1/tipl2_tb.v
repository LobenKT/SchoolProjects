// Loben Tipan S13

`timescale 1ns/1ps

module HYBRID_ADDER_TB();
    reg[7:0] X,Y;
    reg C0;
    wire[7:0] S;
    wire C8;

    ADDER_MAIN dut (X[0],X[1],X[2],X[3],X[4],X[5],X[6],X[7], 
    Y[0],Y[1],Y[2],Y[3],Y[4],Y[5],Y[6],Y[7], 
    S[0],S[1],S[2],S[3],S[4],S[5],S[6],S[7], 
    C0, C8);

    initial begin
		    X = 8'b01100000;
		    Y = 8'b01111111;
		    C0 = 0;

		#10 X = 8'b11111111; 
			Y = 8'b11111110;

		#10 X = 8'b10101010; 
			Y = 8'b01010101;
		
        #10 X = 8'b00001000; 
			Y = 8'b10000001;

		#10 X = 8'b00001000; 
			Y = 8'b10000001;
            C0 = 1;

		#10 X = 8'b00000001; 
			Y = 8'b00000000;
		

		#10 X = 8'b11110000; 
			Y = 8'b10001000;
		
	end
    
    initial begin
        $display("Author: Loben Tipan S13");
        $display("2-bit ripple carry_3-bit carry lookahead_3-bit ripple carry");
        $monitor("time = %0d \tinput: \tX = %b  Y = %b \t C0 = %b \n\t\toutput: S = %b \t C8 = %b\n", $time, X, Y, C0, S, C8);
        $dumpfile("tipl2.vcd");
        $dumpvars(0,HYBRID_ADDER_TB);
    end

endmodule