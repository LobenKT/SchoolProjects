//TIPAN, LOBEN KLIEN A. | CSARCH1 S15
//BOOLEAN FUNCTION: F=A(CD+B)+BC' 
//MODEL USED: BEHAVIORAL MODELING 

module circuit_behavior(F,A,B,C,D);

    input A,B,C,D;
    output reg F;

    always @(A,B,C,D) 
    begin
        F = A & ( C & D | B ) | B & ~C;
    end

endmodule

