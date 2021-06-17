alter session set nls_date_language = "SPANISH";
CLEAR SCREEN
SET PAGESIZE 99;
SET LINESIZE 150;
set colsep '|=|';


alter session set nls_date_language = "ENGLISH";


select parameter, value from nls_session_parameters;