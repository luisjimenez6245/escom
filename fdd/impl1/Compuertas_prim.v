// Verilog netlist produced by program LSE :  version Diamond (64-bit) 3.11.0.396.4
// Netlist written on Fri Sep 20 01:06:32 2019
//
// Verilog Description of module Compuertas
//

module Compuertas (A, B);   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(3[8:18])
    input A;   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(5[3:4])
    input B;   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(6[3:4])
    
    
    wire GND_net, VCC_net;
    
    VLO i23 (.Z(GND_net));
    GSR GSR_INST (.GSR(VCC_net));
    TSALL TSALL_INST (.TSALL(GND_net));
    PUR PUR_INST (.PUR(VCC_net));
    defparam PUR_INST.RST_PULSE = 1;
    VHI i24 (.Z(VCC_net));
    
endmodule
//
// Verilog Description of module TSALL
// module not written out since it is a black-box. 
//

//
// Verilog Description of module PUR
// module not written out since it is a black-box. 
//

