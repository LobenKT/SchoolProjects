/* LOBEN TIPAN CSARCH1  S13
    HDL3 
*/
module D_FLIPFLOP(Q,D, clk, rst);
input D;
input clk, rst;
output reg Q;

 always @(posedge clk, negedge rst) begin

    if (rst == 0)
        Q <= 0;
    else begin 
        case (D)
            1'b0: Q <= 0;
            1'b1: Q <= 1;
        endcase
    end
 end

endmodule

module BCD(A,B,C,D, X, clk, rst);
    input X, clk, rst;
    output A,B,C,D;
    wire DA, DB, DC,DD;

    assign DA = (~A & ~B & ~C & ~D & X) | (~A & B & C & D & ~X) | (A & ~B & ~C & ~D & ~X) | (A & ~B & ~C & D & X);
    assign DB = (~A & ~B & C & D & ~X) | (A & ~B & ~C & ~D & X) | (~A & B & ~C & ~X) | (~A & B & D & X) | (~A & B & C & ~D);
    assign DC = (~A & ~C & D & ~X) | (~A & C & ~D & ~X) | (~A & C & D & X) | (~A & B & ~C & ~D & X) | (A & ~B & ~C & ~D & X);
    assign DD = (~A & ~D) | (~B & ~C & ~D);

    D_FLIPFLOP F3(A, DA, clk, rst);
    D_FLIPFLOP F2(B, DB, clk, rst);
    D_FLIPFLOP F1(C, DC, clk, rst);
    D_FLIPFLOP F0(D, DD, clk, rst);
endmodule