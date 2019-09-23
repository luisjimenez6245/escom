// Verilog netlist produced by program LSE :  version Diamond (64-bit) 3.11.0.396.4
// Netlist written on Sun Sep 22 21:13:39 2019
//
// Verilog Description of module Compuertas
//

module Compuertas (input_number, display);   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(5[8:18])
    input [3:0]input_number;   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(7[3:15])
    output [6:0]display;   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(8[3:10])
    
    
    wire input_number_c_3, input_number_c_2, input_number_c_1, input_number_c_0, 
        display_c_6, display_c_5, display_c_4, display_c_3, display_c_2, 
        display_c_1, display_c_0, VCC_net, GND_net;
    
    VLO i127 (.Z(GND_net));
    GSR GSR_INST (.GSR(VCC_net));
    LUT4 input_number_c_1_bdd_4_lut (.A(input_number_c_1), .B(input_number_c_0), 
         .C(input_number_c_3), .D(input_number_c_2), .Z(display_c_0)) /* synthesis lut_function=(A+(B (C+(D))+!B !(C (D)+!C !(D)))) */ ;
    defparam input_number_c_1_bdd_4_lut.init = 16'heffa;
    TSALL TSALL_INST (.TSALL(GND_net));
    LUT4 input_number_c_3_bdd_4_lut (.A(input_number_c_3), .B(input_number_c_2), 
         .C(input_number_c_0), .D(input_number_c_1), .Z(display_c_3)) /* synthesis lut_function=(!(A (B (C (D))+!B !(C (D)+!C !(D)))+!A (B (C (D)+!C !(D))+!B !((D)+!C)))) */ ;
    defparam input_number_c_3_bdd_4_lut.init = 16'h3dcb;
    IB input_number_pad_0 (.I(input_number[0]), .O(input_number_c_0));   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(7[3:15])
    IB input_number_pad_1 (.I(input_number[1]), .O(input_number_c_1));   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(7[3:15])
    IB input_number_pad_2 (.I(input_number[2]), .O(input_number_c_2));   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(7[3:15])
    IB input_number_pad_3 (.I(input_number[3]), .O(input_number_c_3));   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(7[3:15])
    OB display_pad_0 (.I(display_c_0), .O(display[0]));   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(8[3:10])
    LUT4 input_number_c_2_bdd_4_lut (.A(input_number_c_2), .B(input_number_c_3), 
         .C(input_number_c_1), .D(input_number_c_0), .Z(display_c_1)) /* synthesis lut_function=(A (B (C+!(D))+!B !(C (D)))+!A (B+!(C))) */ ;
    defparam input_number_c_2_bdd_4_lut.init = 16'hc7ef;
    OB display_pad_1 (.I(display_c_1), .O(display[1]));   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(8[3:10])
    OB display_pad_2 (.I(display_c_2), .O(display[2]));   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(8[3:10])
    LUT4 input_number_c_0_bdd_4_lut (.A(input_number_c_0), .B(input_number_c_3), 
         .C(input_number_c_2), .D(input_number_c_1), .Z(display_c_2)) /* synthesis lut_function=(A (B (C+(D))+!B !(C+(D)))+!A (B+((D)+!C))) */ ;
    defparam input_number_c_0_bdd_4_lut.init = 16'hddc7;
    OB display_pad_3 (.I(display_c_3), .O(display[3]));   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(8[3:10])
    OB display_pad_4 (.I(display_c_4), .O(display[4]));   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(8[3:10])
    OB display_pad_5 (.I(display_c_5), .O(display[5]));   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(8[3:10])
    LUT4 input_number_c_0_bdd_4_lut_126 (.A(input_number_c_0), .B(input_number_c_3), 
         .C(input_number_c_2), .D(input_number_c_1), .Z(display_c_4)) /* synthesis lut_function=(!(A (B (C (D))+!B !(C+(D)))+!A (B (C)+!B !(C+!(D))))) */ ;
    defparam input_number_c_0_bdd_4_lut_126.init = 16'h3ebd;
    OB display_pad_6 (.I(display_c_6), .O(display[6]));   // c:/users/luisj/documents/github/escom/fdd/segments1.vhd(8[3:10])
    LUT4 input_number_c_3_bdd_4_lut_125 (.A(input_number_c_3), .B(input_number_c_2), 
         .C(input_number_c_0), .D(input_number_c_1), .Z(display_c_5)) /* synthesis lut_function=(!(A (B ((D)+!C)+!B (C (D)))+!A !(B (C (D)+!C !(D))+!B ((D)+!C)))) */ ;
    defparam input_number_c_3_bdd_4_lut_125.init = 16'h53a7;
    PUR PUR_INST (.PUR(VCC_net));
    defparam PUR_INST.RST_PULSE = 1;
    LUT4 input_number_c_0_bdd_4_lut_124 (.A(input_number_c_0), .B(input_number_c_3), 
         .C(input_number_c_1), .D(input_number_c_2), .Z(display_c_6)) /* synthesis lut_function=(A (B (C (D)+!C !(D))+!B (C+(D)))+!A (B+(C+!(D)))) */ ;
    defparam input_number_c_0_bdd_4_lut_124.init = 16'hf67d;
    VHI i128 (.Z(VCC_net));
    
endmodule
//
// Verilog Description of module TSALL
// module not written out since it is a black-box. 
//

//
// Verilog Description of module PUR
// module not written out since it is a black-box. 
//

