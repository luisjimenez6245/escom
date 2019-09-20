// Verilog netlist produced by program LSE :  version Diamond (64-bit) 3.11.0.396.4
// Netlist written on Fri Sep 20 02:42:09 2019
//
// Verilog Description of module Compuertas
//

module Compuertas (AI, BI, CI, DI, A, B, C, D, E, F, G);   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(3[8:18])
    input AI;   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(5[3:5])
    input BI;   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(6[3:5])
    input CI;   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(7[3:5])
    input DI;   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(8[3:5])
    output A;   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(9[3:4])
    output B;   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(10[3:4])
    output C;   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(11[3:4])
    output D;   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(12[3:4])
    output E;   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(13[3:4])
    output F;   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(14[3:4])
    output G;   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(15[3:4])
    
    
    wire A_c_c, C_c_c, D_c_c, E_c_c, F_c, G_c, GND_net, VCC_net;
    
    PUR PUR_INST (.PUR(VCC_net));
    defparam PUR_INST.RST_PULSE = 1;
    TSALL TSALL_INST (.TSALL(GND_net));
    VLO i25 (.Z(GND_net));
    OB A_pad (.I(A_c_c), .O(A));   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(9[3:4])
    OB B_pad (.I(E_c_c), .O(B));   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(10[3:4])
    OB C_pad (.I(C_c_c), .O(C));   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(11[3:4])
    OB D_pad (.I(D_c_c), .O(D));   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(12[3:4])
    OB E_pad (.I(E_c_c), .O(E));   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(13[3:4])
    OB F_pad (.I(F_c), .O(F));   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(14[3:4])
    OB G_pad (.I(G_c), .O(G));   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(15[3:4])
    IB A_c_pad (.I(AI), .O(A_c_c));   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(5[3:5])
    IB C_c_pad (.I(BI), .O(C_c_c));   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(6[3:5])
    IB D_c_pad (.I(CI), .O(D_c_c));   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(7[3:5])
    IB E_c_pad (.I(DI), .O(E_c_c));   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(8[3:5])
    GSR GSR_INST (.GSR(VCC_net));
    LUT4 AI_I_0_2_lut (.A(A_c_c), .B(C_c_c), .Z(F_c)) /* synthesis lut_function=(A (B)) */ ;   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(25[7:16])
    defparam AI_I_0_2_lut.init = 16'h8888;
    LUT4 DI_I_0_2_lut (.A(E_c_c), .B(D_c_c), .Z(G_c)) /* synthesis lut_function=(A (B)) */ ;   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(26[7:16])
    defparam DI_I_0_2_lut.init = 16'h8888;
    VHI i26 (.Z(VCC_net));
    
endmodule
//
// Verilog Description of module PUR
// module not written out since it is a black-box. 
//

//
// Verilog Description of module TSALL
// module not written out since it is a black-box. 
//

