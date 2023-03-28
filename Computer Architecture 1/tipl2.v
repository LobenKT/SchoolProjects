//Loben Tipan S13
//8-bit hybrid adder circruit

`timescale 1ns/1ps

module HALF_ADDER(S,C,X,Y);
    input X, Y;
    output S, C;

    xor G1(S,X,Y);
    and G2(C,X,Y);

endmodule

module FULL_ADDER(S,C,X,Y,Z);
    input X,Y,Z;
    output S, C;
    wire S1, C1, C2;

    HALF_ADDER F1(S1,C1,X,Y);
    HALF_ADDER F2(S,C2,S1,Z);
    or (C,C2,C1);

endmodule

module NO_CARRYOUT_FULL_ADDER(S,X,Y,Z);
    input X,Y,Z;
    output S;
    wire S1, C1, C2;

    HALF_ADDER F1(S1,C1,X,Y);
    HALF_ADDER F2(S,C2,S1,Z);

endmodule

module PG_GENERATOR(P,G,X,Y);
    input X,Y;
    output P,G;

    xor A1(P,X,Y);
    and A2(G,X,Y);

endmodule

module CARRY_LOOKAHEAD_GENERATOR(P0,P1,P2,P3,P4, G0,G1,G2,G3,G4, C0,C1,C2,C3,C4,C5);
    input P0,P1,P2,P3,P4, G0,G1,G2,G3,G4, C0;
    output C1,C2,C3,C4,C5;

    assign C1=G0|(P0&C0);
	assign C2=G1|(P1&C1);
	assign C3=G2|(P2&C2);
	assign C4=G3|(P3&C3);
	assign C5=G4|(P4&C4);

endmodule

module ADDER_MAIN(X0,X1,X2,X3,X4,X5,X6,X7, Y0,Y1,Y2,Y3,Y4,Y5,Y6,Y7, S0,S1,S2,S3,S4,S5,S6,S7, C0,C8);
    input X0,X1,X2,X3,X4,X5,X6,X7, Y0,Y1,Y2,Y3,Y4,Y5,Y6,Y7, C0;
    output S0,S1,S2,S3,S4,S5,S6,S7, C8;
    wire P0,P1,P2,P3,P4, G0,G1,G2,G3,G4, C1,C2,C3,C4,C5,C6,C7;

    PG_GENERATOR PG1(P0,G0,X0,Y0);
    PG_GENERATOR PG2(P1,G1,X1,Y1);
    PG_GENERATOR PG3(P2,G2,X2,Y2);
    PG_GENERATOR PG4(P3,G3,X3,Y3);
    PG_GENERATOR PG5(P4,G4,X4,Y4);
    CARRY_LOOKAHEAD_GENERATOR CL1(P0,P1,P2,P3,P4, G0,G1,G2,G3,G4, C0,C1,C2,C3,C4,C5);

    
    FULL_ADDER F1(S0,C1,X0,Y0,C0);
    NO_CARRYOUT_FULL_ADDER F2(S1,X1,Y1,C1);

    
    NO_CARRYOUT_FULL_ADDER SUM1(S2,X2,Y2,C2);
    NO_CARRYOUT_FULL_ADDER SUM2(S3,X3,Y3,C3);
    NO_CARRYOUT_FULL_ADDER SUM3(S4,X4,Y4,C4);

    
    FULL_ADDER F3(S5,C6,X5,Y5,C5);
    FULL_ADDER F4(S6,C7,X6,Y6,C6);
    FULL_ADDER F5(S7,C8,X7,Y7,C7);

endmodule