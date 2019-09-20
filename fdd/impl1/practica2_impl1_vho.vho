
-- VHDL netlist produced by program ldbanno, Version Diamond (64-bit) 3.11.0.396.4

-- ldbanno -n VHDL -o practica2_impl1_vho.vho -w -neg -gui -msgset C:/Users/luisj/Documents/GitHub/escom/fdd/promote.xml practica2_impl1.ncd 
-- Netlist created on Fri Sep 20 02:42:24 2019
-- Netlist written on Fri Sep 20 02:42:38 2019
-- Design is for device LCMXO2-7000HE
-- Design is for package TQFP144
-- Design is for performance grade 5

-- entity lut4
  library IEEE, vital2000, MACHXO2;
  use IEEE.STD_LOGIC_1164.all;
  use vital2000.vital_timing.all;
  use MACHXO2.COMPONENTS.ALL;

  entity lut4 is
    port (A: in Std_logic; B: in Std_logic; C: in Std_logic; D: in Std_logic; 
          Z: out Std_logic);

    ATTRIBUTE Vital_Level0 OF lut4 : ENTITY IS TRUE;

  end lut4;

  architecture Structure of lut4 is
  begin
    INST10: ROM16X1A
      generic map (initval => X"C0C0")
      port map (AD0=>A, AD1=>B, AD2=>C, AD3=>D, DO0=>Z);
  end Structure;

-- entity gnd
  library IEEE, vital2000, MACHXO2;
  use IEEE.STD_LOGIC_1164.all;
  use vital2000.vital_timing.all;
  use MACHXO2.COMPONENTS.ALL;

  entity gnd is
    port (PWR0: out Std_logic);

    ATTRIBUTE Vital_Level0 OF gnd : ENTITY IS TRUE;

  end gnd;

  architecture Structure of gnd is
  begin
    INST1: VLO
      port map (Z=>PWR0);
  end Structure;

-- entity SLICE_0
  library IEEE, vital2000, MACHXO2;
  use IEEE.STD_LOGIC_1164.all;
  use vital2000.vital_timing.all;
  use MACHXO2.COMPONENTS.ALL;

  entity SLICE_0 is
    -- miscellaneous vital GENERICs
    GENERIC (
      TimingChecksOn	: boolean := TRUE;
      XOn           	: boolean := FALSE;
      MsgOn         	: boolean := TRUE;
      InstancePath  	: string := "SLICE_0";

      tipd_C0  	: VitalDelayType01 := (0 ns, 0 ns);
      tipd_B0  	: VitalDelayType01 := (0 ns, 0 ns);
      tpd_C0_F0	 : VitalDelayType01 := (0 ns, 0 ns);
      tpd_B0_F0	 : VitalDelayType01 := (0 ns, 0 ns));

    port (C0: in Std_logic; B0: in Std_logic; F0: out Std_logic);

    ATTRIBUTE Vital_Level0 OF SLICE_0 : ENTITY IS TRUE;

  end SLICE_0;

  architecture Structure of SLICE_0 is
    ATTRIBUTE Vital_Level0 OF Structure : ARCHITECTURE IS TRUE;

    signal C0_ipd 	: std_logic := 'X';
    signal B0_ipd 	: std_logic := 'X';
    signal F0_out 	: std_logic := 'X';

    signal GNDI: Std_logic;
    component lut4
      port (A: in Std_logic; B: in Std_logic; C: in Std_logic; D: in Std_logic; 
            Z: out Std_logic);
    end component;
    component gnd
      port (PWR0: out Std_logic);
    end component;
  begin
    AI_I_0_2_lut: lut4
      port map (A=>GNDI, B=>B0_ipd, C=>C0_ipd, D=>GNDI, Z=>F0_out);
    DRIVEGND: gnd
      port map (PWR0=>GNDI);

    --  INPUT PATH DELAYs
    WireDelay : BLOCK
    BEGIN
      VitalWireDelay(C0_ipd, C0, tipd_C0);
      VitalWireDelay(B0_ipd, B0, tipd_B0);
    END BLOCK;

    VitalBehavior : PROCESS (C0_ipd, B0_ipd, F0_out)
    VARIABLE F0_zd         	: std_logic := 'X';
    VARIABLE F0_GlitchData 	: VitalGlitchDataType;


    BEGIN

    IF (TimingChecksOn) THEN

    END IF;

    F0_zd 	:= F0_out;

    VitalPathDelay01 (
      OutSignal => F0, OutSignalName => "F0", OutTemp => F0_zd,
      Paths      => (0 => (InputChangeTime => C0_ipd'last_event,
                           PathDelay => tpd_C0_F0,
                           PathCondition => TRUE),
                     1 => (InputChangeTime => B0_ipd'last_event,
                           PathDelay => tpd_B0_F0,
                           PathCondition => TRUE)),
      GlitchData => F0_GlitchData,
      Mode       => ondetect, XOn => XOn, MsgOn => MsgOn);

    END PROCESS;

  end Structure;

-- entity SLICE_1
  library IEEE, vital2000, MACHXO2;
  use IEEE.STD_LOGIC_1164.all;
  use vital2000.vital_timing.all;
  use MACHXO2.COMPONENTS.ALL;

  entity SLICE_1 is
    -- miscellaneous vital GENERICs
    GENERIC (
      TimingChecksOn	: boolean := TRUE;
      XOn           	: boolean := FALSE;
      MsgOn         	: boolean := TRUE;
      InstancePath  	: string := "SLICE_1";

      tipd_C0  	: VitalDelayType01 := (0 ns, 0 ns);
      tipd_B0  	: VitalDelayType01 := (0 ns, 0 ns);
      tpd_C0_F0	 : VitalDelayType01 := (0 ns, 0 ns);
      tpd_B0_F0	 : VitalDelayType01 := (0 ns, 0 ns));

    port (C0: in Std_logic; B0: in Std_logic; F0: out Std_logic);

    ATTRIBUTE Vital_Level0 OF SLICE_1 : ENTITY IS TRUE;

  end SLICE_1;

  architecture Structure of SLICE_1 is
    ATTRIBUTE Vital_Level0 OF Structure : ARCHITECTURE IS TRUE;

    signal C0_ipd 	: std_logic := 'X';
    signal B0_ipd 	: std_logic := 'X';
    signal F0_out 	: std_logic := 'X';

    signal GNDI: Std_logic;
    component lut4
      port (A: in Std_logic; B: in Std_logic; C: in Std_logic; D: in Std_logic; 
            Z: out Std_logic);
    end component;
    component gnd
      port (PWR0: out Std_logic);
    end component;
  begin
    DI_I_0_2_lut: lut4
      port map (A=>GNDI, B=>B0_ipd, C=>C0_ipd, D=>GNDI, Z=>F0_out);
    DRIVEGND: gnd
      port map (PWR0=>GNDI);

    --  INPUT PATH DELAYs
    WireDelay : BLOCK
    BEGIN
      VitalWireDelay(C0_ipd, C0, tipd_C0);
      VitalWireDelay(B0_ipd, B0, tipd_B0);
    END BLOCK;

    VitalBehavior : PROCESS (C0_ipd, B0_ipd, F0_out)
    VARIABLE F0_zd         	: std_logic := 'X';
    VARIABLE F0_GlitchData 	: VitalGlitchDataType;


    BEGIN

    IF (TimingChecksOn) THEN

    END IF;

    F0_zd 	:= F0_out;

    VitalPathDelay01 (
      OutSignal => F0, OutSignalName => "F0", OutTemp => F0_zd,
      Paths      => (0 => (InputChangeTime => C0_ipd'last_event,
                           PathDelay => tpd_C0_F0,
                           PathCondition => TRUE),
                     1 => (InputChangeTime => B0_ipd'last_event,
                           PathDelay => tpd_B0_F0,
                           PathCondition => TRUE)),
      GlitchData => F0_GlitchData,
      Mode       => ondetect, XOn => XOn, MsgOn => MsgOn);

    END PROCESS;

  end Structure;

-- entity xo2iobuf
  library IEEE, vital2000, MACHXO2;
  use IEEE.STD_LOGIC_1164.all;
  use vital2000.vital_timing.all;
  use MACHXO2.COMPONENTS.ALL;

  entity xo2iobuf is
    port (I: in Std_logic; T: in Std_logic; PAD: out Std_logic);

    ATTRIBUTE Vital_Level0 OF xo2iobuf : ENTITY IS TRUE;

  end xo2iobuf;

  architecture Structure of xo2iobuf is
  begin
    INST5: OBZPD
      port map (I=>I, T=>T, O=>PAD);
  end Structure;

-- entity AB
  library IEEE, vital2000, MACHXO2;
  use IEEE.STD_LOGIC_1164.all;
  use vital2000.vital_timing.all;
  use MACHXO2.COMPONENTS.ALL;

  entity AB is
    -- miscellaneous vital GENERICs
    GENERIC (
      TimingChecksOn	: boolean := TRUE;
      XOn           	: boolean := FALSE;
      MsgOn         	: boolean := TRUE;
      InstancePath  	: string := "AB";

      tipd_PADDO  	: VitalDelayType01 := (0 ns, 0 ns);
      tpd_PADDO_AS	 : VitalDelayType01 := (0 ns, 0 ns));

    port (PADDO: in Std_logic; AS: out Std_logic);

    ATTRIBUTE Vital_Level0 OF AB : ENTITY IS TRUE;

  end AB;

  architecture Structure of AB is
    ATTRIBUTE Vital_Level0 OF Structure : ARCHITECTURE IS TRUE;

    signal PADDO_ipd 	: std_logic := 'X';
    signal AS_out 	: std_logic := 'X';

    signal GNDI: Std_logic;
    component gnd
      port (PWR0: out Std_logic);
    end component;
    component xo2iobuf
      port (I: in Std_logic; T: in Std_logic; PAD: out Std_logic);
    end component;
  begin
    A_pad: xo2iobuf
      port map (I=>PADDO_ipd, T=>GNDI, PAD=>AS_out);
    DRIVEGND: gnd
      port map (PWR0=>GNDI);

    --  INPUT PATH DELAYs
    WireDelay : BLOCK
    BEGIN
      VitalWireDelay(PADDO_ipd, PADDO, tipd_PADDO);
    END BLOCK;

    VitalBehavior : PROCESS (PADDO_ipd, AS_out)
    VARIABLE AS_zd         	: std_logic := 'X';
    VARIABLE AS_GlitchData 	: VitalGlitchDataType;


    BEGIN

    IF (TimingChecksOn) THEN

    END IF;

    AS_zd 	:= AS_out;

    VitalPathDelay01 (
      OutSignal => AS, OutSignalName => "AS", OutTemp => AS_zd,
      Paths      => (0 => (InputChangeTime => PADDO_ipd'last_event,
                           PathDelay => tpd_PADDO_AS,
                           PathCondition => TRUE)),
      GlitchData => AS_GlitchData,
      Mode       => vitaltransport, XOn => XOn, MsgOn => MsgOn);

    END PROCESS;

  end Structure;

-- entity BB0
  library IEEE, vital2000, MACHXO2;
  use IEEE.STD_LOGIC_1164.all;
  use vital2000.vital_timing.all;
  use MACHXO2.COMPONENTS.ALL;

  entity BB0 is
    -- miscellaneous vital GENERICs
    GENERIC (
      TimingChecksOn	: boolean := TRUE;
      XOn           	: boolean := FALSE;
      MsgOn         	: boolean := TRUE;
      InstancePath  	: string := "BB0";

      tipd_PADDO  	: VitalDelayType01 := (0 ns, 0 ns);
      tpd_PADDO_BS	 : VitalDelayType01 := (0 ns, 0 ns));

    port (PADDO: in Std_logic; BS: out Std_logic);

    ATTRIBUTE Vital_Level0 OF BB0 : ENTITY IS TRUE;

  end BB0;

  architecture Structure of BB0 is
    ATTRIBUTE Vital_Level0 OF Structure : ARCHITECTURE IS TRUE;

    signal PADDO_ipd 	: std_logic := 'X';
    signal BS_out 	: std_logic := 'X';

    signal GNDI: Std_logic;
    component gnd
      port (PWR0: out Std_logic);
    end component;
    component xo2iobuf
      port (I: in Std_logic; T: in Std_logic; PAD: out Std_logic);
    end component;
  begin
    B_pad: xo2iobuf
      port map (I=>PADDO_ipd, T=>GNDI, PAD=>BS_out);
    DRIVEGND: gnd
      port map (PWR0=>GNDI);

    --  INPUT PATH DELAYs
    WireDelay : BLOCK
    BEGIN
      VitalWireDelay(PADDO_ipd, PADDO, tipd_PADDO);
    END BLOCK;

    VitalBehavior : PROCESS (PADDO_ipd, BS_out)
    VARIABLE BS_zd         	: std_logic := 'X';
    VARIABLE BS_GlitchData 	: VitalGlitchDataType;


    BEGIN

    IF (TimingChecksOn) THEN

    END IF;

    BS_zd 	:= BS_out;

    VitalPathDelay01 (
      OutSignal => BS, OutSignalName => "BS", OutTemp => BS_zd,
      Paths      => (0 => (InputChangeTime => PADDO_ipd'last_event,
                           PathDelay => tpd_PADDO_BS,
                           PathCondition => TRUE)),
      GlitchData => BS_GlitchData,
      Mode       => vitaltransport, XOn => XOn, MsgOn => MsgOn);

    END PROCESS;

  end Structure;

-- entity CB
  library IEEE, vital2000, MACHXO2;
  use IEEE.STD_LOGIC_1164.all;
  use vital2000.vital_timing.all;
  use MACHXO2.COMPONENTS.ALL;

  entity CB is
    -- miscellaneous vital GENERICs
    GENERIC (
      TimingChecksOn	: boolean := TRUE;
      XOn           	: boolean := FALSE;
      MsgOn         	: boolean := TRUE;
      InstancePath  	: string := "CB";

      tipd_PADDO  	: VitalDelayType01 := (0 ns, 0 ns);
      tpd_PADDO_CS	 : VitalDelayType01 := (0 ns, 0 ns));

    port (PADDO: in Std_logic; CS: out Std_logic);

    ATTRIBUTE Vital_Level0 OF CB : ENTITY IS TRUE;

  end CB;

  architecture Structure of CB is
    ATTRIBUTE Vital_Level0 OF Structure : ARCHITECTURE IS TRUE;

    signal PADDO_ipd 	: std_logic := 'X';
    signal CS_out 	: std_logic := 'X';

    signal GNDI: Std_logic;
    component gnd
      port (PWR0: out Std_logic);
    end component;
    component xo2iobuf
      port (I: in Std_logic; T: in Std_logic; PAD: out Std_logic);
    end component;
  begin
    C_pad: xo2iobuf
      port map (I=>PADDO_ipd, T=>GNDI, PAD=>CS_out);
    DRIVEGND: gnd
      port map (PWR0=>GNDI);

    --  INPUT PATH DELAYs
    WireDelay : BLOCK
    BEGIN
      VitalWireDelay(PADDO_ipd, PADDO, tipd_PADDO);
    END BLOCK;

    VitalBehavior : PROCESS (PADDO_ipd, CS_out)
    VARIABLE CS_zd         	: std_logic := 'X';
    VARIABLE CS_GlitchData 	: VitalGlitchDataType;


    BEGIN

    IF (TimingChecksOn) THEN

    END IF;

    CS_zd 	:= CS_out;

    VitalPathDelay01 (
      OutSignal => CS, OutSignalName => "CS", OutTemp => CS_zd,
      Paths      => (0 => (InputChangeTime => PADDO_ipd'last_event,
                           PathDelay => tpd_PADDO_CS,
                           PathCondition => TRUE)),
      GlitchData => CS_GlitchData,
      Mode       => vitaltransport, XOn => XOn, MsgOn => MsgOn);

    END PROCESS;

  end Structure;

-- entity DB
  library IEEE, vital2000, MACHXO2;
  use IEEE.STD_LOGIC_1164.all;
  use vital2000.vital_timing.all;
  use MACHXO2.COMPONENTS.ALL;

  entity DB is
    -- miscellaneous vital GENERICs
    GENERIC (
      TimingChecksOn	: boolean := TRUE;
      XOn           	: boolean := FALSE;
      MsgOn         	: boolean := TRUE;
      InstancePath  	: string := "DB";

      tipd_PADDO  	: VitalDelayType01 := (0 ns, 0 ns);
      tpd_PADDO_DS	 : VitalDelayType01 := (0 ns, 0 ns));

    port (PADDO: in Std_logic; DS: out Std_logic);

    ATTRIBUTE Vital_Level0 OF DB : ENTITY IS TRUE;

  end DB;

  architecture Structure of DB is
    ATTRIBUTE Vital_Level0 OF Structure : ARCHITECTURE IS TRUE;

    signal PADDO_ipd 	: std_logic := 'X';
    signal DS_out 	: std_logic := 'X';

    signal GNDI: Std_logic;
    component gnd
      port (PWR0: out Std_logic);
    end component;
    component xo2iobuf
      port (I: in Std_logic; T: in Std_logic; PAD: out Std_logic);
    end component;
  begin
    D_pad: xo2iobuf
      port map (I=>PADDO_ipd, T=>GNDI, PAD=>DS_out);
    DRIVEGND: gnd
      port map (PWR0=>GNDI);

    --  INPUT PATH DELAYs
    WireDelay : BLOCK
    BEGIN
      VitalWireDelay(PADDO_ipd, PADDO, tipd_PADDO);
    END BLOCK;

    VitalBehavior : PROCESS (PADDO_ipd, DS_out)
    VARIABLE DS_zd         	: std_logic := 'X';
    VARIABLE DS_GlitchData 	: VitalGlitchDataType;


    BEGIN

    IF (TimingChecksOn) THEN

    END IF;

    DS_zd 	:= DS_out;

    VitalPathDelay01 (
      OutSignal => DS, OutSignalName => "DS", OutTemp => DS_zd,
      Paths      => (0 => (InputChangeTime => PADDO_ipd'last_event,
                           PathDelay => tpd_PADDO_DS,
                           PathCondition => TRUE)),
      GlitchData => DS_GlitchData,
      Mode       => vitaltransport, XOn => XOn, MsgOn => MsgOn);

    END PROCESS;

  end Structure;

-- entity EB
  library IEEE, vital2000, MACHXO2;
  use IEEE.STD_LOGIC_1164.all;
  use vital2000.vital_timing.all;
  use MACHXO2.COMPONENTS.ALL;

  entity EB is
    -- miscellaneous vital GENERICs
    GENERIC (
      TimingChecksOn	: boolean := TRUE;
      XOn           	: boolean := FALSE;
      MsgOn         	: boolean := TRUE;
      InstancePath  	: string := "EB";

      tipd_PADDO  	: VitalDelayType01 := (0 ns, 0 ns);
      tpd_PADDO_ES	 : VitalDelayType01 := (0 ns, 0 ns));

    port (PADDO: in Std_logic; ES: out Std_logic);

    ATTRIBUTE Vital_Level0 OF EB : ENTITY IS TRUE;

  end EB;

  architecture Structure of EB is
    ATTRIBUTE Vital_Level0 OF Structure : ARCHITECTURE IS TRUE;

    signal PADDO_ipd 	: std_logic := 'X';
    signal ES_out 	: std_logic := 'X';

    signal GNDI: Std_logic;
    component gnd
      port (PWR0: out Std_logic);
    end component;
    component xo2iobuf
      port (I: in Std_logic; T: in Std_logic; PAD: out Std_logic);
    end component;
  begin
    E_pad: xo2iobuf
      port map (I=>PADDO_ipd, T=>GNDI, PAD=>ES_out);
    DRIVEGND: gnd
      port map (PWR0=>GNDI);

    --  INPUT PATH DELAYs
    WireDelay : BLOCK
    BEGIN
      VitalWireDelay(PADDO_ipd, PADDO, tipd_PADDO);
    END BLOCK;

    VitalBehavior : PROCESS (PADDO_ipd, ES_out)
    VARIABLE ES_zd         	: std_logic := 'X';
    VARIABLE ES_GlitchData 	: VitalGlitchDataType;


    BEGIN

    IF (TimingChecksOn) THEN

    END IF;

    ES_zd 	:= ES_out;

    VitalPathDelay01 (
      OutSignal => ES, OutSignalName => "ES", OutTemp => ES_zd,
      Paths      => (0 => (InputChangeTime => PADDO_ipd'last_event,
                           PathDelay => tpd_PADDO_ES,
                           PathCondition => TRUE)),
      GlitchData => ES_GlitchData,
      Mode       => vitaltransport, XOn => XOn, MsgOn => MsgOn);

    END PROCESS;

  end Structure;

-- entity FB
  library IEEE, vital2000, MACHXO2;
  use IEEE.STD_LOGIC_1164.all;
  use vital2000.vital_timing.all;
  use MACHXO2.COMPONENTS.ALL;

  entity FB is
    -- miscellaneous vital GENERICs
    GENERIC (
      TimingChecksOn	: boolean := TRUE;
      XOn           	: boolean := FALSE;
      MsgOn         	: boolean := TRUE;
      InstancePath  	: string := "FB";

      tipd_PADDO  	: VitalDelayType01 := (0 ns, 0 ns);
      tpd_PADDO_FS	 : VitalDelayType01 := (0 ns, 0 ns));

    port (PADDO: in Std_logic; FS: out Std_logic);

    ATTRIBUTE Vital_Level0 OF FB : ENTITY IS TRUE;

  end FB;

  architecture Structure of FB is
    ATTRIBUTE Vital_Level0 OF Structure : ARCHITECTURE IS TRUE;

    signal PADDO_ipd 	: std_logic := 'X';
    signal FS_out 	: std_logic := 'X';

    signal GNDI: Std_logic;
    component gnd
      port (PWR0: out Std_logic);
    end component;
    component xo2iobuf
      port (I: in Std_logic; T: in Std_logic; PAD: out Std_logic);
    end component;
  begin
    F_pad: xo2iobuf
      port map (I=>PADDO_ipd, T=>GNDI, PAD=>FS_out);
    DRIVEGND: gnd
      port map (PWR0=>GNDI);

    --  INPUT PATH DELAYs
    WireDelay : BLOCK
    BEGIN
      VitalWireDelay(PADDO_ipd, PADDO, tipd_PADDO);
    END BLOCK;

    VitalBehavior : PROCESS (PADDO_ipd, FS_out)
    VARIABLE FS_zd         	: std_logic := 'X';
    VARIABLE FS_GlitchData 	: VitalGlitchDataType;


    BEGIN

    IF (TimingChecksOn) THEN

    END IF;

    FS_zd 	:= FS_out;

    VitalPathDelay01 (
      OutSignal => FS, OutSignalName => "FS", OutTemp => FS_zd,
      Paths      => (0 => (InputChangeTime => PADDO_ipd'last_event,
                           PathDelay => tpd_PADDO_FS,
                           PathCondition => TRUE)),
      GlitchData => FS_GlitchData,
      Mode       => vitaltransport, XOn => XOn, MsgOn => MsgOn);

    END PROCESS;

  end Structure;

-- entity GB
  library IEEE, vital2000, MACHXO2;
  use IEEE.STD_LOGIC_1164.all;
  use vital2000.vital_timing.all;
  use MACHXO2.COMPONENTS.ALL;

  entity GB is
    -- miscellaneous vital GENERICs
    GENERIC (
      TimingChecksOn	: boolean := TRUE;
      XOn           	: boolean := FALSE;
      MsgOn         	: boolean := TRUE;
      InstancePath  	: string := "GB";

      tipd_PADDO  	: VitalDelayType01 := (0 ns, 0 ns);
      tpd_PADDO_GS	 : VitalDelayType01 := (0 ns, 0 ns));

    port (PADDO: in Std_logic; GS: out Std_logic);

    ATTRIBUTE Vital_Level0 OF GB : ENTITY IS TRUE;

  end GB;

  architecture Structure of GB is
    ATTRIBUTE Vital_Level0 OF Structure : ARCHITECTURE IS TRUE;

    signal PADDO_ipd 	: std_logic := 'X';
    signal GS_out 	: std_logic := 'X';

    signal GNDI: Std_logic;
    component gnd
      port (PWR0: out Std_logic);
    end component;
    component xo2iobuf
      port (I: in Std_logic; T: in Std_logic; PAD: out Std_logic);
    end component;
  begin
    G_pad: xo2iobuf
      port map (I=>PADDO_ipd, T=>GNDI, PAD=>GS_out);
    DRIVEGND: gnd
      port map (PWR0=>GNDI);

    --  INPUT PATH DELAYs
    WireDelay : BLOCK
    BEGIN
      VitalWireDelay(PADDO_ipd, PADDO, tipd_PADDO);
    END BLOCK;

    VitalBehavior : PROCESS (PADDO_ipd, GS_out)
    VARIABLE GS_zd         	: std_logic := 'X';
    VARIABLE GS_GlitchData 	: VitalGlitchDataType;


    BEGIN

    IF (TimingChecksOn) THEN

    END IF;

    GS_zd 	:= GS_out;

    VitalPathDelay01 (
      OutSignal => GS, OutSignalName => "GS", OutTemp => GS_zd,
      Paths      => (0 => (InputChangeTime => PADDO_ipd'last_event,
                           PathDelay => tpd_PADDO_GS,
                           PathCondition => TRUE)),
      GlitchData => GS_GlitchData,
      Mode       => vitaltransport, XOn => XOn, MsgOn => MsgOn);

    END PROCESS;

  end Structure;

-- entity xo2iobuf0001
  library IEEE, vital2000, MACHXO2;
  use IEEE.STD_LOGIC_1164.all;
  use vital2000.vital_timing.all;
  use MACHXO2.COMPONENTS.ALL;

  entity xo2iobuf0001 is
    port (Z: out Std_logic; PAD: in Std_logic);

    ATTRIBUTE Vital_Level0 OF xo2iobuf0001 : ENTITY IS TRUE;

  end xo2iobuf0001;

  architecture Structure of xo2iobuf0001 is
  begin
    INST1: IBPD
      port map (I=>PAD, O=>Z);
  end Structure;

-- entity AIB
  library IEEE, vital2000, MACHXO2;
  use IEEE.STD_LOGIC_1164.all;
  use vital2000.vital_timing.all;
  use MACHXO2.COMPONENTS.ALL;

  entity AIB is
    -- miscellaneous vital GENERICs
    GENERIC (
      TimingChecksOn	: boolean := TRUE;
      XOn           	: boolean := FALSE;
      MsgOn         	: boolean := TRUE;
      InstancePath  	: string := "AIB";

      tipd_AIS  	: VitalDelayType01 := (0 ns, 0 ns);
      tpd_AIS_PADDI	 : VitalDelayType01 := (0 ns, 0 ns);
      tperiod_AIS 	: VitalDelayType := 0 ns;
      tpw_AIS_posedge	: VitalDelayType := 0 ns;
      tpw_AIS_negedge	: VitalDelayType := 0 ns);

    port (PADDI: out Std_logic; AIS: in Std_logic);

    ATTRIBUTE Vital_Level0 OF AIB : ENTITY IS TRUE;

  end AIB;

  architecture Structure of AIB is
    ATTRIBUTE Vital_Level0 OF Structure : ARCHITECTURE IS TRUE;

    signal PADDI_out 	: std_logic := 'X';
    signal AIS_ipd 	: std_logic := 'X';

    component xo2iobuf0001
      port (Z: out Std_logic; PAD: in Std_logic);
    end component;
  begin
    A_c_pad: xo2iobuf0001
      port map (Z=>PADDI_out, PAD=>AIS_ipd);

    --  INPUT PATH DELAYs
    WireDelay : BLOCK
    BEGIN
      VitalWireDelay(AIS_ipd, AIS, tipd_AIS);
    END BLOCK;

    VitalBehavior : PROCESS (PADDI_out, AIS_ipd)
    VARIABLE PADDI_zd         	: std_logic := 'X';
    VARIABLE PADDI_GlitchData 	: VitalGlitchDataType;

    VARIABLE tviol_AIS_AIS          	: x01 := '0';
    VARIABLE periodcheckinfo_AIS	: VitalPeriodDataType;

    BEGIN

    IF (TimingChecksOn) THEN
      VitalPeriodPulseCheck (
        TestSignal => AIS_ipd,
        TestSignalName => "AIS",
        Period => tperiod_AIS,
        PulseWidthHigh => tpw_AIS_posedge,
        PulseWidthLow => tpw_AIS_negedge,
        PeriodData => periodcheckinfo_AIS,
        Violation => tviol_AIS_AIS,
        MsgOn => MsgOn, XOn => XOn,
        HeaderMsg => InstancePath,
        CheckEnabled => TRUE,
        MsgSeverity => warning);

    END IF;

    PADDI_zd 	:= PADDI_out;

    VitalPathDelay01 (
      OutSignal => PADDI, OutSignalName => "PADDI", OutTemp => PADDI_zd,
      Paths      => (0 => (InputChangeTime => AIS_ipd'last_event,
                           PathDelay => tpd_AIS_PADDI,
                           PathCondition => TRUE)),
      GlitchData => PADDI_GlitchData,
      Mode       => vitaltransport, XOn => XOn, MsgOn => MsgOn);

    END PROCESS;

  end Structure;

-- entity BIB
  library IEEE, vital2000, MACHXO2;
  use IEEE.STD_LOGIC_1164.all;
  use vital2000.vital_timing.all;
  use MACHXO2.COMPONENTS.ALL;

  entity BIB is
    -- miscellaneous vital GENERICs
    GENERIC (
      TimingChecksOn	: boolean := TRUE;
      XOn           	: boolean := FALSE;
      MsgOn         	: boolean := TRUE;
      InstancePath  	: string := "BIB";

      tipd_BIS  	: VitalDelayType01 := (0 ns, 0 ns);
      tpd_BIS_PADDI	 : VitalDelayType01 := (0 ns, 0 ns);
      tperiod_BIS 	: VitalDelayType := 0 ns;
      tpw_BIS_posedge	: VitalDelayType := 0 ns;
      tpw_BIS_negedge	: VitalDelayType := 0 ns);

    port (PADDI: out Std_logic; BIS: in Std_logic);

    ATTRIBUTE Vital_Level0 OF BIB : ENTITY IS TRUE;

  end BIB;

  architecture Structure of BIB is
    ATTRIBUTE Vital_Level0 OF Structure : ARCHITECTURE IS TRUE;

    signal PADDI_out 	: std_logic := 'X';
    signal BIS_ipd 	: std_logic := 'X';

    component xo2iobuf0001
      port (Z: out Std_logic; PAD: in Std_logic);
    end component;
  begin
    C_c_pad: xo2iobuf0001
      port map (Z=>PADDI_out, PAD=>BIS_ipd);

    --  INPUT PATH DELAYs
    WireDelay : BLOCK
    BEGIN
      VitalWireDelay(BIS_ipd, BIS, tipd_BIS);
    END BLOCK;

    VitalBehavior : PROCESS (PADDI_out, BIS_ipd)
    VARIABLE PADDI_zd         	: std_logic := 'X';
    VARIABLE PADDI_GlitchData 	: VitalGlitchDataType;

    VARIABLE tviol_BIS_BIS          	: x01 := '0';
    VARIABLE periodcheckinfo_BIS	: VitalPeriodDataType;

    BEGIN

    IF (TimingChecksOn) THEN
      VitalPeriodPulseCheck (
        TestSignal => BIS_ipd,
        TestSignalName => "BIS",
        Period => tperiod_BIS,
        PulseWidthHigh => tpw_BIS_posedge,
        PulseWidthLow => tpw_BIS_negedge,
        PeriodData => periodcheckinfo_BIS,
        Violation => tviol_BIS_BIS,
        MsgOn => MsgOn, XOn => XOn,
        HeaderMsg => InstancePath,
        CheckEnabled => TRUE,
        MsgSeverity => warning);

    END IF;

    PADDI_zd 	:= PADDI_out;

    VitalPathDelay01 (
      OutSignal => PADDI, OutSignalName => "PADDI", OutTemp => PADDI_zd,
      Paths      => (0 => (InputChangeTime => BIS_ipd'last_event,
                           PathDelay => tpd_BIS_PADDI,
                           PathCondition => TRUE)),
      GlitchData => PADDI_GlitchData,
      Mode       => vitaltransport, XOn => XOn, MsgOn => MsgOn);

    END PROCESS;

  end Structure;

-- entity CIB
  library IEEE, vital2000, MACHXO2;
  use IEEE.STD_LOGIC_1164.all;
  use vital2000.vital_timing.all;
  use MACHXO2.COMPONENTS.ALL;

  entity CIB is
    -- miscellaneous vital GENERICs
    GENERIC (
      TimingChecksOn	: boolean := TRUE;
      XOn           	: boolean := FALSE;
      MsgOn         	: boolean := TRUE;
      InstancePath  	: string := "CIB";

      tipd_CIS  	: VitalDelayType01 := (0 ns, 0 ns);
      tpd_CIS_PADDI	 : VitalDelayType01 := (0 ns, 0 ns);
      tperiod_CIS 	: VitalDelayType := 0 ns;
      tpw_CIS_posedge	: VitalDelayType := 0 ns;
      tpw_CIS_negedge	: VitalDelayType := 0 ns);

    port (PADDI: out Std_logic; CIS: in Std_logic);

    ATTRIBUTE Vital_Level0 OF CIB : ENTITY IS TRUE;

  end CIB;

  architecture Structure of CIB is
    ATTRIBUTE Vital_Level0 OF Structure : ARCHITECTURE IS TRUE;

    signal PADDI_out 	: std_logic := 'X';
    signal CIS_ipd 	: std_logic := 'X';

    component xo2iobuf0001
      port (Z: out Std_logic; PAD: in Std_logic);
    end component;
  begin
    D_c_pad: xo2iobuf0001
      port map (Z=>PADDI_out, PAD=>CIS_ipd);

    --  INPUT PATH DELAYs
    WireDelay : BLOCK
    BEGIN
      VitalWireDelay(CIS_ipd, CIS, tipd_CIS);
    END BLOCK;

    VitalBehavior : PROCESS (PADDI_out, CIS_ipd)
    VARIABLE PADDI_zd         	: std_logic := 'X';
    VARIABLE PADDI_GlitchData 	: VitalGlitchDataType;

    VARIABLE tviol_CIS_CIS          	: x01 := '0';
    VARIABLE periodcheckinfo_CIS	: VitalPeriodDataType;

    BEGIN

    IF (TimingChecksOn) THEN
      VitalPeriodPulseCheck (
        TestSignal => CIS_ipd,
        TestSignalName => "CIS",
        Period => tperiod_CIS,
        PulseWidthHigh => tpw_CIS_posedge,
        PulseWidthLow => tpw_CIS_negedge,
        PeriodData => periodcheckinfo_CIS,
        Violation => tviol_CIS_CIS,
        MsgOn => MsgOn, XOn => XOn,
        HeaderMsg => InstancePath,
        CheckEnabled => TRUE,
        MsgSeverity => warning);

    END IF;

    PADDI_zd 	:= PADDI_out;

    VitalPathDelay01 (
      OutSignal => PADDI, OutSignalName => "PADDI", OutTemp => PADDI_zd,
      Paths      => (0 => (InputChangeTime => CIS_ipd'last_event,
                           PathDelay => tpd_CIS_PADDI,
                           PathCondition => TRUE)),
      GlitchData => PADDI_GlitchData,
      Mode       => vitaltransport, XOn => XOn, MsgOn => MsgOn);

    END PROCESS;

  end Structure;

-- entity DIB
  library IEEE, vital2000, MACHXO2;
  use IEEE.STD_LOGIC_1164.all;
  use vital2000.vital_timing.all;
  use MACHXO2.COMPONENTS.ALL;

  entity DIB is
    -- miscellaneous vital GENERICs
    GENERIC (
      TimingChecksOn	: boolean := TRUE;
      XOn           	: boolean := FALSE;
      MsgOn         	: boolean := TRUE;
      InstancePath  	: string := "DIB";

      tipd_DIS  	: VitalDelayType01 := (0 ns, 0 ns);
      tpd_DIS_PADDI	 : VitalDelayType01 := (0 ns, 0 ns);
      tperiod_DIS 	: VitalDelayType := 0 ns;
      tpw_DIS_posedge	: VitalDelayType := 0 ns;
      tpw_DIS_negedge	: VitalDelayType := 0 ns);

    port (PADDI: out Std_logic; DIS: in Std_logic);

    ATTRIBUTE Vital_Level0 OF DIB : ENTITY IS TRUE;

  end DIB;

  architecture Structure of DIB is
    ATTRIBUTE Vital_Level0 OF Structure : ARCHITECTURE IS TRUE;

    signal PADDI_out 	: std_logic := 'X';
    signal DIS_ipd 	: std_logic := 'X';

    component xo2iobuf0001
      port (Z: out Std_logic; PAD: in Std_logic);
    end component;
  begin
    E_c_pad: xo2iobuf0001
      port map (Z=>PADDI_out, PAD=>DIS_ipd);

    --  INPUT PATH DELAYs
    WireDelay : BLOCK
    BEGIN
      VitalWireDelay(DIS_ipd, DIS, tipd_DIS);
    END BLOCK;

    VitalBehavior : PROCESS (PADDI_out, DIS_ipd)
    VARIABLE PADDI_zd         	: std_logic := 'X';
    VARIABLE PADDI_GlitchData 	: VitalGlitchDataType;

    VARIABLE tviol_DIS_DIS          	: x01 := '0';
    VARIABLE periodcheckinfo_DIS	: VitalPeriodDataType;

    BEGIN

    IF (TimingChecksOn) THEN
      VitalPeriodPulseCheck (
        TestSignal => DIS_ipd,
        TestSignalName => "DIS",
        Period => tperiod_DIS,
        PulseWidthHigh => tpw_DIS_posedge,
        PulseWidthLow => tpw_DIS_negedge,
        PeriodData => periodcheckinfo_DIS,
        Violation => tviol_DIS_DIS,
        MsgOn => MsgOn, XOn => XOn,
        HeaderMsg => InstancePath,
        CheckEnabled => TRUE,
        MsgSeverity => warning);

    END IF;

    PADDI_zd 	:= PADDI_out;

    VitalPathDelay01 (
      OutSignal => PADDI, OutSignalName => "PADDI", OutTemp => PADDI_zd,
      Paths      => (0 => (InputChangeTime => DIS_ipd'last_event,
                           PathDelay => tpd_DIS_PADDI,
                           PathCondition => TRUE)),
      GlitchData => PADDI_GlitchData,
      Mode       => vitaltransport, XOn => XOn, MsgOn => MsgOn);

    END PROCESS;

  end Structure;

-- entity Compuertas
  library IEEE, vital2000, MACHXO2;
  use IEEE.STD_LOGIC_1164.all;
  use vital2000.vital_timing.all;
  use MACHXO2.COMPONENTS.ALL;

  entity Compuertas is
    port (AI: in Std_logic; BI: in Std_logic; CI: in Std_logic; 
          DI: in Std_logic; A: out Std_logic; B: out Std_logic; 
          C: out Std_logic; D: out Std_logic; E: out Std_logic; 
          F: out Std_logic; G: out Std_logic);



  end Compuertas;

  architecture Structure of Compuertas is
    signal A_c_c: Std_logic;
    signal C_c_c: Std_logic;
    signal F_c: Std_logic;
    signal E_c_c: Std_logic;
    signal D_c_c: Std_logic;
    signal G_c: Std_logic;
    signal VCCI: Std_logic;
    component SLICE_0
      port (C0: in Std_logic; B0: in Std_logic; F0: out Std_logic);
    end component;
    component SLICE_1
      port (C0: in Std_logic; B0: in Std_logic; F0: out Std_logic);
    end component;
    component AB
      port (PADDO: in Std_logic; AS: out Std_logic);
    end component;
    component BB0
      port (PADDO: in Std_logic; BS: out Std_logic);
    end component;
    component CB
      port (PADDO: in Std_logic; CS: out Std_logic);
    end component;
    component DB
      port (PADDO: in Std_logic; DS: out Std_logic);
    end component;
    component EB
      port (PADDO: in Std_logic; ES: out Std_logic);
    end component;
    component FB
      port (PADDO: in Std_logic; FS: out Std_logic);
    end component;
    component GB
      port (PADDO: in Std_logic; GS: out Std_logic);
    end component;
    component AIB
      port (PADDI: out Std_logic; AIS: in Std_logic);
    end component;
    component BIB
      port (PADDI: out Std_logic; BIS: in Std_logic);
    end component;
    component CIB
      port (PADDI: out Std_logic; CIS: in Std_logic);
    end component;
    component DIB
      port (PADDI: out Std_logic; DIS: in Std_logic);
    end component;
  begin
    SLICE_0I: SLICE_0
      port map (C0=>A_c_c, B0=>C_c_c, F0=>F_c);
    SLICE_1I: SLICE_1
      port map (C0=>E_c_c, B0=>D_c_c, F0=>G_c);
    AI0: AB
      port map (PADDO=>A_c_c, AS=>A);
    BI1: BB0
      port map (PADDO=>E_c_c, BS=>B);
    CI2: CB
      port map (PADDO=>C_c_c, CS=>C);
    DI3: DB
      port map (PADDO=>D_c_c, DS=>D);
    EI: EB
      port map (PADDO=>E_c_c, ES=>E);
    FI: FB
      port map (PADDO=>F_c, FS=>F);
    GI: GB
      port map (PADDO=>G_c, GS=>G);
    AII: AIB
      port map (PADDI=>A_c_c, AIS=>AI);
    BII: BIB
      port map (PADDI=>C_c_c, BIS=>BI);
    CII: CIB
      port map (PADDI=>D_c_c, CIS=>CI);
    DII: DIB
      port map (PADDI=>E_c_c, DIS=>DI);
    VHI_INST: VHI
      port map (Z=>VCCI);
    PUR_INST: PUR
      port map (PUR=>VCCI);
    GSR_INST: GSR
      port map (GSR=>VCCI);
  end Structure;



  library IEEE, vital2000, MACHXO2;
  configuration Structure_CON of Compuertas is
    for Structure
    end for;
  end Structure_CON;


