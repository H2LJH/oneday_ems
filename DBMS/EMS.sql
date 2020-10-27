
CREATE TABLE tbl_ems(
id	NUMBER	NOT NULL	PRIMARY KEY,
from_email	nVARCHAR2(30)	NOT NULL,	
to_email	nVARCHAR2(30)	NOT NULL,	
s_date	nVARCHAR2(10)		,
s_time	nVARCHAR2(10)		,
s_subject	nVARCHAR2(125)	,	
s_content	nVARCHAR2(2000)		
);
create Table tbl_file(
id	NUMBER	PRIMARY key,
s_id number NOT NULL,
s_file	nVARCHAR2(125)	
);
create SEQUENCE seq_ems start WITH 1 INCREMENT by 1;
create SEQUENCE seq_file start WITH 1 INCREMENT by 1;

drop table tbl_ems;
drop table tbl_file;
drop SEQUENCE seq_ems;
drop SEQUENCE seq_file;

select * from tbl_ems;
select * from tbl_file;

select ems.id, files.s_file 
    from tbl_file files 
        left join tbl_ems ems on ems.id = files.s_id
            where files.s_file is not null;
        
commit;