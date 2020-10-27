
CREATE TABLE tbl_ems(
id	NUMBER	NOT NULL	PRIMARY KEY,
from_email	nVARCHAR2(30)	NOT NULL,	
to_email	nVARCHAR2(30)	NOT NULL,	
s_date	nVARCHAR2(10)		,
s_time	nVARCHAR2(10)		,
s_subject	nVARCHAR2(125)	,	
s_content	nVARCHAR2(2000)	,	
s_file1	nVARCHAR2(125)		,
s_file2	nVARCHAR2(125)		
);

create SEQUENCE seq_ems start WITH 1 INCREMENT by 1;

commit;


select * from tbl_ems;